package abc.pages;

import java.io.File;
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
	By shurukuangLocator = By.xpath("//input[@id='kw']");

	//�ٶ�һ��
	By baiduyixiaLocator = By.xpath("//input[@id='su']");
	
	//����--(��һ�׸���)
	By xiazaiLocator = By.xpath("//a[ancestor::li[@id='first_song_li'] and contains(@class,'icon-download')]");
	
	//��׿����
	By anzhuoLocator = By.xpath("//a[ancestor::div[preceding-sibling::h3[contains(text(),'ͨ���ٶ����ֿͻ�������������')]] and contains(@class,'and-link')]");

	
//����԰��ҳ
	
	//��¼
	By dengluLocator = By.xpath("//a[contains(text(),'��¼')]");
	
	//�û���
	By yonghumingLocator = By.xpath("//input[@id='input1']");
	
	//����
	By mimaLocator = By.xpath("//input[@id='input2']");
	
	//�ύ��¼
	By submitLocator = By.xpath("//input[@id='signin']");
	
	//�˳�����
	By myLocator = By.xpath("//a[contains(text(),'�˳�����')]");
	
	//����ͷ��
	By genghuantouxiangLocator = By.xpath("//a[contains(text(),'�޸�ͷ��')]");
	
	//�ϴ�ͼƬ
	By uploadtupianLocator = By.xpath("//div[ancestor::div[contains(@class,'span12')]]");
	
	//���в�����
	By baocunLocator = By.xpath("//input[contains(@id,'operation_submit')]");
	
	//����԰
	By bokeyuanLocator = By.xpath("//a[child::em[contains(text(),'����԰')] and contains(@class,'favurl')]");
	
	public WebElement bokeyuan(){
		System.out.println("�������԰����");
		return this.driver.findElement(bokeyuanLocator);
	}
	public WebElement denglu(){
		System.out.println("�����¼��ť");
		return this.driver.findElement(dengluLocator);
	}
	public WebElement yonghuming(){
		System.out.println("�����û���");
		return this.driver.findElement(yonghumingLocator);
	}
	public WebElement mima(){
		System.out.println("��������");
		return this.driver.findElement(mimaLocator);
	}
	public WebElement tijiao(){
		System.out.println("�����¼��ť���ύ��¼");
		return this.driver.findElement(submitLocator);
	}
	public WebElement my(){
		System.out.println("����ҵ�����");
		return this.driver.findElement(myLocator);
	}
	public WebElement xiugaitupian(){
		System.out.println("����޸�ͼƬ");
		return this.driver.findElement(genghuantouxiangLocator);
	}
	public WebElement uploadtupian(){
		System.out.println("����ϴ�ͼƬ");
		return this.driver.findElement(uploadtupianLocator);
	}
	public WebElement baocun(){
		System.out.println("������в�����");
		return this.driver.findElement(baocunLocator);
	}
	
//�ϴ��ļ��ķ���
	/**
	* �ϴ��ļ�����Ҫ��������ϴ���Ƭ�Ĵ��ڲ���
	*
	* @parambrower
	*            ʹ�õ����������
	* @paramfile
	*            ��Ҫ�ϴ����ļ����ļ���
	*/
	public void upload(String browser, File file) {
	    String filePath= file.getAbsolutePath();
	    String executeFile= "H:/selenium/tools/Upload.exe"; //������upload.exe�ļ���·��
	    String cmd= "\""+ executeFile+ "\""+ " "+ "\""+ browser+ "\""+ " "+ "\""+ filePath+ "\"";
	    try{
	        Process p= Runtime.getRuntime().exec(cmd);
	        p.waitFor();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public WebElement gengduochanpin(){
		System.out.println("����������Ʒ��");
		return this.driver.findElement(gengduochanpinLocator);
	}
	
	public WebElement yinyue(){
		System.out.println("��������֡�");
		return this.driver.findElement(yinyueLocator);
	}
	
	public WebElement shurukuang(){
		System.out.println("������������롰��Ҫ���������ݡ�");
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
