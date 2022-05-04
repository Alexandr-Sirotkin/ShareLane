//package tests;
//
//import java.time.Duration;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class ContextMenuTest extends BaseTest {
//
//  @Test
//  public void frameTest() {
//    driver.get("http://the-internet.herokuapp.com/context_menu");
//    Actions actions = new Actions(driver);
//    actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();
//    Alert alert = driver.switchTo().alert();
//    String alertText = alert.getText();
//    Assert.assertEquals(alertText, "You selected a context menu", "Invalid message");
//    alert.accept();
//    Assert.assertFalse(isAlertPresent());
//    driver.findElement(By.xpath("//h3")).click();
//
//  }
//
//  private boolean isAlertPresent() {
//    try {
//      WebDriverWait wait = new WebDriverWait(driver, 5);
//      wait.until(ExpectedConditions.alertIsPresent());
//      return true;
//    } catch (TimeoutException e) {
//      return false;
//    }
//  }
//
//}
