package com.www.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：www
 * @date ：Created in 20-1-6 下午2:52
 * @description：
 * @modified By：
 * @version:
 */
@Component
public class LoginFilter extends ZuulFilter {
    /**
    * @Description: 过滤器类型 pre route post error
    * @Param: []
    * @return: java.lang.String
    * @Author: www
    * @Date: 20-1-6
    */
    @Override
    public String filterType() {
        return "pre";
    }
    /** 
    * @Description:  执行顺序越小优先级越高
    * @Param: [] 
    * @return: int 
    * @Author: www
    * @Date: 20-1-6 
    */ 
    @Override
    public int filterOrder() {
        return 10;
    }
    /** 
    * @Description:  是否执行run方法,true:执行run方法
    * @Param: [] 
    * @return: boolean 
    * @Author: www
    * @Date: 20-1-6 
    */ 
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /** 
    * @Description:  编写过滤器的业务逻辑
    * @Param: [] 
    * @return: java.lang.Object 
    * @Author: www
    * @Date: 20-1-6 
    */ 
    @Override
    public Object run() throws ZuulException {
        //初始化context上下文
        RequestContext context = RequestContext.getCurrentContext();
        //获取request对象
        HttpServletRequest request = context.getRequest();
        //获取参数
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)){
            //拦截,不转发请求
            context.setSendZuulResponse(false);
            //响应状态码，401身份未认证
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            //设置响应提示
            context.setResponseBody("Request error");


        }
        return null;
    }
}
