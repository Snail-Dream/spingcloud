package com.www.customer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：www
 * @date ：Created in 20-1-3 下午2:49
 * @description：
 * @modified By：
 * @version:
 */
@FeignClient(value = "service" , fallback = ServiceClientFallback.class)  //声明一个接口是feign接口，指定服务id
public interface ServiceClient {
    @GetMapping(value = "service")
    public String service();
}
