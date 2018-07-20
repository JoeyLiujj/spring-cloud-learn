package cn.joey;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {
    @Bean
    @LoadBalanced  //实现负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    public IRule testRule() {
//        return new RandomRule();
//    }
}
