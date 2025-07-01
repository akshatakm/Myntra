package Helpers;

import com.microsoft.playwright.*;

import java.lang.foreign.StructLayout;

public class PlaywrightFactory {

    private static ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> browserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> page = new ThreadLocal<>();

    public static Playwright getPlaywright(){
        return playwright.get();
    }

    public static Browser getBrowser(){
        return browser.get();
    }

    public static BrowserContext getBrowserContext(){
        return browserContext.get();
    }

    public static Page getPage(){
        return page.get();
    }
    public Page init(){
        playwright.set(Playwright.create());
//        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
//        launchOptions.setHeadless(true);
//        launchOptions.setSlowMo();
        browser.set(getPlaywright().chromium().launch());
        browserContext.set(getBrowser().newContext());
        page.set(getBrowserContext().newPage());
        getPage().navigate("https://www.myntra.com/");
        System.out.println(getPage().title());
        return getPage();
    }

    public static void tearDown() {
        getPage().close();
        getBrowserContext().close();
        getBrowser().close();
        getPlaywright().close();
    }
}
