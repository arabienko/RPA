package by.jrr.service;

import by.jrr.bean.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class loginServiceTest {

    loginService loginService;
    User user;

    @Before
    public void setup() {
        this.loginService = new loginService();
        this.user = getUser();
        Assert.assertEquals(3, user.getLoginAttemp());

    }

    @Test
    public void checkUserPassword_positiv() {

        String userInput = "password";

        boolean actualResult = loginService.checkUserPassword(user, userInput);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void checkUserPassword_negativ() {

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



