package org.lycoding.springTest;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.lycoding.pojo.emp;
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


    @Test
    void saveUser() {
        emp e = new emp("jerry",21);

        System.out.println("e = " + e);
//        手动序列化
        String json = JSON.toJSONString(e);
        System.out.println("json = " +json);

        redisTemplate.opsForValue().set("emp",json);


        String jsonStr = redisTemplate.opsForValue().get("emp");
        System.out.println("jsonStr = " + jsonStr);

//        手动反序列化
        emp em = JSON.parseObject(jsonStr, emp.class);

        System.out.println(em);
    }
}
