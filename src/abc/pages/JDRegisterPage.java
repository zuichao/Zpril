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

	//�ء��ѵ�
	@FindBys(@FindBy(xpath = "//input[preceding-sibling::txt[contains(text(),'��������ʹ�������ַ����')]]|//input[preceding-sibling::txt[contains(text(),'���ٴ���������')]]"))
	private List<WebElement> mima;
	
	@FindBy(xpath = "//button[contains(text(),'����ע��')]")
	private WebElement lijizhuce;
	
	@FindBy(xpath = "//button[preceding-sibling::a[contains(text(),'ȡ��')] and contains(text(),'ͬ��')]")
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
