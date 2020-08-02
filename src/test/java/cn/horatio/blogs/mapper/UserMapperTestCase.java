package cn.horatio.blogs.mapper;

import cn.horatio.blogs.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

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
    public void updatePassword(){
        Date now = new Date();
        Integer uid = 9;
        String password = "1234";
        String modifiedUser = "root";
        Date modifiedTime = now;
        Integer rows = userMapper.updatePassword(uid, password, modifiedUser, modifiedTime);
        System.err.println("rows=" + rows);
    }

    @Test
    public void findByUsername(){
        String username = "root";
        User user = userMapper.findByUsername(username);
        System.err.println("user=" + user);
    }

    @Test
    public void findById(){
        Integer id = 9;
        User user = userMapper.findById(id);
        System.err.println("user=" + user);
    }
}
