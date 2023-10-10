package com.buttercms.springstarterbuttercms.controller.interceptor;

import com.buttercms.springstarterbuttercms.service.PageCollectionService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CommonElementsInterceptor implements HandlerInterceptor {

    private final PageCollectionService pageCollectionService;

    public CommonElementsInterceptor(PageCollectionService pageCollectionService) {
        this.pageCollectionService = pageCollectionService;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        if (modelAndView != null) {
            modelAndView.getModel().put(
                    "menuItems", pageCollectionService.getNavigation()
            );
        }
    }
}
