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
* @version 2017年9月2日 下午16:41:49 
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
	    baidu.shurukuang().sendKeys("中科虹霸");
	    baidu.baiduyixia().click();
	    waitPage.wait3();
	    
	    Assert.assertEquals(baidu.zhongke().isDisplayed(), true);
	    
	    abd = abc+"中科虹霸简介"+".txt";
	    File file = new File(abd);
	    try {
	    	if(!file.exists()){
	    		createFile("中科虹霸简介", baidu.zhongke().getText());
		    	System.out.println("内容写入文件成功");
	    	}else{
	    		System.out.println("文件已存在");
	    	}		    	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    
	    abe = abc+"中科虹霸简介 - 副本"+"+.txt";
	    File file1 = new File(abe);
	    try {
	    	if (file1.exists()){
	    		delFile("中科虹霸简介 - 副本");
		    	System.out.println("文件删除成功");
	    	}else{
	    		System.out.println("文件不存在！");
	    	}  	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    System.out.println(Outputs.tags2);
	}

//****************以下为创建文件、写入文件、删除文件的方法****************************/
	
    //生成文件路径
    private static String path = "C:\\";
    
    //文件路径+名称
    private static String filenameTemp;
    /**
     * 创建文件
     * @param fileName  文件名称
     * @param filecontent   文件内容
     * @return  是否创建成功，成功则返回true
     */
    public static boolean createFile(String fileName,String filecontent){
        Boolean bool = false;
        filenameTemp = path+fileName+".txt";//文件路径+名称+文件类型
        File file = new File(filenameTemp);
        try {
            //如果文件不存在，则创建新的文件
            if(!file.exists()){
                file.createNewFile();
                bool = true;
                System.out.println("success create file,the file is "+filenameTemp);
                //创建文件成功后，写入内容到文件里
                writeFileContent(filenameTemp, filecontent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return bool;
    }
    
    /**
     * 向文件中写入内容
     * @param filepath 文件路径与名称
     * @param newstr  写入的内容
     * @return
     * @throws IOException
     */
    public static boolean writeFileContent(String filepath,String newstr) throws IOException{
        Boolean bool = false;
        String filein = newstr+"\r\n";//新写入的行，换行
        String temp  = "";
        
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos  = null;
        PrintWriter pw = null;
        try {
            File file = new File(filepath);//文件路径(包括文件名称)
            //将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();
            
            //文件原有内容
            for(int i=0;(temp =br.readLine())!=null;i++){
                buffer.append(temp);
                // 行与行之间的分隔符 相当于“\n”
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
            //不要忘记关闭
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
     * 删除文件
     * @param fileName 文件名称
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
