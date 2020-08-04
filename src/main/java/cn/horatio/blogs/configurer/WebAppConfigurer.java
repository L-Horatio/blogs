package cn.horatio.blogs.configurer;

import cn.horatio.blogs.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L-Horatio
 * @date 2020/8/3
 * @time 10:02
 */

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 黑名单
        List<String> pathPatterns = new ArrayList<>();
        pathPatterns.add("/user/**");
        pathPatterns.add("/web/**");

        // 白名单
        List<String> excludePathPatterns = new ArrayList<>();
        excludePathPatterns.add("/user/reg.do");
        excludePathPatterns.add("/user/login.do");
        excludePathPatterns.add("/web/login.html");
        excludePathPatterns.add("/web/register.html");

        // 注册
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(pathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }
}
