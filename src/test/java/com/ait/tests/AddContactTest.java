package com.ait.tests;

import com.ait.tests.fw.DataProviderContact;
import com.ait.tests.model.Contact;
import com.ait.tests.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @Test (enabled = false, dataProvider = "addNewContactFromCSV", dataProviderClass = DataProviderContact.class)
    public void addContactPositiveFromCSVFileTests(Contact contact) {
        app.getHeader().clickOnAddLink();
        app.getContact().addContact(contact);

        app.getContact().clickOnSaveButton();
        app.getContact().removeContact();

    }

    @Test (enabled = false, dataProvider = "addNewContact", dataProviderClass = DataProviderContact.class)
    public void addContactPositiveTests(String name, String sureName, String phone,
                                        String email, String adress, String desc) {
        app.getHeader().clickOnAddLink();
        app.getContact().addContact(new Contact()
                .setName(name)
                .setSurName(sureName)
                .setPhone(phone)
                .setEmail(email)
                .setAdress(adress)
                .setDescription(desc));

        app.getContact().clickOnSaveButton();
        app.getContact().removeContact();

    }

}
