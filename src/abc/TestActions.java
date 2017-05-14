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
	  
	  this.driver.findElement(By.xpath("//input[preceding-sibling::label[contains(text(),'�����ʺ�')]]")).sendKeys("zuichao124");
	  this.driver.findElement(By.xpath("//input[preceding-sibling::label[contains(text(),'����')] and @name='password']")).sendKeys("sunjian123");
	  this.driver.findElement(By.xpath("//a[contains(text(),'¼')]")).click();
	  
	  Thread.sleep(5000);
	  Actions actions = new Actions(driver);
	  
/***********************************************************************/
	  
	  //�ڡ��ռ��䡱����-ģ������Ҽ�
	  actions.contextClick(driver.findElement(By.xpath("//span[contains(text(),'�ռ���')]"))).build().perform();
	  //���-��
	  this.driver.findElement(By.xpath("//span[contains(text(),'��')]")).click();
	  //�ж�ҳ���Ƿ���ʾ-��ȫ����Ϊ�Ѷ���
	  WebElement bbb = this.driver.findElement(By.xpath("//a[contains(text(),'ȫ����Ϊ�Ѷ�')]"));
	  Assert.assertEquals(bbb.isDisplayed(), true);
	  System.out.println(bbb.getText()+"\n"+"�Ѿ�������ʾ-_-"+"\n"+"Test Pass!");
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
