import Helpers.PlaywrightFactory;
import com.microsoft.playwright.*;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;

public class BaseTest {


    PlaywrightFactory playwrightFactory;
    Page page;

    @BeforeSuite()
    public void init(){
          playwrightFactory = new PlaywrightFactory();
          page = playwrightFactory.init();
//        playwright = Playwright.create();
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        browserContext = browser.newContext();
//        page = browserContext.newPage();
//        page.navigate("https://www.myntra.com/");
    }

    @AfterSuite
    public void tearDown(){
        PlaywrightFactory.tearDown();
    }
}
