package com.test.util.interceptor;

import com.test.util.tools.Validator;
import org.springframework.context.MessageSource;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by wangjian on 2017/11/15.
 */
public class ValidatorsInterceptor implements HandlerInterceptor {
    @Resource
    private MessageSource messageSource;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) o;
//        System.out.println("对象："+handlerMethod.getBean().getClass().getSimpleName());
//        System.out.println("方法："+handlerMethod.getMethod().getName());
        try {
            String vkey = handlerMethod.getBean().getClass().getSimpleName() + "." + handlerMethod.getMethod().getName();
            String pkey = handlerMethod.getBean().getClass().getSimpleName() + "." + handlerMethod.getMethod().getName() + ".error";
            String validatorValue = this.messageSource.getMessage(vkey, null, Locale.getDefault());
            String pagesValue = this.messageSource.getMessage(pkey, null, Locale.getDefault());
            if (validatorValue != null) {
                if (new Validator().validate(httpServletRequest, validatorValue)) {
                    return true;
                } else {
                    httpServletRequest.getRequestDispatcher(pagesValue).forward(httpServletRequest, httpServletResponse);
                    return false;
                }
            }
        }catch (Exception e){}
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
