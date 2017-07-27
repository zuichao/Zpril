package abc;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import abc.launch.*;
import abc.pages.*;

public class TestScreenCapture {
	
	WebDriver driver;
	String loginUrl = "http://localhost:8999/";
    String dir = "F:\\";
	
	@BeforeMethod
	public void beforeMethod(){
		Browsers browsers = new Browsers(BrowsersType.chrome);
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
    	
        System.out.println(loginS.getDateTime());
         
        driver.findElement(By.xpath("//input[preceding-sibling::label[contains(text(),'ÓÃ»§Ãû')]]")).sendKeys("sunjian");
        
        loginS.ScreenShot(driver, dir);
        
        //If more than 10 photos will delete all
        File file = new File(dir);
        File[] fs = file.listFiles();
        if(fs.length > 10){
            for(File f: fs){
                if(f.getName().contains("_.jpg"))
                    f.delete();
            }
        }
	}
}