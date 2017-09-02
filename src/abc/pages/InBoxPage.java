package abc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InBoxPage extends BasePage {

//�ռ���ҳ��
	//���췽��
	public InBoxPage(WebDriver driver){
		super(driver);
	}
	
	//"�ռ���"��ť
	By inboxButtonLocator = By.xpath("//b[ancestor::a[@id='folder_1'] and contains(text(),'�ռ���')]");
	
	//��ѡ��ѡ��
	By ChockBoxsLocator = By.xpath("//form[@id='frm']//div[5]/table[1]/tbody/tr/td[1]/input");
	
	//�Ǳ�
	By xingLocator = By.xpath("//div[@id='div_showlastweek']/table[1]/tbody/tr/td[3]/table/tbody/tr/td[5]");
	
	//�鿴�ʼ�
	By lookmailLocator = By.xpath("//div[@id='div_showlastweek']/table[1]/tbody/tr/td[3]");
	
	
	public WebElement inbox(){
		System.out.println("������ռ��䡱��ť");
		return this.driver.findElement(inboxButtonLocator);
	}
	
	public WebElement chockboxs(){
		System.out.println("��ѡһ����ѡ��");
		return this.driver.findElement(ChockBoxsLocator);
	}
	
	public WebElement xingbiao(){
		System.out.println("�����Ǳ�");
		return this.driver.findElement(xingLocator);
	}
	
	public WebElement lookmail(){
		System.out.println("�鿴�ʼ�");
		return this.driver.findElement(lookmailLocator);
	}
	
}
