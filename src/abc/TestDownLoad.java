package abc;

import org.testng.annotations.Test;
import abc.launch.Browsers;
import abc.launch.BrowsersType;
import abc.pages.BaiduPage;
import abc.pages.WritePage;

import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestDownLoad {
	
	WebDriver driver;
	String baseUrl;
	
  @Test
  public void downLoad() throws Exception{
	  
	  BaiduPage baidu = new BaiduPage(driver);
	  WritePage writePage = new WritePage(driver);
	  
	  writePage.waityihui();
	  baidu.gengduochanpin().click();
	  writePage.waityihui();
	  baidu.yinyue().click();
	  writePage.waityihui();
	  
	  baidu.toSpecificWindow0();
	  Thread.sleep(2000);
	  baidu.shurukuang().sendKeys("任贤齐");
	  baidu.baiduyixia().click();
	  Thread.sleep(2000);
	  baidu.xiazai().click();
	  
	  baidu.toSpecificWindow();
	  Thread.sleep(2000);
	  baidu.anzhuoxiazai().click();
	  System.out.println("点击‘安卓下载’");
	  
	  try{
		  Runtime.getRuntime().exec(System.getProperty("user.dir")+"/tools/download.exe");
		  Thread.sleep(5000);
	  }catch(IOException e){
		  e.printStackTrace();
	  }catch(InterruptedException e){
		  e.printStackTrace();
	  }
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  Browsers browsers = new Browsers(BrowsersType.firefox);
	  this.driver = browsers.driver;
	  this.driver.get("http://www.baidu.com/");
  }

  @AfterMethod
  public void afterMethod() {
	  this.driver.quit();
  }

}
