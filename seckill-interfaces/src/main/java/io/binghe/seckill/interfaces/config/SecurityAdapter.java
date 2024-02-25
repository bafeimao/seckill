package io.binghe.seckill.interfaces.config;

import io.binghe.seckill.interfaces.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author YouChuande
 */
@Configuration
public class SecurityAdapter implements WebMvcConfigurer {
    @Resource
    private AuthInterceptor authInteceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInteceptor).addPathPatterns("/**")
                .excludePathPatterns("/user/login");
    }
}
