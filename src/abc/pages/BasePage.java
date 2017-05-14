package abc.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
//公共页面
	
	protected final WebDriver driver;
	
	protected String url;
	
	//构造函数
	public BasePage(WebDriver driver){
		this.driver=driver;
	}
	
	public void goTo(){
		this.driver.get(this.url);
	}
	
	public String currentUrl(){
		return this.driver.getCurrentUrl();
	}
	
}
