package com.wx.wx_auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {


    @Value("${file.uploadFolderBanner}")
    private String uploadFolderBanner;

    @Value("${file.uploadFolderNovel}")
    private String uploadFolderNovel;



    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);

        registry.addResourceHandler(("/profile/novel/**"))
                .addResourceLocations("file:"+uploadFolderNovel);
        registry.addResourceHandler("profile/banner/**")
                .addResourceLocations("file:"+uploadFolderBanner);

    }
}
