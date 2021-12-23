package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends CommonPage{
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="list-view")
    private WebElement listView;

    @FindBy(xpath = "//div[@class='caption'][1]/h4/a")
    private WebElement iPodElement;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div[1]/button[1]")
    private  WebElement addToWishlistButton;

    @FindBy(xpath="//*[@id=\"product-product\"]/div[1]")
    private WebElement alertElement;

    @FindBy(id = "button-cart")
    private WebElement addProductToCart;

    public String allertMessage() {
        return driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]")).getText();
    }

    public void clickListView(){
        listView.click();
    }

    public boolean isIPodElementDisplayed(){
        return iPodElement.isDisplayed();
    }

    public void clickIPodElement(){
        iPodElement.click();
    }

    public void clickAddToWishlistButton(){
        addToWishlistButton.click();
    }

    public void clickAddProductToCart(){
        addProductToCart.click();
    }

    public String addedProductMessage() {
        return driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]")).getText();
    }
}
