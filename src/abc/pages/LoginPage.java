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
		public WebElement getasdtdField(){
			return this.driver.findElement(swtLocator);
		}
		
		//用户名输入框元素
		public WebElement getUserNameTextField(){
			return this.driver.findElement(usernameLocator);
		}
		
		//密码输入框元素
		public WebElement getPassWordField(){
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
		
		//正确登录方法
		public DashPage login(String userName,String passWord){
			this.doLoginStep(userName, passWord);
			return new DashPage(driver);
		}
		
		//错误登录方法
		public LoginPage loginFailed(String userName,String passWord){
			this.doLoginStep(userName, passWord);
			return this;
		}
		
		//登录步骤方法
		private void doLoginStep(String userName,String passWord){
			this.driver.switchTo().defaultContent();
			this.driver.switchTo().frame("login_frame");
			this.getasdtdField().click();
			this.getUserNameTextField().sendKeys(userName);
			this.getPassWordField().sendKeys(passWord);
			this.getSubmitButton().click();
		}
}
