package cn.horatio.blogs.service;

import cn.horatio.blogs.entity.User;
import cn.horatio.blogs.exception.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author L-Horatio
 * @date 2020/7/31
 * @time 22:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestCase {

    @Autowired
    private IUserService userService;

    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("spring");
            user.setPassword("1234");
            user.setGender(1);
            user.setPhone("1365454875");
            user.setEmail("pringMVC2@163.com");
            User result = userService.reg(user);
            System.err.println("result=" + result);
        }catch (ServiceException e) {
            System.err.println("错误类型:" + e.getClass().getName());
            System.err.println("错误描述:" + e.getMessage());
        }
    }

    @Test
    public void login(){
        try {
            String username = "spring";
            String password = "1234";
            User data = userService.login(username, password);
            System.err.println(data);
        }catch (ServiceException e) {
            System.err.println("错误类型:" + e.getClass().getName());
            System.err.println("错误描述:" + e.getMessage());
        }
    }

    @Test
    public void update(){
        try {
            Integer uid = 10;
            String oldPassword = "123456";
            String newPassword = "1234";
            userService.changePassword(uid, oldPassword, newPassword);
            System.err.println("OK!");
        }catch (ServiceException e) {
            System.err.println("错误类型:" + e.getClass().getName());
            System.err.println("错误描述:" + e.getMessage());
        }
    }
}
