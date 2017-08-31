package abc;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import abc.launch.Browsers;
import abc.launch.BrowsersType;
import abc.pages.BaiduPage;
import abc.pages.WaitPage;

public class TestUpload {
	
	//这个我不会啊！！！等以后会了再上传吧-_-
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod(){
		Browsers browsers = new Browsers(BrowsersType.firefox);
		this.driver = browsers.driver;
	}
	@AfterMethod
	public void afterMethod(){
		this.driver.quit();
	}
	@Test
	public void testUpdateFile() throws Exception{
		BaiduPage baidu = new BaiduPage(driver);
		WaitPage waitPage = new WaitPage();
		
		driver.get("http://www.baidu.com/");
		waitPage.wait3();
		baidu.shurukuang().sendKeys("博客园");
		waitPage.wait1();
		baidu.baiduyixia().click();
		waitPage.wait5();
		baidu.bokeyuan().click();
		waitPage.wait5();
		this.toSpecificWindow();
		waitPage.wait3();
		baidu.denglu().click();
		waitPage.wait3();
		baidu.yonghuming().sendKeys("13152874607");
		baidu.mima().sendKeys("sunjian123!@#");
		baidu.tijiao().click();
		waitPage.wait5();
		baidu.my().click();
		waitPage.wait3();
		baidu.xiugaitupian().click();
		waitPage.wait5();
		baidu.uploadtupian().click();
		waitPage.wait3();
		
		baidu.upload("firefox", new File("H:/selenium/tools/1.jpg"));
		waitPage.wait3();
		baidu.baocun().click();
		waitPage.wait5();
	}
	
	public void toSpecificWindow(){
		Set<String> handles = driver.getWindowHandles();
		String titlename;
		for(String handle:handles){
			titlename = driver.switchTo().window(handle).getTitle();
		if(titlename.contains("cnblogs.com")) 
			break;
		}
	}

}
