package com.shenjg.admin.configuration;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Elasticsearch客户端配置
 *
 * @author shenjg
 * @date 2018/11/20
 */
@Configuration
public class ElasticsearchConfig {

    @Value("${spring.elasticsearch.host}")
    private String host;

    @Value("${spring.elasticsearch.port}")
    private Integer port;

    @Value("${spring.elasticsearch.scheme}")
    private String scheme;

    @Value("${spring.elasticsearch.connection-timeout}")
    private Integer connectionTimeout;

    @Value("${spring.elasticsearch.read-timeout}")
    private Integer readTimeout;

    @Value("${spring.elasticsearch.socket-timout}")
    private Integer socketTimeout;

    @Value("${spring.elasticsearch.connection-request-timout}")
    private Integer connectionRequestTimout;

    @Value("${spring.elasticsearch.max-connection-num}")
    private Integer maxConnectionNum;

    @Value("${spring.elasticsearch.max-connection-per-route}")
    private Integer maxConnectionPerRoute;

    private static String serviceName = "es";

    @Value("${spring.elasticsearch.region}")
    private String region = "cn-northwest-1";

    @Bean
    public RestHighLevelClient restHighLevelClient() {

        // 解析hosts配置，可以配置多个host 地址，使用AWS ES应该只有一个host
        String[] hosts = host.split(",");
        HttpHost[] httpHosts = new HttpHost[hosts.length];
        for (int i = 0; i < hosts.length; i++) {
            httpHosts[i] = new HttpHost(hosts[i], port, scheme);
        }

        // 构建restClientBuilder 并配置
        RestClientBuilder restClientBuilder = RestClient.builder(httpHosts)
                .setHttpClientConfigCallback(n -> {
                    n.setMaxConnTotal(maxConnectionNum);
                    n.setMaxConnPerRoute(maxConnectionPerRoute);
                    return n;
                });

        restClientBuilder.setMaxRetryTimeoutMillis(readTimeout);
        restClientBuilder.setRequestConfigCallback(n -> {
            n.setSocketTimeout(socketTimeout);
            n.setConnectTimeout(connectionTimeout);
            n.setConnectionRequestTimeout(connectionRequestTimout);
            return n;
        });

        return new RestHighLevelClient(restClientBuilder);
    }

}
