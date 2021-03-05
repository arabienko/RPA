package by.jrr.service;

import by.jrr.bean.User;

public class loginService {
    public boolean checkUserPassword(User user, String userInput) {
        return user.getPassword().equals(userInput);
    }
}
