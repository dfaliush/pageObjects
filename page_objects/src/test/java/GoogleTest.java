import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class GoogleTest extends BaseTest{

    @BeforeTest
    private void initialize(){
        BasePage.initialezeDriver();
    }


    @Test
    public void checkThePositionInTheGoogleSearch() {
        GoogleSearchPage searchPage = new GoogleSearchPage();
        searchPage.openGoogleHomePage();
        GoogleResultPage result = searchPage.search("wix");
        result.selectFirstLink();
        try {
            Assert.assertEquals(result.getCurrentUrl(),
                    "https://ru.wix.com/", "links are different");
        } finally {
            BasePage.takeScreenshot("positive");
        }
    }

    @Test
    public void checkThePositionInTheGoogleSearchNegative() {
        GoogleSearchPage searchPage = new GoogleSearchPage();
        searchPage.openGoogleHomePage();
        GoogleResultPage result = searchPage.search("wi");
        result.selectFirstLink();
        try {
              Assert.assertEquals(result.getCurrentUrl(),
                      "https://ru.wix.com/","links are different");
        }finally {
              BasePage.takeScreenshot("negative");
        }
    }

    @AfterTest
    public void closeActions(){
        BasePage.closeDriver();
    }
}
