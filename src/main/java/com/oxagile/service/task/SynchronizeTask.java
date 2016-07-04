package com.oxagile.service.task;

import com.oxagile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SynchronizeTask {

    @Autowired
    UserService userService;


    @Scheduled(fixedRate = 3600000, initialDelay = 10000)
    public void synchronize() {
        userService.synchronizeLdapAndDb();
    }

}
