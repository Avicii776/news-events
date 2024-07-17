package org.lycoding.utils;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class AliOSSUtils {
    final static private String End_Point = "https://oss-cn-hangzhou.aliyuncs.com";
    final static private String OSS_ACCESS_KEY_ID = System.getenv("OSS_ACCESS_KEY_ID");
    final static private String OSS_ACCESS_KEY_SECRET = System.getenv("OSS_ACCESS_KEY_SECRET");
    final static private String Bucket_Name = "bsuc";

    public static String upload(String fileName, InputStream inputStream) throws IOException {
        String url = "";
        try {

            //上传文件到 OSS
            OSS ossClient = new OSSClientBuilder().build(End_Point, OSS_ACCESS_KEY_ID, OSS_ACCESS_KEY_SECRET);
            ossClient.putObject(Bucket_Name, fileName, inputStream);

            //文件访问路径
            url = End_Point.split("//")[0] + "//" + Bucket_Name + "." + End_Point.split("//")[1] + "/" + fileName;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return url;// 把上传到oss的路径返回
    }
}

