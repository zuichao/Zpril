package abc;

import org.testng.annotations.Test;
import abc.interfaces.Outputs;
import abc.launchs.*;
import abc.pages.*;
import org.testng.annotations.BeforeMethod;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestDownLoad {
	
	WebDriver driver;
	String baseUrl;
	
  @Test
  public void downLoad() throws Exception{
	  
	  BaiduPage baidu = new BaiduPage(driver);
	  WaitPage waitPage = new WaitPage();

	  waitPage.wait3();
	  
//下载任贤齐的歌曲 
	  /* baidu.gengduochanpin().click();
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
	  System.out.println("点击‘安卓下载’");*/
	 
//下载百度网盘
	  baidu.shurukuang().sendKeys("百度网盘下载");
	  baidu.baiduyixia().click();
	  waitPage.wait3();
	  baidu.baiduwangpan().click();
	  waitPage.wait3();
	  this.toSpecificWindow();
	  waitPage.wait2();
	  baidu.putongxiazai().click();
	  waitPage.wait3();
	  baidu.download();
	  waitPage.wait30();
	  this.driver.quit();
	  System.out.println(Outputs.tags2);	  
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
  
  public void toSpecificWindow(){
		Set<String> handles = driver.getWindowHandles();
		String titlename;
		for(String handle:handles){
			titlename = driver.switchTo().window(handle).getTitle();
		if(titlename.contains("soft/detail/")) 
			break;
		}
	}
  

}
