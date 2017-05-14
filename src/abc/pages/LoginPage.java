package abc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
	
//��¼ҳ��
	    
	    //���캯��
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
		
		//ʹ���û�����¼Ԫ��
		public WebElement getasdtdField(){
			return this.driver.findElement(swtLocator);
		}
		
		//�û��������Ԫ��
		public WebElement getUserNameTextField(){
			return this.driver.findElement(usernameLocator);
		}
		
		//���������Ԫ��
		public WebElement getPassWordField(){
			return this.driver.findElement(passwordLocator);
		}
		
		//��¼��ťԪ��
		public WebElement getSubmitButton(){
			return this.driver.findElement(loginButtonLocator);
		}
		
		//��¼������ʾ��Ԫ��
		public WebElement LoginErrorDiv(){
			return this.driver.findElement(loginErrorLocator);
		}
		
		//��ȷ��¼����
		public DashPage login(String userName,String passWord){
			this.doLoginStep(userName, passWord);
			return new DashPage(driver);
		}
		
		//�����¼����
		public LoginPage loginFailed(String userName,String passWord){
			this.doLoginStep(userName, passWord);
			return this;
		}
		
		//��¼���跽��
		private void doLoginStep(String userName,String passWord){
			this.driver.switchTo().defaultContent();
			this.driver.switchTo().frame("login_frame");
			this.getasdtdField().click();
			this.getUserNameTextField().sendKeys(userName);
			this.getPassWordField().sendKeys(passWord);
			this.getSubmitButton().click();
		}
}
