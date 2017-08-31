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

//登录首页
	//更多产品
	By gengduochanpinLocator = By.xpath("//a[contains(text(),'更多产品')]");
	
	//音乐
	By yinyueLocator = By.xpath("//a[following-sibling::span[contains(text(),'搜索试听下载海量音乐')] and contains(text(),'音乐')]");
	
	//输入框
	By shurukuangLocator = By.xpath("//input[@id='kw']");

	//百度一下
	By baiduyixiaLocator = By.xpath("//input[@id='su']");
	
	//下载--(第一首歌曲)
	By xiazaiLocator = By.xpath("//a[ancestor::li[@id='first_song_li'] and contains(@class,'icon-download')]");
	
	//安卓下载
	By anzhuoLocator = By.xpath("//a[ancestor::div[preceding-sibling::h3[contains(text(),'通过百度音乐客户端无限制下载')]] and contains(@class,'and-link')]");

	
//博客园网页
	
	//登录
	By dengluLocator = By.xpath("//a[contains(text(),'登录')]");
	
	//用户名
	By yonghumingLocator = By.xpath("//input[@id='input1']");
	
	//密码
	By mimaLocator = By.xpath("//input[@id='input2']");
	
	//提交登录
	By submitLocator = By.xpath("//input[@id='signin']");
	
	//乘除减加
	By myLocator = By.xpath("//a[contains(text(),'乘除减加')]");
	
	//更换头像
	By genghuantouxiangLocator = By.xpath("//a[contains(text(),'修改头像')]");
	
	//上传图片
	By uploadtupianLocator = By.xpath("//div[ancestor::div[contains(@class,'span12')]]");
	
	//裁切并保存
	By baocunLocator = By.xpath("//input[contains(@id,'operation_submit')]");
	
	//博客园
	By bokeyuanLocator = By.xpath("//a[child::em[contains(text(),'博客园')] and contains(@class,'favurl')]");
	
	public WebElement bokeyuan(){
		System.out.println("点击博客园链接");
		return this.driver.findElement(bokeyuanLocator);
	}
	public WebElement denglu(){
		System.out.println("点击登录按钮");
		return this.driver.findElement(dengluLocator);
	}
	public WebElement yonghuming(){
		System.out.println("输入用户名");
		return this.driver.findElement(yonghumingLocator);
	}
	public WebElement mima(){
		System.out.println("输入密码");
		return this.driver.findElement(mimaLocator);
	}
	public WebElement tijiao(){
		System.out.println("点击登录按钮，提交登录");
		return this.driver.findElement(submitLocator);
	}
	public WebElement my(){
		System.out.println("点击我的名字");
		return this.driver.findElement(myLocator);
	}
	public WebElement xiugaitupian(){
		System.out.println("点击修改图片");
		return this.driver.findElement(genghuantouxiangLocator);
	}
	public WebElement uploadtupian(){
		System.out.println("点击上传图片");
		return this.driver.findElement(uploadtupianLocator);
	}
	public WebElement baocun(){
		System.out.println("点击裁切并保存");
		return this.driver.findElement(baocunLocator);
	}
	
//上传文件的方法
	/**
	* 上传文件，需要点击弹出上传照片的窗口才行
	*
	* @parambrower
	*            使用的浏览器名称
	* @paramfile
	*            需要上传的文件及文件名
	*/
	public void upload(String browser, File file) {
	    String filePath= file.getAbsolutePath();
	    String executeFile= "H:/selenium/tools/Upload.exe"; //定义了upload.exe文件的路径
	    String cmd= "\""+ executeFile+ "\""+ " "+ "\""+ browser+ "\""+ " "+ "\""+ filePath+ "\"";
	    try{
	        Process p= Runtime.getRuntime().exec(cmd);
	        p.waitFor();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public WebElement gengduochanpin(){
		System.out.println("点击“更多产品”");
		return this.driver.findElement(gengduochanpinLocator);
	}
	
	public WebElement yinyue(){
		System.out.println("点击‘音乐’");
		return this.driver.findElement(yinyueLocator);
	}
	
	public WebElement shurukuang(){
		System.out.println("在输入框中输入“我要搜索的内容”");
		return this.driver.findElement(shurukuangLocator);
	}
	
	public WebElement baiduyixia(){
		System.out.println("点击‘百度一下’");
		return this.driver.findElement(baiduyixiaLocator);
	}
	
	public WebElement xiazai(){
		System.out.println("点击第一首歌的‘下载’");
		return this.driver.findElement(xiazaiLocator);
	}
	
	public WebElement anzhuoxiazai(){
		System.out.println("点击‘安卓下载’");
		return this.driver.findElement(anzhuoLocator);
	}
	
	
	
	public void toSpecificWindow0(){
		Set<String> handles = driver.getWindowHandles();
		String titlename;
		for(String handle:handles){
			titlename = driver.switchTo().window(handle).getTitle();
		if(titlename.contains("百度音乐-听到极致")) 
			break;
		}
	}
	
	
	
	
	public void toSpecificWindow(){
		Set<String> handles = driver.getWindowHandles();
		String titlename;
		for(String handle:handles){
			titlename = driver.switchTo().window(handle).getTitle();
		if(titlename.contains("     下载_百度音乐-听到极致")) 
			System.out.println("跳入‘下载_百度音乐-听到极致’页面");
			break;
		}
	}
}
