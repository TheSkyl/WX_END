package com.auth.authserver.config;

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
//        http.formLogin()    //自定义编写的登录页面
//                .loginPage("/login.html")   //登录页面设置
//                .loginProcessingUrl("/user/login")    //登录的访问路径
//                .defaultSuccessUrl("/index.html").permitAll()  //登录成功后的跳转页面
//                .and().authorizeRequests()          //定义那些url需要认证才能访问，那些不需要认证就能访问
//                    .antMatchers("/","/test/hello","user/login").permitAll()    //访问这几个路径不需要认证
                    //hasAuthority针对需要某个权限才能访问的页面
//                    .antMatchers("/test/admin").hasAuthority("ADMIN")
                    //hasAnyAuthority只要具有"ADMIN","MANAGER"其中一个权限就可以访问/test/admin
//                    .antMatchers("/test/admin").hasAnyAuthority("ADMIN","MANAGER")
                //需要具有sale角色才可以访问test/admin
//                .antMatchers("/test/admin").hasRole("p2")
//                .antMatchers("/test/indexs").hasRole("p1")
//                .antMatchers("/test/manager").hasRole("p3")
//                .anyRequest().authenticated()   //除上面外的所有请求都需要认证才能访问
//                .and().csrf().disable(); //关闭csrf防护
//        http.exceptionHandling().accessDeniedPage("/403.html"); //没有权限就跳转到403页面
        //安全拦截机制
        http
                .authorizeRequests()
                .antMatchers("/actuator/**", "/login", "/exit", "/index","/login/**","/oauth/**", "/favicon.ico", "/swagger/**", "/oauth/token","/").permitAll()
//                .antMatchers(HttpMethod.OPTIONS,"/**")
//                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
//                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .cors().and().csrf().disable();
    }

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
