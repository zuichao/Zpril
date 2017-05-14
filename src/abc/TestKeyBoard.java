package abc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import abc.launch.Browsers;
import abc.launch.BrowsersType;

public class TestKeyBoard {
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod(){
		Browsers browsers = new Browsers(BrowsersType.firefox);
		this.driver = browsers.driver;
		this.driver.get("https://www.baidu.com/");
	}
	
	@AfterMethod
	public void afterMethod(){
		this.driver.quit();
	}
	
	@Test
	public void keyBoard() throws Exception{
				
		//���õȴ�ҳ����ȫ���ص�ʱ����10�룬�����10���ڼ�����ϣ�ʣ��ʱ�䲻�ٵȴ�
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		By inputBox = By.id("kw");
		
		By searchButton = By.id("su");
		
		//���ܵȴ�ҳ����س���
		intelligentWait(driver,10,inputBox);
		
		intelligentWait(driver, 10, searchButton);
		
		 //ʵ����action����
		Actions action = new Actions(driver);
		
		//ͨ��actionģ���������Java�ؼ��ֵ������ֻ��ʹ��perform�����Ż������ȥ
		action.sendKeys(driver.findElement(inputBox),"java").perform();
		
		//���ģ���ƶ���������ť
		action.moveToElement(driver.findElement(searchButton)).perform();
		
		//ģ��������
		action.click().perform();
		
		Thread.sleep(10000);
		
	}

	//���ܵȴ�����
	public static void intelligentWait(WebDriver driver,int timeOut, final By by){        
        try {
            (new WebDriverWait(driver, timeOut)).until(new ExpectedCondition<Boolean>() {

                public Boolean apply(WebDriver driver) {
                    WebElement element = driver.findElement(by);
                    return element.isDisplayed();
                }
            });
        } catch (TimeoutException e) {
            Assert.fail("��ʱ!! " + timeOut + " ��֮��û�ҵ�Ԫ�� [" + by + "]");
        }
    }
	
}
