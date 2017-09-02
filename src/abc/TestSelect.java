package abc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import abc.interfaces.Elements;
import abc.launchs.Browsers;
import abc.launchs.BrowsersType;

public class TestSelect {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		Browsers browsers = new Browsers(BrowsersType.firefox);
		this.driver = browsers.driver;
		this.driver.get("http://www.hao123.com/");
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		this.driver.quit();
	}

	@Test
	public void test() throws Exception{
			
		 Thread.sleep(3000);
		 //���������ť
		 driver.findElement(By.xpath("//span[preceding-sibling::span[contains(text(),'����')]]")).click();
		 //���ʡ������ť
		 driver.findElement(By.xpath("//select[ancestor::div[@id='weather'] and @data-hook='province']")).click();
		 Thread.sleep(1000);
		 Select pro = new Select(driver.findElement(By.xpath("//select[ancestor::div[@id='weather'] and @data-hook='province']")));
		 //ѡ��ɽ��ʡ
		 pro.selectByVisibleText("B ����");
	     Thread.sleep(1000);
	     //�����������ť
	     driver.findElement(By.xpath("//select[ancestor::div[@id='weather'] and @data-hook='city']")).click();
	     Select pro2 = new Select(driver.findElement(By.xpath("//select[ancestor::div[@id='weather'] and @data-hook='city']")));
	     //ѡ����
	     pro2.selectByVisibleText("B ����");
	     Thread.sleep(1000);
	     //���������ť
	     driver.findElement(By.xpath("//select[ancestor::div[@id='weather'] and @data-hook='district']")).click();
	     Select pro3 = new Select(driver.findElement(By.xpath("//select[ancestor::div[@id='weather'] and @data-hook='district']")));
	     //ѡ����
	     pro3.selectByVisibleText("B ����");
	     Thread.sleep(1000);
	     //���ȷ����ť
	     driver.findElement(By.xpath("//a[contains(text(),'ȷ��')]")).click();
	     Thread.sleep(3000);
    
	     for(int i=1;i<10;i++){
	     driver.navigate().refresh();
	     Thread.sleep(1000);
	     }
	     
	     System.out.println("This city weather is :"+this.tianqi1().getText()+"\t"+this.tianqi2().getText());
		
	}
	public WebElement tianqi1(){
		return this.driver.findElement(By.xpath(Elements.tianqi1));
	}
	public WebElement tianqi2(){
		return this.driver.findElement(By.xpath(Elements.tianqi2));
	}
}
