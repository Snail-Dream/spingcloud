package com.www.customer.client;

import org.springframework.stereotype.Component;

/**
 * @author ：www
 * @date ：Created in 20-1-3 下午3:16
 * @description：
 * @modified By：
 * @version:
 */
@Component
public class ServiceClientFallback implements ServiceClient{
    @Override
    public String service() {
        return "server error!";
    }
}
