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
		this.driver.get("http://www.2345.com/");
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		this.driver.quit();
	}

	@Test
	public void test() {
		
		 driver.findElement(By.id("J_city_switch")).click();
		 driver.switchTo().frame("city_set_ifr");
		
		 Select pro = new Select(driver.findElement(By.id("province")));
	     pro.selectByValue("32");
	     
	     Select pro2 = new Select(driver.findElement(By.id("chengs")));
	     pro2.selectByIndex(5);
	     
	     Select pro3 = new Select(driver.findElement(By.id("cityqx")));
	     pro3.selectByVisibleText("H ºé¶´");
	     
	     driver.findElement(By.id("buttonsdm")).click();
	     
	     int o = 0;
	     for(int i=1;i<10;i++){
	    	 o+=i;
	     driver.navigate().refresh();
	     }
	     System.out.println(o);
		
	}
	
}
