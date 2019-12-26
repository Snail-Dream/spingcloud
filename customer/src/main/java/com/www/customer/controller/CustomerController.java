package com.www.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author ：www
 * @date ：Created in 19-12-25 下午3:03
 * @description：
 * @modified By：
 * @version:
 */
@RestController
public class CustomerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping(value = "customer")
    public String customer(){
        return "this is customer";
    }
    @GetMapping(value = "select")
    public String select(){
        return restTemplate.getForObject("http://localhost:18092/service",String.class);
    }
    @GetMapping(value = "selectDiscoveryClient")
    public String selectDiscoveryClient(){
        List<ServiceInstance> server = discoveryClient.getInstances("service");
        ServiceInstance serviceInstance = server.get(0);
        return restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/service",String.class);
    }
    /** 
    * @Description:  通过负载均衡调用
    * @Param: [] 
    * @return: java.lang.String 
    * @Author: www
    * @Date: 19-12-26 
    */ 
    @GetMapping(value = "selectFZJH")
    public String selectFZJH(){
        return restTemplate.getForObject("http://service/service",String.class);
    }
}
