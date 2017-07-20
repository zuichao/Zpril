package abc.pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class LoginSystemScreenshotPage extends BasePage {
	
	public LoginSystemScreenshotPage(WebDriver driver){
		super(driver);
	}
	
	//This method will geted system time
    public String getDateTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return dateFormat.format(new Date());
    }
    
    //This method will take screen shot ,require two parameters ,one is driver , another is file name
    public void ScreenShot(WebDriver driver, String dir){
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
        	//The screenshots are copied to the specified path
            FileUtils.copyFile(screenShot, new File(dir+getDateTime()+"_"+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
