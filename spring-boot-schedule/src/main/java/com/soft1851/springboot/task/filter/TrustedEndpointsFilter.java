package com.soft1851.springboot.task.filter;

import org.apache.catalina.connector.RequestFacade;
import org.apache.catalina.connector.ResponseFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName TrustedEndpointsFilter
 * @Description 基于 URL 路径和端口对请求进行过滤
 * @Author 田震
 * @Date 2020/5/16
 **/
public class TrustedEndpointsFilter implements Filter {
    private int trustedPortNum = 0;
    private String trustedPathPrefix;
    private final Logger log = LoggerFactory.getLogger(getClass().getName());


    public TrustedEndpointsFilter(String trustedPort, String trustedPathPrefix) {
        if (trustedPort != null && trustedPathPrefix != null && !"null".equals(trustedPathPrefix)) {
            trustedPortNum = Integer.valueOf(trustedPort);
            this.trustedPathPrefix = trustedPathPrefix;
        }
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (trustedPortNum != 0) {
            // 通过外部端口试图访问内部接口，拒绝请求
            if (isRequestForTrustedEndpoint(servletRequest) && servletRequest.getLocalPort() != trustedPortNum) {
                log.warn("=denying request for trusted endpoint on untrusted port =");
                log.warn("通过外部端口试图访问内部接口,拒绝请求");
                ((ResponseFacade) servletResponse).setStatus(404);
                servletResponse.getOutputStream().close();
                return;
            }


            // 通过内部端口试图访问外部接口，拒绝请求
            if (!isRequestForTrustedEndpoint(servletRequest) && servletRequest.getLocalPort() == trustedPortNum) {
                log.warn("=denying request for untrusted endpoint on trusted port =");
                log.warn("=         通过内部端口试图访问外部接口，拒绝请求           =");
                ((ResponseFacade) servletResponse).setStatus(404);
                servletResponse.getOutputStream().close();
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }


    // 通过 URL 中的路径前缀来判断对应的接口是内部接口还是外部接口
    private boolean isRequestForTrustedEndpoint(ServletRequest servletRequest) {
        return ((RequestFacade) servletRequest).getRequestURI().startsWith(trustedPathPrefix);

    }
}