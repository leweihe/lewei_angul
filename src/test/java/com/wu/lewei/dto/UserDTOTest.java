package com.wu.lewei.dto;

import com.wu.lewei.Application;
import com.wu.lewei.repo.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by cn40580 at 2016-10-12 9:09 AM.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserDTOTest {


    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
    }


    @Test
    public void test() throws Exception {

        // 创建三个User，并验证User总数
        userRepository.save(new UserDTO("didi", 30));
        userRepository.save(new UserDTO("mama", 40));
        userRepository.save(new UserDTO("kaka", 50));
        Assert.assertEquals(3, userRepository.findAll().size());

        // 删除一个User，再验证User总数
        UserDTO u = userRepository.findByUsername("didi");
        userRepository.delete(u);
        Assert.assertEquals(2, userRepository.findAll().size());

        // 删除一个User，再验证User总数
        u = userRepository.findByUsername("mama");
        userRepository.delete(u);
        Assert.assertEquals(1, userRepository.findAll().size());

        userRepository.deleteAll();
    }

    @Test
    public void initUsers() {
        // 创建三个User，并验证User总数
        userRepository.save(new UserDTO("leweihe", 18));
        userRepository.save(new UserDTO("Jakob", 18));
        userRepository.save(new UserDTO("Lahm", 19));
        Assert.assertEquals(3, userRepository.findAll().size());
    }

}