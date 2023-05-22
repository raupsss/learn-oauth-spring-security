package com.ghani.SecurityClient.event.listener;

import com.ghani.SecurityClient.entity.User;
import com.ghani.SecurityClient.event.RegistrationCompleteEvent;
import com.ghani.SecurityClient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {

        //Create verification token for user with Link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerifTokenForUser(user, token);


        //Send Mail to user
        String url = event.getApplicationUrl() + "/verifyRegistration?token=" + token;

        log.info("Click the link to verify your account: " + url);

    }
}
