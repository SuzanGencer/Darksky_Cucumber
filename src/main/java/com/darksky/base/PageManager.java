package com.darksky.base;

import com.darksky.pages.HomePage;

public class PageManager {
    public static HomePage homePage;

    public static void initialize(){
        homePage = new HomePage();
    }

}
