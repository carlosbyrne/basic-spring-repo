package com.makers.makersbnb;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

class LandingPageTests {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    public void usersAreWelcomedToTheApp() {
        page.navigate("http://localhost:8080");
        Locator pageBody = page.locator("body");
        assertThat(pageBody).containsText("Welcome to MakersBnB!");
    }

    @Test
    public void emailAddressShownOnPage() {
        page.navigate("http://localhost:8080/contactus");
        Locator pageBody = page.locator("body");
        assertThat(pageBody).containsText("contact@makersbnb.com");
    }

    @Test
    public void teamShowsOnPage() {
        page.navigate("http://localhost:8080/team");
        Locator pageBody = page.locator("body");
        assertThat(pageBody).containsText("Carlos");
        assertThat(pageBody).containsText("Dave");
        assertThat(pageBody).containsText("Phil");
    }

}


