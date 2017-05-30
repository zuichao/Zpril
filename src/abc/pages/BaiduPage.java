package abc.pages;

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
	By shurukuangLocator = By.xpath("//input[@id='ww']");

	//百度一下
	By baiduyixiaLocator = By.xpath("//input[ancestor::form[@id='search_form'] and @value='百度一下']");
	
	//下载--(第一首歌曲)
	By xiazaiLocator = By.xpath("//a[ancestor::li[@id='first_song_li'] and contains(@class,'icon-download')]");
	
	//安卓下载
	By anzhuoLocator = By.xpath("//a[ancestor::div[preceding-sibling::h3[contains(text(),'通过百度音乐客户端无限制下载')]] and contains(@class,'and-link')]");
	
	
	
	
	public WebElement gengduochanpin(){
		System.out.println("点击“更多产品”");
		return this.driver.findElement(gengduochanpinLocator);
	}
	
	public WebElement yinyue(){
		System.out.println("点击‘音乐’");
		return this.driver.findElement(yinyueLocator);
	}
	
	public WebElement shurukuang(){
		System.out.println("在输入框中输入“任贤齐”");
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
