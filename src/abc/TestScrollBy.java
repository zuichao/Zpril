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

import abc.launch.*;
import abc.pages.*;

public class TestScrollBy {
	
	WebDriver driver;
	String baseUrl;

	@BeforeMethod
	public void beforeMethod(){
		
		baseUrl = "https://mail.qq.com/";
		Browsers browsers = new Browsers(BrowsersType.firefox);
		driver = browsers.driver;
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() {
		this.driver.close();
	}

	@Test
	public void ScrollBy() throws Exception{
		
		String name = "zuichao124@qq.com";
		String word = "sunjian123";
		
		LoginPage loginPage = new LoginPage(driver, baseUrl);
		loginPage.login(name, word);
		
		InBoxPage inBoxPage = new InBoxPage(driver);
		WritePage writePage =new WritePage(driver);
		writePage.backzhu();
		inBoxPage.inbox().click();
		writePage.backwait();
		
		Point po = driver.findElement(By.xpath("//a[following-sibling::a[contains(text(),'跳转')] and @id='nextpage1']")).getLocation();
		System.out.println(po);
		
		//使用js将滚动条拉动到页面底部的“下一页”位置
		((JavascriptExecutor) driver).executeScript("window.scrollBy("+po.getX()+", "+po.getY()+")");
		Thread.sleep(3000);
		this.driver.findElement(By.xpath("//a[following-sibling::a[contains(text(),'跳转')] and @id='nextpage1']")).click();
		Thread.sleep(3000);
		//使用断言-判断页面中是否显示“收件箱”
		WebElement poo = this.driver.findElement(By.xpath("//div[contains(text(),'收件箱')]"));
		Assert.assertEquals(poo.isDisplayed(), true);
		System.out.println("--本次测试使用js实现将页面中的滚动条拉至底部"+"\n"+"--并且点击页面底部的“下一页”按钮"+"\n"+"--并且使用Assert断言跳转后的页面中是否显示“"+poo.getText()+"”"+"\n"+"--测试通过");
	}

}
