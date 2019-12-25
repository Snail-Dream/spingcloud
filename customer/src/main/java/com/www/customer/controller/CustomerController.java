package com.www.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    @GetMapping(value = "customer")
    public String customer(){
        return "this is customer";
    }
    @GetMapping(value = "select")
    public String select(){
        return restTemplate.getForObject("http://localhost:18092/service",String.class);
    }
}
