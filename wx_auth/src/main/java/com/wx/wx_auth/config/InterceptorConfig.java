package com.wx.wx_auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

    @Value("${file.uploadFolderBanner}")
    private String uploadFolderBanner;

    @Value("${file.uploadFolderNovel}")
    private String uploadFolderNovel;

    @Resource
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("启动拦截");
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/poetryAuthor/**","/ban/Banner","/test/auths","/img/**","/nov/novel","/famousWorks/**","/chains/getAll","/poetry/**","/profile/**/**","/poetrys/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(("/profile/novel/**"))
                .addResourceLocations("file:"+uploadFolderNovel);
        registry.addResourceHandler("profile/banner/**")
                .addResourceLocations("file:"+uploadFolderBanner);
    }
}
