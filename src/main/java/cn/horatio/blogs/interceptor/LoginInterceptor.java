package cn.horatio.blogs.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author L-Horatio
 * @date 2020/8/3
 * @time 9:43
 */

/**
 * 登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取session
        HttpSession session = request.getSession();
        // 判断uid是否为null
        if (session.getAttribute("uid") == null) {
            // 为null，即没有uid，即没有登陆
            response.sendRedirect("../web/login.html");
            // 拦截
            return false;
        } else {
            // 非null，即存在uid，即已经登陆
            return true;
        }
    }
}
