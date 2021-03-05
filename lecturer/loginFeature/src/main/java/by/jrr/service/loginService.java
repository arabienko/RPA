package by.jrr.service;

import by.jrr.bean.User;

public class loginService {
    public boolean checkUserPassword(User user, String userInput) {
        return user.getPassword().equals(userInput);
    }

    public void reduceLoginAttemps(User user) {
        user.setLoginAttemp(user.getLoginAttempt()-1);
    }

    public boolean login(User user, String userInput) {
        reduceLoginAttemps(user);
return checkUserPassword(user,userInput);
    }
}
