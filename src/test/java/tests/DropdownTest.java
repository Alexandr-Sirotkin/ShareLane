package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest{

//  @Test
//  public void dropdownTest() {
//    driver.get("http://the-internet.herokuapp.com/dropdown");
//    WebElement element = driver.findElement(By.id("dropdown"));
//    Select select = new Select(element);
//    select.selectByVisibleText("Option 2");
//    String selectedOption = select.getFirstSelectedOption().getText();
//    Assert.assertEquals(selectedOption, "Option 2");
//  }

  @Test
  public void frameTest() {
    driver.get("http://the-internet.herokuapp.com/iframe");
    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//body[@id='tinymce']")), "Your content goes here."));
    Assert.assertEquals(driver.findElement(By.xpath("//body[@id='tinymce']")).getText(), "Your content goes here.",
        "Text does not match");
  }
}
