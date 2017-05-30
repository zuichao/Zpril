package abc.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaiduPage extends BasePage {
	
	public BaiduPage(WebDriver driver){
		super(driver);
	}

//��¼��ҳ
	//�����Ʒ
	By gengduochanpinLocator = By.xpath("//a[contains(text(),'�����Ʒ')]");
	
	//����
	By yinyueLocator = By.xpath("//a[following-sibling::span[contains(text(),'�����������غ�������')] and contains(text(),'����')]");
	
	//�����
	By shurukuangLocator = By.xpath("//input[@id='ww']");

	//�ٶ�һ��
	By baiduyixiaLocator = By.xpath("//input[ancestor::form[@id='search_form'] and @value='�ٶ�һ��']");
	
	//����--(��һ�׸���)
	By xiazaiLocator = By.xpath("//a[ancestor::li[@id='first_song_li'] and contains(@class,'icon-download')]");
	
	//��׿����
	By anzhuoLocator = By.xpath("//a[ancestor::div[preceding-sibling::h3[contains(text(),'ͨ���ٶ����ֿͻ�������������')]] and contains(@class,'and-link')]");
	
	
	
	
	public WebElement gengduochanpin(){
		System.out.println("����������Ʒ��");
		return this.driver.findElement(gengduochanpinLocator);
	}
	
	public WebElement yinyue(){
		System.out.println("��������֡�");
		return this.driver.findElement(yinyueLocator);
	}
	
	public WebElement shurukuang(){
		System.out.println("������������롰�����롱");
		return this.driver.findElement(shurukuangLocator);
	}
	
	public WebElement baiduyixia(){
		System.out.println("������ٶ�һ�¡�");
		return this.driver.findElement(baiduyixiaLocator);
	}
	
	public WebElement xiazai(){
		System.out.println("�����һ�׸�ġ����ء�");
		return this.driver.findElement(xiazaiLocator);
	}
	
	public WebElement anzhuoxiazai(){
		System.out.println("�������׿���ء�");
		return this.driver.findElement(anzhuoLocator);
	}
	
	
	
	public void toSpecificWindow0(){
		Set<String> handles = driver.getWindowHandles();
		String titlename;
		for(String handle:handles){
			titlename = driver.switchTo().window(handle).getTitle();
		if(titlename.contains("�ٶ�����-��������")) 
			break;
		}
	}
	
	
	
	
	public void toSpecificWindow(){
		Set<String> handles = driver.getWindowHandles();
		String titlename;
		for(String handle:handles){
			titlename = driver.switchTo().window(handle).getTitle();
		if(titlename.contains("     ����_�ٶ�����-��������")) 
			System.out.println("���롮����_�ٶ�����-�������¡�ҳ��");
			break;
		}
	}
}
