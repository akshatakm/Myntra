package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {

    Page page;

    String menTshirtLink = "a[data-group=men]";


    public HomePage(Page page){
        this.page = page;
    }

    public Page gotoMenTshirts(){
        page.hover(menTshirtLink);
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("T-Shirts").setExact(true)).click();
        return page;
    }
}
