package com.ghani.SecurityClient.service;

import com.ghani.SecurityClient.entity.User;
import com.ghani.SecurityClient.entity.VerificationToken;
import com.ghani.SecurityClient.model.UserModel;

import java.util.Optional;

public interface UserService {
    public User registerUser(UserModel userModel);

    void saveVerifTokenForUser(User user, String token);

    String validateVerificationToken(String token);

    VerificationToken generateNewToken(String oldToken);

    User findUserByEmail(String email);

    void createPasswordResetToken(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void changePassword(User user, String newPassword);

    Boolean validateOldPassword(User userEmail, String oldPassword);
}
