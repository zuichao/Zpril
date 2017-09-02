package abc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import abc.interfaces.*;
import abc.launchs.*;
import abc.pages.*;

public class TestScrollBy {
	
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod(){
		
		Browsers browsers = new Browsers(BrowsersType.firefox);
		driver = browsers.driver;
	}

	@AfterMethod
	public void afterMethod() {
		this.driver.close();
	}

	@Test
	public void ScrollBy() throws Exception{
		
		LoginPage loginPage = new LoginPage(driver, UrlNameWord.Url);
		loginPage.login(UrlNameWord.u2, UrlNameWord.p);
		
		InBoxPage inBoxPage = new InBoxPage(driver);
		WritePage writePage =new WritePage(driver);
		writePage.backzhu();
		inBoxPage.inbox().click();
		writePage.backwait();
		//找到页面底部的“下一页”位置，并打印出来
		Point po = driver.findElement(By.xpath(Elements.xiayiye)).getLocation();
		System.out.println(po);
		//使用js将滚动条拉动到页面底部的“下一页”位置，wait3S，点击“下一页”，wait3S
		((JavascriptExecutor) driver).executeScript("window.scrollBy("+po.getX()+","+po.getY()+")");
		Thread.sleep(3000);
		this.driver.findElement(By.xpath(Elements.xiayiye)).click();
		Thread.sleep(3000);
		//使用断言-判断页面中是否显示“收件箱”
		WebElement poo = this.driver.findElement(By.xpath(Elements.shoujianxiang));
		Assert.assertEquals(poo.isDisplayed(), true);
		System.out.println(Outputs.tags1+poo.getText()+Outputs.tags2);
	}

}
