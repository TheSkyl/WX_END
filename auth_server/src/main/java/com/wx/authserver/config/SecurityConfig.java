package com.wx.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsUtils;

import javax.annotation.Resource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 注入
     * 实现UserDetailsService 接口
     */
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private CustomLogoutSuccessHandler logoutSuccessHandler;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    //认证管理器
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/actuator/**", "/login", "/exit", "/index","/login/**","/oauth/**", "/favicon.ico", "/swagger/**", "/oauth/token","/profile/**").permitAll()
//                .antMatchers(HttpMethod.OPTIONS,"/**")
//                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
//                .permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").failureUrl("/login-error").permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .and()
                .cors().and().csrf().disable();
    }

    /**
     * 跨域
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
        web.ignoring().antMatchers("/actuator/health","/favicon.ico", "/css/**", "/js/**","/images/**", "/fonts/**","/dist/**");
    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        //如果将此设置为
//        //auth.parentAuthenticationManager(authenticationManager);
//        //则出现无限循环问题，暂时设置为null
//        auth.parentAuthenticationManager(null);
//        auth.userDetailsService(userDetailsService);
//    }

}
