package com.bolsadeideas.springboot.inouttimeinterceptor.app.interceptors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

@Component("inOutTime")
public class InOutTimeInterceptor implements HandlerInterceptor {

    @Value("${config.intime}")
    private Integer inTime;

    @Value("${config.outtime}")
    private Integer outTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Calendar calendar = Calendar.getInstance();
        int actualHour = calendar.get(Calendar.HOUR_OF_DAY);

        if (actualHour >= inTime && actualHour <= outTime) {
            String welcomeMessage = "In this view you can interact with the client portal, from " + inTime + ":00 to " + outTime + ":00";
            request.setAttribute("entryMsg", welcomeMessage);
            return true;
        }
        response.sendRedirect(request.getContextPath().concat("/closed"));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}
