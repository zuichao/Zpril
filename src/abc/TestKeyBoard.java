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
				
		//设置等待页面完全加载的时间是10秒，如果在10秒内加载完毕，剩余时间不再等待
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		By inputBox = By.id("kw");
		
		By searchButton = By.id("su");
		
		//智能等待页面加载出来
		intelligentWait(driver,10,inputBox);
		
		intelligentWait(driver, 10, searchButton);
		
		 //实例化action对象
		Actions action = new Actions(driver);
		
		//通过action模拟键盘输入Java关键字到输入框，只有使用perform方法才会输入进去
		action.sendKeys(driver.findElement(inputBox),"java").perform();
		
		//鼠标模拟移动到搜索按钮
		action.moveToElement(driver.findElement(searchButton)).perform();
		
		//模拟点击操作
		action.click().perform();
		
		Thread.sleep(10000);
		
	}

	//智能等待方法
	public static void intelligentWait(WebDriver driver,int timeOut, final By by){        
        try {
            (new WebDriverWait(driver, timeOut)).until(new ExpectedCondition<Boolean>() {

                public Boolean apply(WebDriver driver) {
                    WebElement element = driver.findElement(by);
                    return element.isDisplayed();
                }
            });
        } catch (TimeoutException e) {
            Assert.fail("超时!! " + timeOut + " 秒之后还没找到元素 [" + by + "]");
        }
    }
	
}
