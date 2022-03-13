package com.bolsadeideas.springboot.inouttimeinterceptor.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigMVC implements WebMvcConfigurer {

    @Autowired
    @Qualifier("inOutTime")
    private HandlerInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //Se debe excluir la redireccion, porque al redirigir se intercetpará, y se volverá a ejecutar la redirección, entrando a un loop infinito
        registry.addInterceptor(timeInterceptor).excludePathPatterns("/closed");
    }
}
