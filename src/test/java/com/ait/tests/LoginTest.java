package com.ait.phonebook;

import com.ait.phonebook.model.User;
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
        //click on Login link
        app.getHeader().clickOnLoginLink();
        //verify Registration form is displayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        //fill registration form
        app.getUser().fillLoginRegForm(new User()
                .setEmail("asd+1@gm.com")
                .setPassword("JJghfds!1452"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //verify User logged in
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }

    @Test (priority = 2)
    public void loginRegisteredUserWithInvalidPasswordNegativeTest() {
        //click on Login link
        app.getHeader().clickOnLoginLink();
        //verify Registration form is displayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        //fill registration form
        app.getUser().fillLoginRegForm(new User()
                .setEmail("manuel+5@gmail.com")
                .setPassword("Manuel12345"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //check alert is appeared
        Assert.assertTrue(app.getUser().isAlertPresent());
    } @Test (priority = 2)
    public void loginRegisteredUserWithoutPasswordNegativeTest() {
        //click on Login link
        app.getHeader().clickOnLoginLink();
        //verify Registration form is displayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        //fill registration form
        app.getUser().fillLoginRegForm(new User()
                .setEmail("manuel+5@gmail.com"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //check alert is appeared
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
