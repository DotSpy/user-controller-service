package com.oxagile;

import com.oxagile.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DummyServiceSecondApplication.class)
public class LdapToDbTest {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        userService.saveUsersLdap(userService.getAllUsersLdap());
    }
}
