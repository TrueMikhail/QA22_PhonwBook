package com.ait.phonebook;

import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase  {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        app.getHeader().clickOnLoginLink();
        //driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        app.getUser().fillLoginRegForm(new User()
                .setEmail("asd+1@gm.com")
                .setPassword("JJghfds!1452"));

        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }

}
