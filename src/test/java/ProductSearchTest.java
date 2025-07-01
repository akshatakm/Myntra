import Helpers.PlaywrightFactory;
import Pages.HomePage;
import Pages.TshirtsResultPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductSearchTest extends BaseTest{
    HomePage homepage;
    TshirtsResultPage tshirtsResultPage;

    @BeforeClass
    public void initialise(){
        homepage = new HomePage(PlaywrightFactory.getPage());
    }

    @Test(priority = 1)
    public void goToMenTshirts(){
        tshirtsResultPage = new TshirtsResultPage(homepage.gotoMenTshirts());
    }

    @Test(priority = 2)
    public void verifyFilters() throws InterruptedException {
        tshirtsResultPage.applyBrandFilter("Roadster");
        tshirtsResultPage.applySort("Price: Low To High");
        tshirtsResultPage.priceRange();
    }
}
