package org.lycoding.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.*;

import java.io.IOException;

public class elasticsearchTest {
    private RestHighLevelClient client;

    private static final String MAPPING_TAMPLATE="{\n" +
            "  \"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"id\":{\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"index\": true\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";
//    测试es连接
    @Test
    void esTest() {
        System.out.println("client = " + client);
    }

//    测试es创建索引库
    @Test
    void createIndexTest() throws IOException {
//        1、创建一个request对象
        CreateIndexRequest request = new CreateIndexRequest("category");
//        2、
        request.source(MAPPING_TAMPLATE, XContentType.JSON);
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    @BeforeEach //在任意测试类启动初始化之前执行这个方法
    void setUp() {
        client = new RestHighLevelClient(RestClient.builder(
                HttpHost.create("192.168.10.101:9200")
        ));
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null){
            client.close();
        }
    }
}
