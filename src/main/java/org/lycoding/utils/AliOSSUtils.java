package org.lycoding.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import jdk.jshell.spi.ExecutionControlProvider;
import org.junit.jupiter.api.parallel.Execution;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

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

