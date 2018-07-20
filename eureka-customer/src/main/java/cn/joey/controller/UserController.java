package cn.joey.controller;

import cn.joey.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/get/{id}")
    public User get(@PathVariable("id") Integer id){
        List<ServiceInstance> list = this.client.getInstances("EUREKA-PROVIDER");
        String uri="";
        for (ServiceInstance instance : list) {
            System.out.println(instance.getHost());
            if (instance.getUri() != null && !"".equals(instance.getUri())) {
                uri = instance.getServiceId()+":"+instance.getPort();
                break;
            }
        }
        //加了@LoadBalanced注解后，我们的restTemplate会走RibbonLoadBalanceClient,所以serviceId必须
        //是我们访问的service名称。如：EUREKA-PROVIDER
        //因为ribbon的作用是负载均衡，那么你直接使用ip地址，那么就无法起到负载均衡的作用，
        // 因为每次都是调用同一个服务，当你使用的是服务名称的时候，他会根据自己的算法去选择具有该服务名称的服务。
        System.out.println("http://"+uri+"/provider/user/get/"+id);
        return restTemplate.getForObject("http://"+uri+"/provider/user/get/"+id,User.class);
    }

//    @RequestMapping("/get/{id}")
//    public User get(@PathVariable("id") Integer id){
//        return restTemplate.getForObject("http://EUREKA-PROVIDER/provider/user/get/"+id,User.class);
//    }
}
