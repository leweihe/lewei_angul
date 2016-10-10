package com.wu.lewei.angul;

import com.wu.lewei.Application;
import com.wu.lewei.dao.UserDTO;
import com.wu.lewei.repo.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by cn40580 on 2016-10-09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class MongoDBTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
    }


    @Test
    public void test() throws Exception {

        // 创建三个User，并验证User总数
        userRepository.save(new UserDTO(1L, "didi", 30));
        userRepository.save(new UserDTO(2L, "mama", 40));
        userRepository.save(new UserDTO(3L, "kaka", 50));
        Assert.assertEquals(3, userRepository.findAll().size());

        // 删除一个User，再验证User总数
        UserDTO u = userRepository.findOne(1L);
        userRepository.delete(u);
        Assert.assertEquals(2, userRepository.findAll().size());

        // 删除一个User，再验证User总数
        u = userRepository.findByUsername("mama");
        userRepository.delete(u);
        Assert.assertEquals(1, userRepository.findAll().size());

    }

    @Test
    @Ignore
    public void initUsers() {
        // 创建三个User，并验证User总数
        userRepository.save(new UserDTO(1L, "leweihe", 18));
        userRepository.save(new UserDTO(2L, "Jakob", 18));
        userRepository.save(new UserDTO(3L, "Lahm", 19));
        Assert.assertEquals(3, userRepository.findAll().size());
    }
}
