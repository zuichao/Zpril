package abc.interfaces;

public interface Elements {
	String xiayiye = "//a[following-sibling::a[contains(text(),'��ת')] and @id='nextpage1']";
	String shoujianxiang = "//div[contains(text(),'�ռ���')]";
	//��̬Xpath��λ
	String mingcheng = String.format("//a[contains(text(),'%2$s')]", "��","C��","jack","Miss");
	
	String tianqi1 = "//span[ancestor::div[@id='weather'] and contains(@class,'info-txt')]";
	String tianqi2 = "//span[ancestor::div[@id='weather'] and contains(@class,'info-temperature')]";
}
