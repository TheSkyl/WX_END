package com.wx.authserver.config;

import com.wx.authserver.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Map;

/**
 * 授权服务配置
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;

    @Autowired
    private AuthenticationManager authenticationManager;
//
    @Autowired
    private JwtAccessTokenConverter accessTokenConverter;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public ClientDetailsService clientDetailsService(DataSource dataSource){
        ClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        ((JdbcClientDetailsService)clientDetailsService).setPasswordEncoder(passwordEncoder);
        return clientDetailsService;
    }

    /**
     * 客户端信息配置
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService);
    }

    //令牌管理服务
//    @Bean
//    public AuthorizationServerTokenServices tokenService(){
//        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
//
//        defaultTokenServices.setClientDetailsService(clientDetailsService); //客户端详情服务
//        defaultTokenServices.setSupportRefreshToken(true);  //支持刷新令牌
//        //令牌增强
//        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
//        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancers(),accessTokenConverter));
//        defaultTokenServices.setTokenEnhancer(tokenEnhancerChain);
//
//        defaultTokenServices.setTokenStore(tokenStore); //令牌存储策略
//        defaultTokenServices.setAccessTokenValiditySeconds(7200);   //令牌有效时间
//        defaultTokenServices.setRefreshTokenValiditySeconds(259200);    //刷钱令牌有效期
//
//        return defaultTokenServices;
//    }

    //授权码存取暂时用内存方式
//    @Bean
//    public AuthorizationCodeServices authorizationCodeServices(){
//        return new InMemoryAuthorizationCodeServices();
//    }
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(DataSource dataSource){
        return new JdbcAuthorizationCodeServices(dataSource);
    }

    @Bean
    public TokenEnhancer tokenEnhancers(){
        return new CustomTokenEnhancer();
    }

//    public static class CustomAccessTokenConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer {
//
//        @Override
//        public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
//            OAuth2Authentication authentication = super.extractAuthentication(map);
//            authentication.setDetails(map);
//            return authentication;
//        }
//
//        @Override
//        public void configure(JwtAccessTokenConverter jwtAccessTokenConverter) {
//            jwtAccessTokenConverter.setAccessTokenConverter(this);
//        }
//    }

    /**
     * 开启jwt令牌服务
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)   //认证管理器
                .authorizationCodeServices(authorizationCodeServices)   //授权码服务
//                .tokenServices(tokenService())  //令牌管理服务
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
        endpoints.userDetailsService(userDetailsService);

        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancers(),accessTokenConverter));

        endpoints.tokenEnhancer(tokenEnhancerChain);

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")      //公开
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();    //表单认证（申请令牌）
    }

//    @Bean
//    public TokenStore tokenStore(){
//        return new JwtTokenStore(accessTokenConverter());
//    }
//
//    @Bean
//    public JwtAccessTokenConverter accessTokenConverter(){
//
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey("AUTH");   //对称密钥，资源服务器使用该密钥进行验证
//        converter.setAccessTokenConverter(new CustomAccessTokenConverter()); //将定制的AccessToken 转换器添加到JWT
//        return converter;
//
//    }

}
