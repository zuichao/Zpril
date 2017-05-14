package abc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DraftBoxPage extends BasePage {
	
//�ݸ���ҳ��
	//���췽��
	public DraftBoxPage(WebDriver driver){
		super(driver);
	}
	
	//�ݸ��䰴ť
	By draftboxLocator = By.id("folder_4");
	
	//��ѡ��ѡ��
	By chockboxLocator = By.xpath("//form[@id='frm']/div[5]/table/tbody/tr/td[1]/input");
	
	//ɾ����ť
	By deletebuttonLocator = By.id("quick_del");
	
	//ȡ����ť
	By cancelLocator = By.id("QMconfirm_QMDialog_cancel");
	
	
	public WebElement draftbox(){
		System.out.println("������ݸ��䡱");
		return this.driver.findElement(draftboxLocator);
	}
	
	public WebElement chockbox(){
		System.out.println("��ѡһ����ѡ��");
		return this.driver.findElement(chockboxLocator);
	}
	
	public WebElement deleteanniu(){
		System.out.println("�����ɾ������ť");
		return this.driver.findElement(deletebuttonLocator);
	}
	
	public WebElement cancelanniu(){
		System.out.println("�����ȡ������ť");
		return this.driver.findElement(cancelLocator);
	}

}
