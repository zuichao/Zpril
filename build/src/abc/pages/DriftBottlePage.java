package abc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriftBottlePage extends BasePage {
	
//漂流瓶页面
	//构造方法
	public DriftBottlePage(WebDriver driver){
		super(driver);
	}
	
	//“漂流瓶”按钮
	By DriftbottleLocator = By.id("folder_11");
	
	//“扔一个”按钮
	By RengyigeLocator = By.xpath("/html/body/div[16]/div[22]/div/a[1]");
	
	//“捞捞看”按钮
	By LaoyigeLocator = By.xpath("//*[id='toolbar']/div/a[2]");
	
	//“我的瓶子”按钮
	By MybottleLocator = By.xpath("//*[id='toolbar']/div/a[3]");
	
	//"查看并回应"按钮
	By LookbackLocator = By.xpath("//*[@id='bottle_paperlist']/ul/li[1]/div/div/div[2]/a");
	
	//点击扔一个里边的“普通瓶”按钮
	By PutongLocator = By.xpath("//*[@id='bottle_magic']/div/div[1]/a[1]");
	//点击扔一个里边的“心情瓶”按钮
	By XingqingLocator = By.xpath("//*[@id='bottle_magic']/div/div[1]/a[2]");
	//点击扔一个里边的“定向瓶”按钮
	By DingxiangLocator = By.xpath("//*[@id='bottle_magic']/div/div[1]/a[3]");
	//点击扔一个里边的“真话瓶”按钮
	By ZhenhuaLocator = By.xpath("//*[@id='bottle_magic']/div/div[1]/a[4]");
	//点击扔一个里边的“提问瓶”按钮
	By TiwenLocator = By.xpath("//*[@id='bottle_magic']/div/div[1]/a[5]");
	//点击扔一个里边的“交往瓶”按钮
	By JiaowangLocator = By.xpath("//*[@id='bottle_magic']/div/div[1]/a[6]");
	//点击扔一个里边的“祝愿瓶”按钮
	By ZhuyuanLocator = By.xpath("//*[@id='bottle_magic']/div/div[1]/a[7]");
	//点击扔一个里边的“传递瓶”按钮
	By ChuandiLocator = By.xpath("//*[@id='bottle_magic']/div/div[1]/a[8]");
	
	//点开普通瓶--“输入文本”的元素
	By PutongpingShuruLocator = By.xpath("//*[@id='bottle_send']/div[2]/div[1]/div[4]/div[2]/div[1]/textarea");
	
	//输入完成后--“扔出去”按钮
	By RengchuquLocator = By.xpath("/html/body/div[16]/div[12]/div[2]/div[2]/div[2]/a[2]");
	
	//点开心情瓶--“有心事”按钮
	By YouxinshiLocator = By.xpath("//*[@id='bottle_send']/div[2]/div[1]/div/div[2]/ul/li[1]");
	//点开心情瓶--“有点糟”按钮
	By YoudianzaoLocator = By.xpath("//*[@id='bottle_send']/div[2]/div[1]/div/div[2]/ul/li[3]");
	//点开心情瓶--“好心情”按钮
	By HaoxinqingLocator = By.xpath("//*[@id='bottle_send']/div[2]/div[1]/div/div[2]/ul/li[2]");
	
	//扔一个--心情瓶--“好心情”、“有心事”、“有点糟”--输入文本的元素
	By xinqingShuruiShuruLocator = By.xpath("//*[@id='bottle_send']/div[2]/div[1]/div[3]/div[2]/div[1]/textarea");
	
	
	public WebElement Piaoliuping(){
		System.out.println("点击“漂流瓶”");
		return this.driver.findElement(DriftbottleLocator);
	}
	
	public WebElement Rengyige(){
		System.out.println("点击“扔一个”");
		return this.driver.findElement(RengyigeLocator);
	}
	
	public WebElement Laolaokan(){
		System.out.println("点击“捞捞看”");
		return this.driver.findElement(LaoyigeLocator);
	}
	
	public WebElement Wodepingzi(){
		System.out.println("点击“我的瓶子”");
		return this.driver.findElement(MybottleLocator);
	}
	
	public WebElement Chakanhuiying(){
		System.out.println("点击“查看并回应”");
		return this.driver.findElement(LookbackLocator);
	}
	
//普通瓶“输入”---“扔出去”
	public WebElement Putong(){
		System.out.println("点击“普通瓶”");
		return this.driver.findElement(PutongLocator);
	}

	public WebElement PutongShuru(){
		System.out.println("在普通瓶中输入内容：");
		return this.driver.findElement(PutongpingShuruLocator);
	}
	
	public WebElement Rengchuqu(){
		System.out.println("点击“扔出去”"+"\n"+"-_- -_- -_-这个瓶子被扔出去喽！！！");
		return this.driver.findElement(RengchuquLocator);
	}
	
//心情瓶“输入”---“扔出去”
	public WebElement Xingqing(){
		System.out.println("点击“心情瓶”");
		return this.driver.findElement(XingqingLocator);
	}
	
	public WebElement Haoxinqing(){
		System.out.println("点击“好心情”");
		return this.driver.findElement(HaoxinqingLocator);
	}
	
	public WebElement Youdianzao(){
		System.out.println("点击“有点糟”");
		return this.driver.findElement(YoudianzaoLocator);
	}
	
	public WebElement Youxinshi(){
		System.out.println("点击“有心事”");
		return this.driver.findElement(YouxinshiLocator);
	}
	
	public WebElement Xinqingshuru(){
		System.out.println("在心情瓶--好心情瓶中输入内容：");
		return this.driver.findElement(xinqingShuruiShuruLocator);
	}
}
