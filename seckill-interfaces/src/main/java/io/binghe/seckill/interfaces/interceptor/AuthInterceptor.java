package io.binghe.seckill.interfaces.interceptor;

import io.binghe.seckill.domain.code.HttpCode;
import io.binghe.seckill.domain.constants.SeckillConstants;
import io.binghe.seckill.domain.exception.SeckillException;
import io.binghe.seckill.infrastructure.shiro.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * @author YouChuande
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    public static final String USER_ID = "userId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userId = request.getAttribute(USER_ID);
        if (userId != null) {
            return true;
        }
        String token = request.getHeader(SeckillConstants.TOKEN_HEADER_NAME);
        if (StringUtils.isEmpty(token)) {
            throw new SeckillException(HttpCode.USER_NOT_LOGIN);
        }
        Long userId1 = JwtUtils.getUserId(token);
        if (userId1 == null) {
            throw new SeckillException(HttpCode.USER_NOT_LOGIN);
        }
        HttpServletRequestWrapper authRequestWrapper = new HttpServletRequestWrapper(request);
        authRequestWrapper.setAttribute(USER_ID, userId1);
        return true;
    }
}
