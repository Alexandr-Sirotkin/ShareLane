package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ShareLaneTest {

  //1. Открыть браузер на странице https://www.sharelane.com/cgi-bin/register.py
  //2. Ввести ZipCode
  //3. Нажать кнопку продолжить
  //4. Нажать кнопку регистрация
  //5. Проверить сообщение

  public WebDriver driver;


  @BeforeClass
  public void setupBrowser() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setHeadless(false);
    chromeOptions.addArguments("--incognito");
    chromeOptions.addArguments("--disable-popup-blocking");
    driver = new ChromeDriver(chromeOptions);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

//  @Test
//  public void verifyRegistrationPageTest() {
////    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//    driver.get("https://www.sharelane.com/cgi-bin/register.py");
//    driver.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("12345");
//    driver.findElement(By.xpath("//input[@value='Continue']")).click();
//    driver.findElement(By.xpath("//input[@value='Register']")).click();
//    String text = driver.findElement(By.xpath("//span[@class='error_message']")).getText();
//    Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
//  }

  @Test
  public void verifyRegistrationPageTest1() {
    driver.get("https://cloud.google.com/products/calculator");
    driver.switchTo().frame(0);
    driver.switchTo().frame("myFrame");
    driver.switchTo().frame("iframe");
    driver.findElement(By.xpath("//md-select[@ng-model='listingCtrl.computeServer.os']")).sendKeys("70");




//    driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("70");
//    driver.findElement(By.xpath("//input[@name='ht']")).sendKeys("180");
//    driver.findElement(By.xpath("//input[@name='cc']")).click();
//    String text1 = driver.findElement(By.xpath("//input[@name='si']")).getAttribute("value");
//    String text2 = driver.findElement(By.xpath("//input[@name='desc']")).getAttribute("value");
//    System.out.println(text1);
//    System.out.println(text2);
//    Assert.assertEquals(text2, "Your category is Normal");
  }



//
//
//  @AfterClass
//  public void closeBrowser() {
//    driver.quit();
//  }

}
