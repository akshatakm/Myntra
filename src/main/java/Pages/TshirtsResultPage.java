package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.WaitForSelectorState;
import jdk.jfr.Enabled;

public class TshirtsResultPage {

    Page page;
    String brandList = ".brand-list";
    String sortList = ".sort-list";
    String minProceId = "#rootRailThumbLeft";
    String maxPriceId = "#rootRailThumbRight";
    String sliderRail = "slider-rootRail";

    public TshirtsResultPage(Page page){
        this.page = page;
    }

    public void applyBrandFilter(String brandName){
        Locator brandFilter = page.locator("label:has-text('"+brandName+"')");
        brandFilter.click();
    }

    public void applySort(String sortOption) throws InterruptedException {
        Locator sort = page.locator(sortList+" >> label:has-text('"+sortOption+"')");
        page.locator(".sort-sortBy").click();
        System.out.println(sort.isEnabled());
        //sort.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        sort.hover();
        sort.click();
        page.waitForTimeout(1000);
        System.out.println(page.locator(".sort-sortBy >> span").first().textContent());
    }

    public void priceRange(){
        //page.evaluate("() => window.scrollBy(0,50)");
        Locator minPriceRage = page.locator(minProceId);
        BoundingBox boundingBox = minPriceRage.boundingBox();
        minPriceRage.scrollIntoViewIfNeeded();
        //page.mouse().move(boundingBox.x+boundingBox.width/2,boundingBox.y+ boundingBox.height/2);
        page.hover(minProceId);
        page.mouse().down();
        page.mouse().move(boundingBox.x+50, boundingBox.y+ boundingBox.height/2);
        page.mouse().up();
        System.out.println(boundingBox.x);
        System.out.println(boundingBox.y);
        //page.wait(500);
        page.waitForTimeout(500);
        System.out.println(page.locator(".slider-dotContainer").textContent());
    }

}
