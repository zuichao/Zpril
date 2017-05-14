package abc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DraftBoxPage extends BasePage {
	
//草稿箱页面
	//构造方法
	public DraftBoxPage(WebDriver driver){
		super(driver);
	}
	
	//草稿箱按钮
	By draftboxLocator = By.id("folder_4");
	
	//勾选复选框
	By chockboxLocator = By.xpath("//form[@id='frm']/div[5]/table/tbody/tr/td[1]/input");
	
	//删除按钮
	By deletebuttonLocator = By.id("quick_del");
	
	//取消按钮
	By cancelLocator = By.id("QMconfirm_QMDialog_cancel");
	
	
	public WebElement draftbox(){
		System.out.println("点击“草稿箱”");
		return this.driver.findElement(draftboxLocator);
	}
	
	public WebElement chockbox(){
		System.out.println("勾选一个复选框");
		return this.driver.findElement(chockboxLocator);
	}
	
	public WebElement deleteanniu(){
		System.out.println("点击“删除”按钮");
		return this.driver.findElement(deletebuttonLocator);
	}
	
	public WebElement cancelanniu(){
		System.out.println("点击“取消”按钮");
		return this.driver.findElement(cancelLocator);
	}

}
