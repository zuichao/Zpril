package abc.interfaces;

public interface Elements {
	String xiayiye = "//a[following-sibling::a[contains(text(),'��ת')] and @id='nextpage1']";
	String shoujianxiang = "//div[contains(text(),'�ռ���')]";
	//��̬Xpath��λ
	String mingcheng = String.format("//a[contains(text(),'%2$s')]", "��","C��","jack","Miss");
}
