package com.wx.lib.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
public class ResouceServerConfig extends ResourceServerConfigurerAdapter {

    private  static final String RESOURCE_ID ="res1"; //资源服务id

    private static final String SIGNING_KEY="AUTH"; //密钥

    @Autowired
    TokenStore tokenStore;

    /**
     * 资源服务配置信息
     * @param resources
     * @throws Exception
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID)   //资源id
//                .tokenServices(tokenServices())   //验证令牌服务
                .tokenStore(tokenStore) //本地校验令牌
                .stateless(true);   //无状态
    }

    /**
     * web 安全配置
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/**").access("#oauth2.hasScope('ROLE_ADMIN')")   //校验令牌范围是不是all
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * 资源服务令牌解析服务
     * @return
     */
//    @Bean
//    public ResourceServerTokenServices tokenServices(){
//
//        //使用远程服务请求授权服务器校验token，必须指定校验token的url，client_id,client_secret
//        RemoteTokenServices tokenServices = new RemoteTokenServices();
//        tokenServices.setCheckTokenEndpointUrl("http://localhost:53020/oauth/check_token"); //url
//        tokenServices.setClientId("c1");    //客户端id
//        tokenServices.setClientSecret("secret");    //密钥
//        return tokenServices;
//    }


}


