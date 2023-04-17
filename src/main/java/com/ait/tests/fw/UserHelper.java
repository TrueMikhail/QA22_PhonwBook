package com.ait.tests.fw;

import com.ait.tests.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegistrationButton() {
        click(By.cssSelector("[name='registration']"));
    }

    public void fillLoginRegForm(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
    }

    public boolean isLoginRegFormPresent() {
        return isElementPresent(By.className("login_login__3EHKB"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[contains(.,'Login')]"));
    }
}
