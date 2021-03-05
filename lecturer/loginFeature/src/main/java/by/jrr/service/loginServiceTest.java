package by.jrr.service;

import by.jrr.bean.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class loginServiceTest {

    loginService loginService;

    @Before
    public void setup() {
        this.loginService = new loginService();
    }

    @Test
    public void checkUserPassword_positiv() {
        User user = getUser();

        String userInput = "password";

        boolean actualResult = loginService.checkUserPassword(user, userInput);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void checkUserPassword_negativ() {
        User user = getUser();

        String userInput = "wrong";

        boolean actualResult = loginService.checkUserPassword(user, userInput);
        Assert.assertFalse(actualResult);
    }

    private User getUser() {
        User user = new User();
        user.setPassword("password");
        return user;
    }
}



