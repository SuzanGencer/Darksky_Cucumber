package com.darksky.stepdefinitions;

import com.darksky.base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
    @Before
    public void start() {
        BasePage.initDriver();
    }

    @After
    public void end() {
        BasePage.tearDown();
    }
}
