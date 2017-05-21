package abc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JDFirstPage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(),'Ãâ·Ñ×¢²á')]")
	private WebElement mianfeizhuce;
	
	@FindBy(xpath = "//a[contains(text(),'ÇëµÇÂ¼')]")
	private WebElement qingdenglu;
	
	
	public void mianfeizhuce(){
		mianfeizhuce.click();
	}
	
	public void qingdenglu(){
		qingdenglu.click();
	}
	
	
	public void getUrl(String baseUrl){
		this.driver.get(baseUrl);
	}
	
	public JDFirstPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
