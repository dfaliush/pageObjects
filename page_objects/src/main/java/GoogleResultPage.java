import org.openqa.selenium.WebElement;

public class GoogleResultPage extends BasePage{


    public void selectFirstLink(){
        WebElement choice = driver.
                findElementByXPath("//div[@id='rso']/div[1]/descendant::a");
        choice.click();
        new GoogleResultPage();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
