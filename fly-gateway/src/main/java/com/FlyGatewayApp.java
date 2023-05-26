package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class FlyGatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(FlyGatewayApp.class,args);
    }

    @RestController
    public class NacosController{

        @Autowired
        private LoadBalancerClient loadBalancerClient;
        @Autowired
        private RestTemplate restTemplate;

        @Value("${spring.application.name}")
        private String appName;

        @Autowired
        DiscoveryClient discoveryClient;

        @GetMapping("/echo/app-name")
        public String echoAppName(){
            //Access through the combination of LoadBalanceClient and RestTemplate
            List<ServiceInstance> list =  discoveryClient.getInstances("fly-demo-provider");
            ServiceInstance serviceInstance = loadBalancerClient.choose("fly-demo-provider");
            String path = String.format("http://%s:%s/provider/%s",serviceInstance.getHost(),serviceInstance.getPort(),appName);
            System.out.println("request path:" +path);
            return restTemplate.getForObject(path,String.class);
        }

    }

    //Instantiate RestTemplate Instance
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }
}