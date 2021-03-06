package by.jrr.service;

import by.jrr.bean.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class loginServiceTest {

    loginService loginService;
    User user;
    User blockUser;
    String positivUserInput = "password";
    String negativUserinput = "wrong";

    @Before
    public void setup() {
        this.loginService = new loginService();
        this.user = getUser();
        this.blockUser = getBlockUser();

        Assert.assertEquals(3, user.getLoginAttempt());
        Assert.assertFalse(user.isBlocked());

        Assert.assertEquals(0, blockUser.getLoginAttempt());
        Assert.assertTrue(blockUser.isBlocked());
    }

    @Test
    public void checkUserPassword_positiv() {

        boolean actualResult = loginService.login(user, positivUserInput);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void checkUserPassword_negativ() {

        boolean actualResult = loginService.login(user, negativUserinput);
        Assert.assertFalse(actualResult);
    }

    @Test
    public void reduceLoginAttemps() {
        loginService.login(user,negativUserinput);
        Assert.assertEquals(2, user.getLoginAttempt());
    }


    @Test
    public void loginPositiv() {
        boolean actualResult = loginService.login(user, positivUserInput);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void loginNegativ() {

        boolean actualResult = loginService.login(user, negativUserinput);
        Assert.assertFalse(actualResult);
        Assert.assertEquals(2, user.getLoginAttempt());
    }

    @Test
    public void blockUser() {
        user.setLoginAttemp(1);
        loginService.login(user,negativUserinput);
        Assert.assertTrue(user.isBlocked());

    }

    @Test
    public void afterFreeWrongPassword_ShouldBlockUser() {

        loginService.login(user, negativUserinput);
        Assert.assertFalse(user.isBlocked());
        Assert.assertEquals(2, user.getLoginAttempt());

        loginService.login(user, negativUserinput);
        Assert.assertFalse(user.isBlocked());
        Assert.assertEquals(1, user.getLoginAttempt());

        loginService.login(user, negativUserinput);
        Assert.assertEquals(0, user.getLoginAttempt());
        Assert.assertTrue(user.isBlocked());
    }

    @Test
    public void blockedUserLogin_ShouldReturneFalse() {
        boolean actualresult = loginService.login(blockUser, positivUserInput);
        Assert.assertFalse(actualresult);
    }

    @Test
    public void restoreAttamps() {
        user.setLoginAttemp(1);
        loginService.login(user,positivUserInput);
        Assert.assertEquals(3, user.getLoginAttempt());
    }

    @Test
    public void after1InCorrect_ShoutRestoreAttampt() {
        loginService.login(user, negativUserinput);
        loginService.login(user, positivUserInput);
        Assert.assertEquals(3, user.getLoginAttempt());
    }

    @Test
    public void after2InCorrect_ShoutRestoreAttampt() {
        loginService.login(user, negativUserinput);
        loginService.login(user, negativUserinput);
        loginService.login(user, positivUserInput);
        Assert.assertEquals(3, user.getLoginAttempt());
    }

    @Test
    public void after3InCorrect_ShoutRestoreAttampt() {
        loginService.login(user, negativUserinput);
        loginService.login(user, negativUserinput);
        loginService.login(user, negativUserinput);
        boolean actualResult = loginService.login(user, positivUserInput);
        Assert.assertEquals(0, user.getLoginAttempt());
        Assert.assertTrue(user.isBlocked());
        Assert.assertFalse(actualResult);
    }

    private User getUser() {
        User user = new User();
        user.setPassword("password");
        return user;
    }

    private User getBlockUser() {
        User user = new User();
        user.setPassword("password");
        user.setLoginAttemp(0);
        user.setBlocked(true);
        return user;
    }
}



