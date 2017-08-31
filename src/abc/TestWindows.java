package abc;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import abc.launch.Browsers;
import abc.launch.BrowsersType;

public class TestWindows {
	
//����������������´���
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod(){
		Browsers browsers = new Browsers(BrowsersType.firefox);
		this.driver = browsers.driver;
		this.driver.get("http://www.hao123.com/");
	}
	
	@AfterMethod
	public void afterMethod(){
		this.driver.quit();
	}
	
	@Test
	public void windows()throws Exception{
			
		WebDriver newWindow = null;
		//��ȡ��ǰҳ����
		String current_handles = this.driver.getWindowHandle();
		//������ٶ����ӡ�
		this.driver.findElement(By.xpath("//*[@data-title='�ٶ�']")).click();
		//�����������µĴ��ڴ򿪣���ȡ���д��ڵľ��
		Set<String> all_handles = this.driver.getWindowHandles();
		//ѭ���жϣ��ѵ�ǰ��������о�����Ƴ���ʣ�µľ�������Ҫ���´���
		Iterator<String> it = all_handles.iterator();
		while (it.hasNext()) {
			if (current_handles == it.next()) continue;
			//�����´��ڣ�������´��ڵ�driver - newWindow
			newWindow = this.driver.switchTo().window(it.next());
		}
		
		//����������ҳ����в�����Ҳ���ǰٶ���ҳ����������һ��Java�ؼ��ֽ�������
		Thread.sleep(5000);
		WebElement baidu_keyword = newWindow.findElement(By.id("kw"));
		baidu_keyword.sendKeys("java");
		Thread.sleep(1000);
		//�رյ�ǰ���ڣ���Ҫʹ��close������quite
		newWindow.close();
		//���ص���ǰҳ��
		this.driver.switchTo().window(current_handles);
		//�����ǰҳ���URL
		System.out.println(this.driver.getCurrentUrl());
	}
	
}	
/*�˷����ǣ�
 * ������еĴ��ڵ�titlenameֵ��
 * ѭ��-�жϴ������Ƿ����ָ����titlenameֵ��
 * ���������ѭ��-�����window��
 * ������������ѭ���жϴ��ڵ�titlenameֵ��
 */
	/*public void toSpecificWindow(){
		Set<String> handles = driver.getWindowHandles();
		String titlename;
		for(String handle:handles){
			titlename = driver.switchTo().window(handle).getTitle();
		if(titlename.contains("java_�ٶ�����"))cnblogs.com 
			break;
		}
	}

}*/
