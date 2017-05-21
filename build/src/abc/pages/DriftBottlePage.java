package abc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriftBottlePage extends BasePage {
	
//Ư��ƿҳ��
	//���췽��
	public DriftBottlePage(WebDriver driver){
		super(driver);
	}
	
	//��Ư��ƿ����ť
	By DriftbottleLocator = By.id("folder_11");
	
	//����һ������ť
	By RengyigeLocator = By.xpath("/html/body/div[16]/div[22]/div/a[1]");
	
	//�����̿�����ť
	By LaoyigeLocator = By.xpath("//*[id='toolbar']/div/a[2]");
	
	//���ҵ�ƿ�ӡ���ť
	By MybottleLocator = By.xpath("//*[id='toolbar']/div/a[3]");
	
	//"�鿴����Ӧ"��ť
	By LookbackLocator = By.xpath("//*[@id='bottle_paperlist']/ul/li[1]/div/div/div[2]/a");
	
	//�����һ����ߵġ���ͨƿ����ť
	By PutongLocator = By.xpath("//*[@id='bottle_magic']/div/div[1]/a[1]");
	//�����һ����ߵġ�����ƿ����ť
	By XingqingLocator = By.xpath("//*[@id='bottle_magic']/div/div[1]/a[2]");
	//�����һ����ߵġ�����ƿ����ť
	By DingxiangLocator = By.xpath("//*[@id='bottle_magic']/div/div[1]/a[3]");
	//�����һ����ߵġ��滰ƿ����ť
	By ZhenhuaLocator = By.xpath("//*[@id='bottle_magic']/div/div[1]/a[4]");
	//�����һ����ߵġ�����ƿ����ť
	By TiwenLocator = By.xpath("//*[@id='bottle_magic']/div/div[1]/a[5]");
	//�����һ����ߵġ�����ƿ����ť
	By JiaowangLocator = By.xpath("//*[@id='bottle_magic']/div/div[1]/a[6]");
	//�����һ����ߵġ�ףԸƿ����ť
	By ZhuyuanLocator = By.xpath("//*[@id='bottle_magic']/div/div[1]/a[7]");
	//�����һ����ߵġ�����ƿ����ť
	By ChuandiLocator = By.xpath("//*[@id='bottle_magic']/div/div[1]/a[8]");
	
	//�㿪��ͨƿ--�������ı�����Ԫ��
	By PutongpingShuruLocator = By.xpath("//*[@id='bottle_send']/div[2]/div[1]/div[4]/div[2]/div[1]/textarea");
	
	//������ɺ�--���ӳ�ȥ����ť
	By RengchuquLocator = By.xpath("/html/body/div[16]/div[12]/div[2]/div[2]/div[2]/a[2]");
	
	//�㿪����ƿ--�������¡���ť
	By YouxinshiLocator = By.xpath("//*[@id='bottle_send']/div[2]/div[1]/div/div[2]/ul/li[1]");
	//�㿪����ƿ--���е��㡱��ť
	By YoudianzaoLocator = By.xpath("//*[@id='bottle_send']/div[2]/div[1]/div/div[2]/ul/li[3]");
	//�㿪����ƿ--�������顱��ť
	By HaoxinqingLocator = By.xpath("//*[@id='bottle_send']/div[2]/div[1]/div/div[2]/ul/li[2]");
	
	//��һ��--����ƿ--�������顱���������¡������е��㡱--�����ı���Ԫ��
	By xinqingShuruiShuruLocator = By.xpath("//*[@id='bottle_send']/div[2]/div[1]/div[3]/div[2]/div[1]/textarea");
	
	
	public WebElement Piaoliuping(){
		System.out.println("�����Ư��ƿ��");
		return this.driver.findElement(DriftbottleLocator);
	}
	
	public WebElement Rengyige(){
		System.out.println("�������һ����");
		return this.driver.findElement(RengyigeLocator);
	}
	
	public WebElement Laolaokan(){
		System.out.println("��������̿���");
		return this.driver.findElement(LaoyigeLocator);
	}
	
	public WebElement Wodepingzi(){
		System.out.println("������ҵ�ƿ�ӡ�");
		return this.driver.findElement(MybottleLocator);
	}
	
	public WebElement Chakanhuiying(){
		System.out.println("������鿴����Ӧ��");
		return this.driver.findElement(LookbackLocator);
	}
	
//��ͨƿ�����롱---���ӳ�ȥ��
	public WebElement Putong(){
		System.out.println("�������ͨƿ��");
		return this.driver.findElement(PutongLocator);
	}

	public WebElement PutongShuru(){
		System.out.println("����ͨƿ���������ݣ�");
		return this.driver.findElement(PutongpingShuruLocator);
	}
	
	public WebElement Rengchuqu(){
		System.out.println("������ӳ�ȥ��"+"\n"+"-_- -_- -_-���ƿ�ӱ��ӳ�ȥඣ�����");
		return this.driver.findElement(RengchuquLocator);
	}
	
//����ƿ�����롱---���ӳ�ȥ��
	public WebElement Xingqing(){
		System.out.println("���������ƿ��");
		return this.driver.findElement(XingqingLocator);
	}
	
	public WebElement Haoxinqing(){
		System.out.println("����������顱");
		return this.driver.findElement(HaoxinqingLocator);
	}
	
	public WebElement Youdianzao(){
		System.out.println("������е��㡱");
		return this.driver.findElement(YoudianzaoLocator);
	}
	
	public WebElement Youxinshi(){
		System.out.println("����������¡�");
		return this.driver.findElement(YouxinshiLocator);
	}
	
	public WebElement Xinqingshuru(){
		System.out.println("������ƿ--������ƿ���������ݣ�");
		return this.driver.findElement(xinqingShuruiShuruLocator);
	}
}
