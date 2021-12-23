package tasksTests;

import baseUI.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.ItemPage;
import utils.Waits;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TaskUI extends BaseUITest {
    private CommonPage commonPage;
    private ItemPage itemPage;
    private Waits wait;
    private String allertText = "You must login or create an account to save iPod Classic to your wish list!";
    private String addedProductSuccesfully ="You have added iPod Classic to your shopping cart!";

    @Test
    public void testTask1(){
        String cartTextFormat ="%s item(s)";
        commonPage= new CommonPage(driver);
        itemPage = new ItemPage(driver);
        commonPage.clickMP3Players();
        commonPage.clickShowAllMP3Players();
        wait = new Waits();

        itemPage.clickListView();

       assertTrue(itemPage.isIPodElementDisplayed(), "");
       itemPage.clickIPodElement();

       itemPage.clickAddToWishlistButton();

       wait.waitForJS(driver);


       itemPage.allertMessage();
       //String text= driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]")).getText();
       wait.waitForJS(driver);
       assertTrue(itemPage.allertMessage().contains(allertText), "ERROR");
      // assertTrue(text.contains("You must login or create an account to save iPod Classic to your wish list!"), "ERROR");

      driver.navigate().refresh();
      itemPage.clickAddProductToCart();

      wait.waitForJS(driver);
      itemPage.addedProductMessage();
      assertTrue(itemPage.addedProductMessage().contains(addedProductSuccesfully), "NEPRIDEJO");

      wait.waitForJS(driver);
      commonPage.getTextFromCartElement();

       // List <String> testData=getTestData("src/test/resources/Items");

        String actualCartText = itemPage.getTextFromCartElement();
        String expectedCartText = String.format(cartTextFormat, 1);
        assertTrue(actualCartText.contains(expectedCartText), "Cart text does not contain expected " + expectedCartText);
















    }
}
