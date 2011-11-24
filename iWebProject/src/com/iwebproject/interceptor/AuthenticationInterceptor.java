package com.iwebproject.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iwebproject.common.Constants;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    private List<String> doNotNeedSessionURLs;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object object) throws Exception {
        HttpSession session = request.getSession();
        
        if(session.getAttribute(Constants.USER_ID_SESSION) != null){
            return true;
        }
        
        //就简单判断了一下，如果要详细控制可以用spring security
        String url = request.getRequestURI();
        
        for(String doNotNeedSessionURL : doNotNeedSessionURLs){
            if(url.matches(doNotNeedSessionURL)){
                return true;
            }
        }
        
        response.sendRedirect(request.getContextPath()); 
        
        return false;
        
    }

    public void setDoNotNeedSessionURLs(List<String> doNotNeedSessionURLs) {
        this.doNotNeedSessionURLs = doNotNeedSessionURLs;
    }
}
