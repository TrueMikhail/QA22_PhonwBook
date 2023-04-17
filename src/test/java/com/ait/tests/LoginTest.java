package com.ait.tests;

import com.ait.tests.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test(priority = 1)
    public void loginRegisteredUserPositiveTest() {
        app.getHeader().clickOnLoginLink();
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        app.getUser().fillLoginRegForm(new User()
                .setEmail("asd+1@gm.com")
                .setPassword("JJghfds!1452"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }

    @Test (priority = 2)
    public void loginRegisteredUserWithInvalidPasswordNegativeTest() {
        app.getHeader().clickOnLoginLink();
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        app.getUser().fillLoginRegForm(new User()
                .setEmail("manuel+5@gmail.com")
                .setPassword("Manuel12345"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
        logger.info("User is logged in. Actual result: " + app.getHeader().isSignOutButtonPresent() + ". Expected result: true");
    } @Test (priority = 2)
    public void loginRegisteredUserWithoutPasswordNegativeTest() {
        app.getHeader().clickOnLoginLink();
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        app.getUser().fillLoginRegForm(new User()
                .setEmail("manuel+5@gmail.com"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
        //logger.info("User is logged in. Actual result: " + app.getHeader().isAlertPresent() + ". Expected result: true");
    }

}
