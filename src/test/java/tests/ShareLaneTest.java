package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;


public class ShareLaneTest {

  //1. Открыть браузер на странице https://www.sharelane.com/cgi-bin/register.py
  //2. Ввести ZipCode
  //3. Нажать кнопку продолжить
  //4. Нажать кнопку регистрация
  //5. Проверить сообщение
  //6. Elfkbnm

  public WebDriver driver;



  @Test
  public void verifyRegistrationPageTest() {
//    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://www.sharelane.com/cgi-bin/register.py");
    driver.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("12345");
    driver.findElement(By.xpath("//input[@value='Continue']")).click();
    driver.findElement(By.xpath("//input[@value='Register']")).click();
    String text = driver.findElement(By.xpath("//span[@class='error_message']")).getText();
    Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used");
  }

  @AfterClass
  public void closeBrowser() {
    driver.quit();
  }

}
