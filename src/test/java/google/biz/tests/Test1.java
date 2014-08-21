package google.biz.tests;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import performance.test.TestNgTestBase;

public class Test1 extends TestNgTestBase{

  @Test
  public void testUntitled() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("quick_email")).clear();
    driver.findElement(By.id("quick_email")).sendKeys("test");
    driver.findElement(By.id("quick_pass")).clear();
    driver.findElement(By.id("quick_pass")).sendKeys("test");
    driver.findElement(By.id("quick_login_button")).click();
}

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

 private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

    private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}