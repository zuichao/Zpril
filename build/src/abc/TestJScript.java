package abc;

import org.testng.annotations.Test;
import abc.launch.Browsers;
import abc.launch.BrowsersType;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class TestJScript {
	
	WebDriver driver;
	
  @Test
  public void jscript()throws Exception {
	runJSTest2(driver);
  	runJSTest1(driver);
  	Alert alert = driver.switchTo().alert();
  	System.out.println(alert.getText());
  	alert.accept();
  }
  @BeforeMethod
  public void beforeMethod() {
	  Browsers browsers = new Browsers(BrowsersType.firefox);
	  this.driver = browsers.driver;
	  this.driver.get("https://www.baidu.com/");
  }

  @AfterMethod
  public void afterMethod() {
	  this.driver.quit();
  }
  
  public static void runJSTest1(WebDriver driver) throws InterruptedException {
      String js ="alert(\"hello,this is a small alert!\")";
      ((JavascriptExecutor) driver).executeScript(js);
      Thread.sleep(10000);
  }
  
  public static void runJSTest2(WebDriver driver) throws InterruptedException {
      String js ="arguments[0].click();";
      driver.findElement(By.id("kw")).sendKeys("JAVA");
      WebElement searchButton = driver.findElement(By.id("su"));
      ((JavascriptExecutor) driver).executeScript(js,searchButton);
      Thread.sleep(3000);
  }

}
