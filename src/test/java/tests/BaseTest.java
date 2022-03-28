package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

  protected WebDriver driver;

  @BeforeClass
  public void setupBrowser() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--incognito");
    chromeOptions.addArguments("--disable-popup-blocking");
    driver = new ChromeDriver(chromeOptions);
    driver.manage().window().maximize();
  }

  @AfterClass
  public void closeBrowser() {
    driver.quit();
  }

}
