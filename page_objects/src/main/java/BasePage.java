import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

class BasePage extends AbstractPage {
    static ChromeDriver driver;

    static void initialezeDriver(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    static void closeDriver(){
        if (driver != null) {
            driver.quit();
        }
    }

    public static void takeScreenshot(String fileName){
        File scrFile = driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./target/screenshots/"
                    + fileName +".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
