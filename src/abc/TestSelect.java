package abc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import abc.launch.Browsers;
import abc.launch.BrowsersType;

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
		 driver.findElement(By.xpath("//span[preceding-sibling::span[contains(text(),'北京')]]")).click();
		 System.out.println(1);
		 driver.findElement(By.xpath("//select[ancestor::div[@id='weather'] and @data-hook='province']")).click();
		 Select pro = new Select(driver.findElement(By.xpath("//select[ancestor::div[@id='weather'] and @data-hook='province']")));
		 pro.selectByValue("25");
	     
	     Thread.sleep(3000);
	     System.out.println(2);
	     driver.findElement(By.xpath("//select[ancestor::div[@id='weather'] and @data-hook='city']")).click();
	     System.out.println(2.5);
	     Select pro2 = new Select(driver.findElement(By.xpath("//select[ancestor::div[@id='weather'] and @data-hook='city']")));
	     pro2.selectByIndex(5);
//	     pro2.selectByVisibleText("L 临汾");
	     
	     Thread.sleep(3000);
	     System.out.println(3);
	     driver.findElement(By.xpath("//select[ancestor::div[@id='weather'] and @data-hook='district']")).click();
	     Select pro3 = new Select(driver.findElement(By.xpath("//select[ancestor::div[@id='weather'] and @data-hook='district']")));
	     pro3.selectByVisibleText("H 洪洞");
	     
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//a[contains(text(),'确定')]")).click();
	     
	     int o = 0;
	     for(int i=1;i<10;i++){
	    	 o+=i;
	     driver.navigate().refresh();
	     }
	     System.out.println(o);
		
	}
	
}
