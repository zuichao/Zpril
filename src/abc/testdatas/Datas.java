package abc.testdatas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Datas {
	
	private String filePath;
	private String nextLine[];
	List<String[]> approvalList = new ArrayList<String[]>();
	CSVReader reader;
	
	private String value;
	
	public Datas(String filePath){
		this.filePath = filePath;
	}
	
	/**
	 * @author sunjian
	 * @param  columnName
	 * @param  lineName
	 * @return
	 */
	
	public String getTestData(String columnName,String lineName){
		try {
			reader = new CSVReader(new FileReader(filePath));
			try{
				while ((nextLine = reader.readNext()) != null) {
					//System.out.println("aa");
					approvalList.add(nextLine);
				}
			}catch(IOException e){
				e.printStackTrace();
			}
			
			//获取某一列
			int count = 0;
			int index = 0;
			
			for(String j:approvalList.get(0)){
				count++;
				if(j.equals(columnName)){
					index = count-1;
				}
			}
			
			
			//获取某一行
			for(String[]i:approvalList){
				if(i[0].equals(lineName))
					value = i[index].toString();
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return value;
	}
			
	
	
	public static void main(String[] args){
		//找到csv文件的位置
		Datas a = new Datas(System.getProperty("user.dir")+"/src/abc/testdatas/testdata.csv");
		
		for(int i=1; i<=3; i++){
			System.out.println(a.getTestData("username", "tc"+i)+","+a.getTestData("URL", "tc"+i));
		}
	}
	

}
