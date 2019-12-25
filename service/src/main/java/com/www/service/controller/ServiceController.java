package com.www.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：www
 * @date ：Created in 19-12-25 下午3:06
 * @description：
 * @modified By：
 * @version:
 */
@RestController
public class ServiceController {
    @GetMapping(value = "service")
    public String service(){
        return "this is service";
    }
}
