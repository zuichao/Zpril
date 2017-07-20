package abc.launch;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browsers {

	public WebDriver driver = null;
	
	public Browsers (BrowsersType browserstype){
		switch (browserstype) {
		case firefox:
			try {
				System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("�Ҳ����������λ�ã�����");
			}
			driver = new FirefoxDriver();
			
			//�������
			driver.manage().window().maximize();
			
//			//���ô��ڵĿ�ȣ�1000 �߶ȣ�500
//			Dimension d = new Dimension(1000, 500);
//			driver.manage().window().setSize(d);
//			
//			//���ô��ڵ����꣬���ȣ�200 γ�ȣ�100
//			Point p = new Point(200, 100);
//			driver.manage().window().setPosition(p);
			break;
			
		case ie:
			try {
				System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("�Ҳ����������λ�ã�����");
			}
			driver = new InternetExplorerDriver();
			
			//�������
			//driver.manage().window().maximize();
			
			//���ô��ڵĿ�ȣ�800 �߶ȣ�800
			Dimension a = new Dimension(800, 800);
			driver.manage().window().setSize(a);
			
			//���ô��ڵ����꣬���ȣ�800 γ�ȣ�800
			Point b = new Point(800, 800);
			driver.manage().window().setPosition(b);
			break;		
			
		case chrome:
			try {
				System.setProperty("webdriver.chrome.driver", "E:/selenium/chrome1/chromedriver.exe");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("�Ҳ����������λ�ã�����");
			}
			driver = new ChromeDriver();
			
			//�������
			//driver.manage().window().maximize();
			
			//���ô��ڵĿ�ȣ�800 �߶ȣ�800
			Dimension c = new Dimension(800, 800);
			driver.manage().window().setSize(c);
			
			//���ô��ڵ����꣬���ȣ�800 γ�ȣ�800
			Point e = new Point(800, 800);
			driver.manage().window().setPosition(e);
			
			driver.manage().window().maximize();
			break;
		}
	}

}
