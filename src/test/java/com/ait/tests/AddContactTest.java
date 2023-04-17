package com.ait.phonebook;

import com.ait.phonebook.model.Contact;
import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getHeader().clickOnLoginLink();

            app.getUser().fillLoginRegForm(new User()
                    .setEmail("asd+1@gm.com")
                    .setPassword("JJghfds!1452"));
            app.getUser().clickOnLoginButton();
        }
    }

    @Test
    public void addContactPositiveTests() {
        //click on Add link
        app.getHeader().clickOnAddLink();
        //fill add contact form
        app.getContact().addContact(new Contact()
                .setName("Karl")
                .setSurName("Adam")
                .setPhone("1234567890")
                .setEmail("adam@gm.co")
                .setAdress("Koblenz")
                .setDescription("torwart"));

        //click on Save button
        app.getContact().clickOnSaveButton();

        //verify new contact is added
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));
    }

}
