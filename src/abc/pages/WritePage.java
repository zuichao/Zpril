package abc.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abc.interfaces.Elements;

public class WritePage extends BasePage {
	
//д��ҳ��
	
	//���캯��
	public WritePage(WebDriver driver){
		 super(driver);
	}
	
	//д�Ű�ť
	By writeLocator = By.id("composebtn");
	//�ռ���
	By shoujianrenLocator = By.id("toAreaCtrl");
	//����
	By zhutiLocator = By.id("subject");
	//����
	By zhengwenLocator = By.xpath("//html/body[@accesskey='q']");
	//���Ͱ�ť
	By fasongLocator = By.xpath("//div[@id='toolbar']/div/a[1]");
	
	//��ݸ�
	By cundraftLocator = By.xpath("//div[@id='toolbar']/div/a[3]");

			
	public WebElement getWriteLink(){
		System.out.println("�����д�š�");
		return this.driver.findElement(writeLocator);
	}
	
	public WebElement getshoujianren(){
		System.out.println("���롰�ռ��ˡ�");
		return this.driver.findElement(shoujianrenLocator);
	}
	
	public WebElement getzhuti(){
		System.out.println("���롰���⡱");
		return this.driver.findElement(zhutiLocator);
	}
	
	public WebElement getzhengwen(){
		System.out.println("���롰���ġ�");
		return this.driver.findElement(zhengwenLocator);
	}
	
	public WebElement getfasong(){
		System.out.println("��������͡���ť");
		return this.driver.findElement(fasongLocator);
	}
	
	public WebElement getcuncaogao(){
		System.out.println("�������ݸ塱");
		return this.driver.findElement(cundraftLocator);
	}
	
	//�������Ŀ��
	public void zwkj(){
		//���Ŀ��
		WebElement zwkjys = this.driver.findElement(By.xpath("/html/body/form[2]/div[2]/div[7]/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td/iframe"));
		driver.switchTo().frame(zwkjys);
		this.driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
	}
	
	//���ط���
	public void back () {
		//driver.switchTo().defaultContent();
  		//driver.switchTo().frame("mainFrame");
  		this.driver.navigate().back();
  		System.out.println("���������������ҳ��"+"\n"+"����ͨ��");
	}
	
	//������ܵ�mainFrame��ܲ��ȴ�һ��
	public void backwait(){
		this.driver.switchTo().defaultContent();
  		this.driver.switchTo().frame("mainFrame");
  		this.driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
	}
	
	//�ص������
	public void backzhu(){
		this.driver.switchTo().defaultContent();
		this.driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
	}
	
	//��ҳ���һ���
	public void waityihui(){
		this.driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
	}
	
	
	/**
	 * ������������ʱ�õ�     (TestDataDrive)
	 * ���Զ�̬Xpathʱ�õ���TestStringformat��
	 */
	public WebElement greet(){
		return this.driver.findElement(By.xpath(Elements.mingcheng));
	}
	
}
