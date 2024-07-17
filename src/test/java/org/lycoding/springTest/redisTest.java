package org.lycoding.springTest;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class redisTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    void testStringRedis(){
        redisTemplate.opsForValue().set("name","luxo");

        Object name = redisTemplate.opsForValue().get("my");

        System.out.println("name = " + name);
    }

//    json序列化工具，将对象序列化成一个json字符串



}
