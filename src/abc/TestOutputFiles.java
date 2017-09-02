package abc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import abc.interfaces.Outputs;
import abc.launchs.*;
import abc.pages.*;


/** 
* @author sunjian
* @version 2017��9��2�� ����16:41:49 
*/

public class TestOutputFiles {
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod(){
		Browsers browsers = new Browsers(BrowsersType.firefox);
		this.driver = browsers.driver;
	}
	@AfterMethod
	public void afterMethod(){
		this.driver.quit();
	}
	@Test
	public void testOutputFiles() throws Exception {
		String abc = "C:\\";
		String abd,abe;
		
		BaiduPage baidu = new BaiduPage(driver);
		WaitPage waitPage = new WaitPage();
		
	    this.driver.get("http://www.baidu.com/");
	    waitPage.wait2();
	    baidu.shurukuang().sendKeys("�пƺ��");
	    baidu.baiduyixia().click();
	    waitPage.wait3();
	    
	    Assert.assertEquals(baidu.zhongke().isDisplayed(), true);
	    
	    abd = abc+"�пƺ�Լ��"+".txt";
	    File file = new File(abd);
	    try {
	    	if(!file.exists()){
	    		createFile("�пƺ�Լ��", baidu.zhongke().getText());
		    	System.out.println("����д���ļ��ɹ�");
	    	}else{
	    		System.out.println("�ļ��Ѵ���");
	    	}		    	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    
	    abe = abc+"�пƺ�Լ�� - ����"+"+.txt";
	    File file1 = new File(abe);
	    try {
	    	if (file1.exists()){
	    		delFile("�пƺ�Լ�� - ����");
		    	System.out.println("�ļ�ɾ���ɹ�");
	    	}else{
	    		System.out.println("�ļ������ڣ�");
	    	}  	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    System.out.println(Outputs.tags2);
	}

//****************����Ϊ�����ļ���д���ļ���ɾ���ļ��ķ���****************************/
	
    //�����ļ�·��
    private static String path = "C:\\";
    
    //�ļ�·��+����
    private static String filenameTemp;
    /**
     * �����ļ�
     * @param fileName  �ļ�����
     * @param filecontent   �ļ�����
     * @return  �Ƿ񴴽��ɹ����ɹ��򷵻�true
     */
    public static boolean createFile(String fileName,String filecontent){
        Boolean bool = false;
        filenameTemp = path+fileName+".txt";//�ļ�·��+����+�ļ�����
        File file = new File(filenameTemp);
        try {
            //����ļ������ڣ��򴴽��µ��ļ�
            if(!file.exists()){
                file.createNewFile();
                bool = true;
                System.out.println("success create file,the file is "+filenameTemp);
                //�����ļ��ɹ���д�����ݵ��ļ���
                writeFileContent(filenameTemp, filecontent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return bool;
    }
    
    /**
     * ���ļ���д������
     * @param filepath �ļ�·��������
     * @param newstr  д�������
     * @return
     * @throws IOException
     */
    public static boolean writeFileContent(String filepath,String newstr) throws IOException{
        Boolean bool = false;
        String filein = newstr+"\r\n";//��д����У�����
        String temp  = "";
        
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos  = null;
        PrintWriter pw = null;
        try {
            File file = new File(filepath);//�ļ�·��(�����ļ�����)
            //���ļ�����������
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();
            
            //�ļ�ԭ������
            for(int i=0;(temp =br.readLine())!=null;i++){
                buffer.append(temp);
                // ������֮��ķָ��� �൱�ڡ�\n��
                buffer = buffer.append(System.getProperty("line.separator"));
                System.out.println(i);
            }
            buffer.append(filein);
            
            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buffer.toString().toCharArray());
            pw.flush();
            bool = true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            //��Ҫ���ǹر�
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return bool;
    }
    
    /**
     * ɾ���ļ�
     * @param fileName �ļ�����
     * @return
     */
    public static boolean delFile(String fileName){
        Boolean bool = false;
        filenameTemp = path+fileName+".txt";
        File file  = new File(filenameTemp);
        try {
            if(file.exists()){
                file.delete();
                bool = true;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return bool;
    }
    
}
