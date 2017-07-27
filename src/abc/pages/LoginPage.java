package abc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
	
//登录页面
	    
    //构造函数
	public LoginPage(WebDriver driver,String url){
		super(driver);
		this.url = url;
		this.goTo();
	}
	
	By swtLocator = By.id("switcher_plogin");
	By usernameLocator = By.id("u");
	By passwordLocator = By.id("p");
	By loginButtonLocator = By.id("login_button");
	By loginErrorLocator = By.id("err_m");
	
	//使用用户名登录元素
	public WebElement getsyyhmdl(){
		return this.driver.findElement(swtLocator);
	}
	
	//用户名输入框元素
	public WebElement getUserNameText(){
		return this.driver.findElement(usernameLocator);
	}
	
	//密码输入框元素
	public WebElement getPassWordText(){
		return this.driver.findElement(passwordLocator);
	}
	
	//登录按钮元素
	public WebElement getSubmitButton(){
		return this.driver.findElement(loginButtonLocator);
	}
	
	//登录错误提示语元素
	public WebElement LoginErrorDiv(){
		return this.driver.findElement(loginErrorLocator);
	}
	
	//登录方法
	public void login(String userName,String passWord){
		this.doLoginStep(userName, passWord);
	}
	
	
	
	//登录步骤方法
	private void doLoginStep(String userName,String passWord){
		this.driver.switchTo().defaultContent();
		this.driver.switchTo().frame("login_frame");
		this.getsyyhmdl().click();
		this.getUserNameText().sendKeys(userName);
		this.getPassWordText().sendKeys(passWord);
		this.getSubmitButton().click();
	}		
}
