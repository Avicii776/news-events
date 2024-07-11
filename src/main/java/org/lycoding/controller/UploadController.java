package org.lycoding.controller;

import lombok.extern.slf4j.Slf4j;
import org.lycoding.pojo.Result;
import org.lycoding.utils.AliOSSUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {
    //文件上传
    @PostMapping()
    public Result upload(@RequestBody MultipartFile file) throws IOException {
        System.out.println(file);
        // 避免文件覆盖
        String originalFilename = file.getOriginalFilename();
//        获取文件名
        String fileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));

        InputStream inputStream = file.getInputStream();
        //调用阿里云oss工具类，将上传上来的文件存入阿里云
        String url = AliOSSUtils.upload(fileName, inputStream);
        return Result.success(url);
    }
}
