package abc;

import org.testng.annotations.Test;

import abc.launch.Browsers;
import abc.launch.BrowsersType;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestAlert {
	
	WebDriver driver;
	String baseUrl;

  @Test
  public void testAlert() throws Exception{
	  
	  Thread.sleep(3000);
	  this.driver.switchTo().frame("i");
	  this.driver.findElement(By.xpath("//input[@value='ÏÔÊ¾ÏûÏ¢¿ò']")).click();
	  
	  Alert a1 = this.driver.switchTo().alert();
	  System.out.println(a1.getText());
	  a1.accept();
  }
  @BeforeMethod
  public void beforeMethod() {
	  Browsers browsers = new Browsers(BrowsersType.firefox);
	  this.driver = browsers.driver;
	  this.driver.get("http://www.w3school.com.cn/tiy/t.asp?f=hdom_alert");
  }

  @AfterMethod
  public void afterMethod() {
	  this.driver.quit();
  }

}
