package abc.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WritePage extends BasePage {
	
//写信页面
	
	//构造函数
	public WritePage(WebDriver driver){
		 super(driver);
	}
	
	//写信按钮
	By writeLocator = By.id("composebtn");
	//收件人
	By shoujianrenLocator = By.id("toAreaCtrl");
	//主题
	By zhutiLocator = By.id("subject");
	//正文
	By zhengwenLocator = By.xpath("//html/body[@accesskey='q']");
	//发送按钮
	By fasongLocator = By.xpath("//div[@id='toolbar']/div/a[1]");
	
	//存草稿
	By cundraftLocator = By.xpath("//div[@id='toolbar']/div/a[3]");

			
	public WebElement getWriteLink(){
		System.out.println("点击“写信”");
		return this.driver.findElement(writeLocator);
	}
	
	public WebElement getshoujianren(){
		System.out.println("输入“收件人”");
		return this.driver.findElement(shoujianrenLocator);
	}
	
	public WebElement getzhuti(){
		System.out.println("输入“主题”");
		return this.driver.findElement(zhutiLocator);
	}
	
	public WebElement getzhengwen(){
		System.out.println("输入“正文”");
		return this.driver.findElement(zhengwenLocator);
	}
	
	public WebElement getfasong(){
		System.out.println("点击“发送”按钮");
		return this.driver.findElement(fasongLocator);
	}
	
	public WebElement getcuncaogao(){
		System.out.println("点击“存草稿”");
		return this.driver.findElement(cundraftLocator);
	}
	
	//进入正文框架
	public void zwkj(){
		//正文框架
		WebElement zwkjys = this.driver.findElement(By.xpath("/html/body/form[2]/div[2]/div[7]/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td/iframe"));
		driver.switchTo().frame(zwkjys);
		this.driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
	}
	
	//返回方法
	public void back () {
		//driver.switchTo().defaultContent();
  		//driver.switchTo().frame("mainFrame");
  		driver.navigate().back();
  		System.out.println("点击“返回邮箱首页”"+"\n"+"测试通过");
	}
	
	//从主框架到mainFrame框架并等待一下
	public void backwait(){
		driver.switchTo().defaultContent();
  		driver.switchTo().frame("mainFrame");
  		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
	}
	
	//回到主框架
	public void backzhu(){
		driver.switchTo().defaultContent();
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
	}
	
	//在页面等一会儿
	public void waityihui(){
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
	}
}
