package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.color.ICC_ColorSpace;

public class CommonPage extends AbstractObjectPage {
    public CommonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText="MP3 Players")
    private WebElement linkMP3Players;

    @FindBy(linkText="Show All MP3 Players")
    private WebElement linkShowAllMP3Players;

    @FindBy(id = "cart-total")
    private WebElement cartText;


    public void clickMP3Players(){
        linkMP3Players.click();
    }

    public void clickShowAllMP3Players(){
        linkShowAllMP3Players.click();
    }

    public String getTextFromCartElement(){
        return cartText.getText();
    }


}
