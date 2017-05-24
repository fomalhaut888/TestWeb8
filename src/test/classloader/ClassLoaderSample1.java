package test.classloader;

public class ClassLoaderSample1 {
	public static String getValue(){
			return "A value from WEB-INF/classes";
			//return "A value from WEB-INF/lib";//回傳值修改成此列,將此類別包成jar檔置於WEB-INF/lib目錄下
			//return "A value from Catalina_Home/lib";//回傳值修改此列,將此類別包成jar檔置於Catalina_Home/lib目錄下
			//結果:
			//預設使用各個ClassLoader相同類別的優先順序: 
			//		1. WEB-INF/classes/*  ->  2. WEB-INF/lib/* -> 3. Catalina_Home/lib (Common)
			//委派(delegate)使用各個ClassLoader相同類別的優先順序: 設定在server.xml內App的Context標籤內加上
			//			<Context ...><Loader delegate="true"/>...</Context>
			//		1. Catalina_Home/lib (Common) ->  2. WEB-INF/classes/* -> 3. WEB-INF/lib/*
			//to See Endorsed Standards Override Mechanism
	}
}
