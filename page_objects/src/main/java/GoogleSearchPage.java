import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage extends BasePage{

    public void openGoogleHomePage(){
        driver.get("https://google.com");
        new GoogleSearchPage();
    }

    public GoogleResultPage search(String searchedText){

        WebElement searchField = driver.findElement(By.cssSelector("input.gsfi"));
        searchField.click();
        searchField.sendKeys(searchedText);
        searchField.sendKeys(Keys.ENTER);
        return new GoogleResultPage();
    }






//    public GoogleSearchPage selectFirstAnswer() {
//        return null;
//    }
}
