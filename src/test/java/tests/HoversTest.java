package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HoversTest {

  private static final String BASE_URL = "http://the-internet.herokuapp.com/hovers";
  private static final String NOT_FOUND = "Not Found";
  private static String baseFigurePath = "//div[@class='figure'][%s]//%s";
  private WebDriver driver;

  @BeforeClass
  public void setupBrowser() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setHeadless(false);
    chromeOptions.addArguments("--incognito");
    chromeOptions.addArguments("--disable-popup-blocking");
    driver = new ChromeDriver(chromeOptions);
    driver.manage().window().maximize();
  }

  @Test
  public void confirmNameOfFirstUser() {
    driver.get(BASE_URL);
    Actions action = new Actions(driver);
    action.moveToElement(driver.findElements(By.className("figure")).get(0)).perform();
    String user1NameText = driver.findElement(getUserNameTextLocator(1)).getText();
    Assert.assertEquals(user1NameText, "name: user1");
  }

  @Test(dependsOnMethods = "confirmNameOfFirstUser")
  public void verifyClickOnLinkOfFirstUser() {
    driver.findElement(getUserLinkLocator(1)).click();
    Assert.assertEquals(getNotFoundText(), NOT_FOUND);
  }

  @Test(dependsOnMethods = "verifyClickOnLinkOfFirstUser")
  public void confirmNameOfSecondUser() {
    driver.get(BASE_URL);
    Actions action = new Actions(driver);
    action.moveToElement(driver.findElements(By.className("figure")).get(1)).perform();
    String user1NameText = driver.findElement(getUserNameTextLocator(2)).getText();
    Assert.assertEquals(user1NameText, "name: user2");
  }

  @Test(dependsOnMethods = "confirmNameOfSecondUser")
  public void verifyClickOnLinkOfSecondUser() {
    driver.findElement(getUserLinkLocator(2)).click();
    Assert.assertEquals(getNotFoundText(), NOT_FOUND);
  }

  @Test(dependsOnMethods = "verifyClickOnLinkOfSecondUser")
  public void confirmNameOfThirdUser() {
    driver.get(BASE_URL);
    Actions action = new Actions(driver);
    action.moveToElement(driver.findElements(By.className("figure")).get(2)).perform();
    String user1NameText = driver.findElement(getUserNameTextLocator(3)).getText();
    Assert.assertEquals(user1NameText, "name: user3");
  }

  @Test(dependsOnMethods = "confirmNameOfThirdUser")
  public void verifyClickOnLinkOfThirdUser() {
    driver.findElement(getUserLinkLocator(3)).click();
    Assert.assertEquals(getNotFoundText(), NOT_FOUND);
  }

  private By getUserNameTextLocator(int userNumber) {
    return By.xpath(String.format(baseFigurePath, userNumber, "h5"));
  }

  private By getUserLinkLocator(int userNumber) {
    return By.xpath(String.format(baseFigurePath, userNumber, "a"));
  }

  private String getNotFoundText() {
    return driver.findElement(By.xpath("//body")).getAttribute("innerText");
  }

  @AfterClass
  public void closeBrowser() {
    driver.quit();
  }
}
