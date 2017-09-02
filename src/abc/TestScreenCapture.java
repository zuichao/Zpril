package abc;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import abc.launchs.*;
import abc.pages.*;

public class TestScreenCapture {
	
	WebDriver driver;
	String loginUrl = "http://www.baidu.com/";
    String dir = "C:/";
	
	@BeforeMethod
	public void beforeMethod(){
		Browsers browsers = new Browsers(BrowsersType.firefox);
		this.driver = browsers.driver;
		this.driver.get(loginUrl);
	}
	@AfterMethod
	public void afterMethod(){
		this.driver.quit();
	}
	@Test
	public void testScreenCaptrue() throws Exception{

    	LoginSystemScreenshotPage loginS = new LoginSystemScreenshotPage(driver);
    	WaitPage waitPage = new WaitPage();
    	
        System.out.println(loginS.getDateTime());
         
        BaiduPage baidu = new BaiduPage(driver);
        baidu.shurukuang().sendKeys("全国叫孙健的人有多少？");
        
        waitPage.wait3();
        
        loginS.ScreenShot(driver, dir);
        
        waitPage.wait3();
        
        //If more than 10 photos will delete all
        File file = new File(dir);
        File[] fs = file.listFiles();
        if(fs.length > 50){
            for(File f: fs){
                if(f.getName().contains("_.jpg"))
                    f.delete();
            }
        }
	}
}