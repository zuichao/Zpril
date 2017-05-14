package abc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashPage extends BasePage {
	
//登录成功后的首页页面
	
	//构造函数
	public DashPage(WebDriver driver){
		super(driver);
	}
	
	By greetingLocator = By.xpath("/html/body/div[2]/div/ul/li[1]/div[1]");
	public WebElement getGreetinglink(){
		return this.driver.findElement(greetingLocator);
	}
}
