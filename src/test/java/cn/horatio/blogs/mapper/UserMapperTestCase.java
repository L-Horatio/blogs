package cn.horatio.blogs.mapper;

import cn.horatio.blogs.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author L-Horatio
 * @date 2020/7/31
 * @time 20:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTestCase {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void addnew(){
        User user = new User();
        user.setUsername("root");
        user.setPassword("1234");
        user.setPhone("1365454875");
        user.setEmail("163@163.com");
        user.setSalt("sdfsd");
        user.setIsDelete(0);
        Integer rows = userMapper.addnew(user);
        System.err.println("rows=" + rows);
    }

    @Test
    public void findByUsername(){
        String username = "root";
        User user = userMapper.findByUsername(username);
        System.err.println("user=" + user);
    }
}
