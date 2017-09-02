package abc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InBoxPage extends BasePage {

//收件箱页面
	//构造方法
	public InBoxPage(WebDriver driver){
		super(driver);
	}
	
	//"收件箱"按钮
	By inboxButtonLocator = By.xpath("//b[ancestor::a[@id='folder_1'] and contains(text(),'收件箱')]");
	
	//勾选复选框
	By ChockBoxsLocator = By.xpath("//form[@id='frm']//div[5]/table[1]/tbody/tr/td[1]/input");
	
	//星标
	By xingLocator = By.xpath("//div[@id='div_showlastweek']/table[1]/tbody/tr/td[3]/table/tbody/tr/td[5]");
	
	//查看邮件
	By lookmailLocator = By.xpath("//div[@id='div_showlastweek']/table[1]/tbody/tr/td[3]");
	
	
	public WebElement inbox(){
		System.out.println("点击“收件箱”按钮");
		return this.driver.findElement(inboxButtonLocator);
	}
	
	public WebElement chockboxs(){
		System.out.println("勾选一个复选框");
		return this.driver.findElement(ChockBoxsLocator);
	}
	
	public WebElement xingbiao(){
		System.out.println("点亮星标");
		return this.driver.findElement(xingLocator);
	}
	
	public WebElement lookmail(){
		System.out.println("查看邮件");
		return this.driver.findElement(lookmailLocator);
	}
	
}
