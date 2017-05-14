package abc;

import org.testng.annotations.Test;

import abc.launch.Browsers;
import abc.launch.BrowsersType;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestActions {
	
	WebDriver driver;
	
  @Test
  public void testActions() throws Exception{
	  
	  Thread.sleep(1000);
	  this.driver.findElement(By.xpath("//div[@id='lbNormal']")).click();
	  WebElement aaa = this.driver.findElement(By.xpath("//iframe[@id='x-URS-iframe']"));
	  this.driver.switchTo().frame(aaa);
	  
	  this.driver.findElement(By.xpath("//input[preceding-sibling::label[contains(text(),'邮箱帐号')]]")).sendKeys("zuichao124");
	  this.driver.findElement(By.xpath("//input[preceding-sibling::label[contains(text(),'密码')] and @name='password']")).sendKeys("sunjian123");
	  this.driver.findElement(By.xpath("//a[contains(text(),'录')]")).click();
	  
	  Thread.sleep(5000);
	  Actions actions = new Actions(driver);
	  
/***********************************************************************/
	  
	  //在“收件箱”上面-模拟鼠标右键
	  actions.contextClick(driver.findElement(By.xpath("//span[contains(text(),'收件箱')]"))).build().perform();
	  //点击-打开
	  this.driver.findElement(By.xpath("//span[contains(text(),'打开')]")).click();
	  //判断页面是否显示-“全部设为已读”
	  WebElement bbb = this.driver.findElement(By.xpath("//a[contains(text(),'全部设为已读')]"));
	  Assert.assertEquals(bbb.isDisplayed(), true);
	  System.out.println(bbb.getText()+"\n"+"已经正常显示-_-"+"\n"+"Test Pass!");
  }
  @BeforeMethod
  public void beforeMethod() {
	  Browsers browsers = new Browsers(BrowsersType.firefox);
	  this.driver = browsers.driver;
	  this.driver.get("http://www.126.com/");
  }

  @AfterMethod
  public void afterMethod() {
	  this.driver.quit();
  }

}
