package abc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import abc.launch.Browsers;
import abc.launch.BrowsersType;

public class TestCanvas {
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod(){
		Browsers browsers = new Browsers(BrowsersType.firefox);
		this.driver = browsers.driver;
		this.driver.get("http://literallycanvas.com/");
	}
	
	@AfterMethod
	public void afterMethod(){
		this.driver.quit();
	}
	
	@Test
	public void canvas()throws Exception{
		
		Thread.sleep(3000);
		
		//�ҵ�canvasԪ��
     	WebElement canvas = this.driver.findElement(By.xpath("//*[@id='literally-canvas']//canvas[2]"));
     	
     	//������������canvas��
     	Point op = this.driver.findElement(By.xpath("//*[@id='literally-canvas']//canvas[2]")).getLocation();
     	((JavascriptExecutor)driver).executeScript("window.scrollBy("+op.getX()+", "+op.getY()+")");

     	Thread.sleep(3000);
		//����һ��������
		Actions drawPen = new Actions(driver);
		//��������ֲ�����꣬���ո�����������ƶ�
		drawPen.clickAndHold(canvas).moveByOffset(10, 150).moveByOffset(1000, 20).moveByOffset(-20, -1000).moveByOffset(-100,-20).release().perform();
		Thread.sleep(5000);
	}

}
