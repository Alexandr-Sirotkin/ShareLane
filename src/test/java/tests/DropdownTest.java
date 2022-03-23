package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropdownTest {

  private WebDriver driver;

  @BeforeClass
  public void setupBrowser() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--incognito");
    driver = new ChromeDriver(chromeOptions);
    driver.manage().window().maximize();
    driver.get("http://the-internet.herokuapp.com/dropdown");
  }

  @Test
  public void dropdownTest() {
    Select select = new Select(driver.findElement(By.id("dropdown")));
    select.selectByVisibleText("Option 2");
    String selectedOption = select.getFirstSelectedOption().getText();
    Assert.assertEquals(selectedOption, "Option 2");
  }

  @AfterClass
  public void closeBrowser() {
    driver.quit();
  }
}
