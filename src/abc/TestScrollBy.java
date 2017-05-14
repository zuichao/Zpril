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
		
		Point po = driver.findElement(By.xpath("//a[following-sibling::a[contains(text(),'��ת')] and @id='nextpage1']")).getLocation();
		System.out.println(po);
		
		//ʹ��js��������������ҳ��ײ��ġ���һҳ��λ��
		((JavascriptExecutor) driver).executeScript("window.scrollBy("+po.getX()+", "+po.getY()+")");
		Thread.sleep(3000);
		this.driver.findElement(By.xpath("//a[following-sibling::a[contains(text(),'��ת')] and @id='nextpage1']")).click();
		Thread.sleep(3000);
		//ʹ�ö���-�ж�ҳ�����Ƿ���ʾ���ռ��䡱
		WebElement poo = this.driver.findElement(By.xpath("//div[contains(text(),'�ռ���')]"));
		Assert.assertEquals(poo.isDisplayed(), true);
		System.out.println("--���β���ʹ��jsʵ�ֽ�ҳ���еĹ����������ײ�"+"\n"+"--���ҵ��ҳ��ײ��ġ���һҳ����ť"+"\n"+"--����ʹ��Assert������ת���ҳ�����Ƿ���ʾ��"+poo.getText()+"��"+"\n"+"--����ͨ��");
	}

}
