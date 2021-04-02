package com.auth.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 授权服务配置
 */
@Configuration
@EnableAuthorizationServer
@EnableOAuth2Client
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtAccessTokenConverter accessTokenConverter;

    /**
     * 客户端信息配置
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()
                .withClient("c1")   //客户端id
                .secret(new BCryptPasswordEncoder().encode("serr"))//客户端密钥
                .resourceIds("RES")    //资源标识列表
                .authorizedGrantTypes("authorization_code","password","client_credentials","implicit","refresh_token")//客户端允许的授权类型 授权码模式，密码模式，简化模式，客户端模式无法申请刷新令牌
                .scopes("all")//允许授权范围
                .autoApprove(false) //false跳转到授权页面
                //验证回调地址
                .redirectUris("http://www.baidu.com");          //可配置多个客户端
    }

    //令牌管理服务
    @Bean
    public AuthorizationServerTokenServices tokenService(){
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();

        defaultTokenServices.setClientDetailsService(clientDetailsService); //客户端详情服务
        defaultTokenServices.setSupportRefreshToken(true);  //支持刷新令牌
        //令牌增强
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter));
        defaultTokenServices.setTokenEnhancer(tokenEnhancerChain);

        defaultTokenServices.setTokenStore(tokenStore); //令牌存储策略
        defaultTokenServices.setAccessTokenValiditySeconds(7200);   //令牌有效时间
        defaultTokenServices.setRefreshTokenValiditySeconds(259200);    //刷钱令牌有效期

        return defaultTokenServices;
    }

    //授权码存取暂时用内存方式
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(){
        return new InMemoryAuthorizationCodeServices();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
        endpoints
                .authenticationManager(authenticationManager)   //认证管理器
                .authorizationCodeServices(authorizationCodeServices)   //授权码服务
                .tokenServices(tokenService())  //令牌管理服务
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")      //公开
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();    //表单认证（申请令牌）
    }
}
