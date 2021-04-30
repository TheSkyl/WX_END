package com.wx.lib.controller;

import com.wx.lib.config.WebConfig;
import com.wx.lib.config.WxConfig;
import com.wx.lib.utils.FileUploadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {

    @PostMapping("/banner/upload")
    public String upload(MultipartFile file) throws IOException{
        String filePath = WxConfig.getBannerPath();
        String path = FileUploadUtils.upload(filePath,file);
        return path;
    }


}
