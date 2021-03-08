package by.jrr.service;

import by.jrr.bean.User;

public class loginService {

    public boolean login(User user, String userInput) {
        if ((!user.isBlocked())) {
            boolean result = checkUserPassword(user, userInput);
            updateuserStatus(user, result);
            return result;
        }
        return false;
        }

    private void updateuserStatus(User user, boolean result) {
        if (result) {
            restoreAttamp(user);
        } else {
            reduceLoginAttemps(user);
        blockIfLoginAttampAxeeded(user);
        }
    }

    private void blockIfLoginAttampAxeeded (User user){
            if (user.getLoginAttempt() == 0) {
                blockUser(user);
            }
        }

        private boolean checkUserPassword (User user, String userInput){
            return user.getPassword().equals(userInput);
        }

        private void reduceLoginAttemps (User user){
            user.setLoginAttemp(user.getLoginAttempt() - 1);
        }


        private void blockUser (User user){
            user.setBlocked(true);
        }

        private void restoreAttamp (User user){
            user.setLoginAttemp(3);
        }
    }
