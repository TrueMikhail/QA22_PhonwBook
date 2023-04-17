package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void openHomePageTest() {
        //isHomeComponentPresent();
        //System.out.println("Home Component is " + isHomeComponentPresent());
        //isHomeComponentPresent2();
        //isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
        //isElementPresent2(By.cssSelector("div:nth-child(2)>div>div"));
        Assert.assertTrue(app.getHome().isHomeComponentPresent());

    }

}
