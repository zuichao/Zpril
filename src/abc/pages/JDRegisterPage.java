package abc.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class JDRegisterPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='form-account']")
	private WebElement yonghuming;

	//重、难点
	@FindBys(@FindBy(xpath = "//input[preceding-sibling::txt[contains(text(),'建议至少使用两种字符组合')]]|//input[preceding-sibling::txt[contains(text(),'请再次输入密码')]]"))
	private List<WebElement> mima;
	
	@FindBy(xpath = "//button[contains(text(),'立即注册')]")
	private WebElement lijizhuce;
	
	@FindBy(xpath = "//button[preceding-sibling::a[contains(text(),'取消')] and contains(text(),'同意')]")
	private WebElement tongyi;
	
	public void tongyi(){
		tongyi.click();
	}
	
	public void yonghuming(String name){
		yonghuming.sendKeys(name);
	}
	
	public void mima(String word){
		for(WebElement web:mima){
			web.sendKeys(word);
		}
	}
	
	public void lijizhuce(){
		lijizhuce.click();
	}
	
	public JDRegisterPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
