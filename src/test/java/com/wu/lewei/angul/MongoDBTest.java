package com.wu.lewei.angul;

import com.wu.lewei.Application;
import com.wu.lewei.repo.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by cn40580 on 2016-10-09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
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
        userRepository.findAll();
    }

}
