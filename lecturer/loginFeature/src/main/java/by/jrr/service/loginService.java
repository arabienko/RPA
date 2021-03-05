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
        if ((user.isBlocked())){
            return false;
        }
        if(user.getLoginAttempt()==+1){
            blockUser(user);
        }
        reduceLoginAttemps(user);
        boolean result=checkUserPassword(user,userInput);
        if (result){
            restoreAttamp(user);
        }

        return result;
    }

    public void blockUser(User user) {
user.setBlocked(true);
    }

    public void restoreAttamp(User user) {
        user.setLoginAttemp(3);
    }
}
