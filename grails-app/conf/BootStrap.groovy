import java.util.ArrayList;

import org.hibernate.*
import org.springframework.web.context.support.WebApplicationContextUtils

import test.Form
import cn.gov.xaczj.*;
import cn.gov.xaczj.domain.*;
import groovy.xml.StreamingMarkupBuilder;

class BootStrap {
	
	/*
	 * 在spring中注册的对象实例，在服务器上下文都可以按照类似方式访问到。请查看conf/spring/resources.groovy
	 * start
	 */
	def dynamic;//spring容器托管的DynamicAdd实例。参考src/groovy/cn.gov.xaczj/DynamicAdd.groovy
	def tableList;
	/*end
	 */
	
    def init = { servletContext ->
		//可临时注释掉，加快调试		
					initCustomField();//
		    }
    def destroy = {
    }
	
	/**
	 * @brief 初始化数据库，定制数据库的列
	 * 初始化表格信息。将配置文件中的表格信息，持久化到数据库；
	 * 将表格的信息同时读取到服务器上下文中，可供随时查看。
	 */
	def initCustomField = {
		
		System.out.println("in boot strap");		
		initXml();		
		addFiledsOT();		
	}
	
/**
 * 在之前生成的表格多重映射配置文件中，在《dynamic-component》中对应的增加列，从而hibernate在数据库中可以创建这些列，
 * @return
 */
	def addFiledsOT() {
		String tableName = "";
		HashMap<String,String> fileds = new HashMap<String,String>();
		readCustomFiledsFromFile(tableList);//初始化spring托管的实例，将表格信息存入list中
		ArrayList<TableDynamic>  dyList = dynamic.getTableList();
		int formId;//store form id
		Form inDatabase;//used to insert or update form info
		for(TableDynamic tmp: dyList){
			//chen begin
			if(tmp == null){
				continue;
			}
			formId = Integer.parseInt(tmp.entityName.get("tableName").split("table")[1]);
			inDatabase = Form.findByNo(formId);
			
			if(inDatabase == null){
				inDatabase = new Form();
			}
			inDatabase.no = formId;
			inDatabase.name =  tmp.entityName.get("chTableName");
//			println("no:"+inDatabase.no +"name"+inDatabase.name);
			inDatabase.save(flush:true);//GORM will update it for u ^..^
			
			//chen end
		}
		CustomizableEntityManager tableEntityManager;
		for(int i=0; i<tableList.size(); i++)
		{		
			HibernateUtil.getInstance().getCurrentSession();
			fileds=tableList.get(i);
			tableName = fileds.get("tableName");
			tableEntityManager = new CustomizableEntityManagerImpl(Table.class,tableName);

			if(fileds.get("tableName") != null)
			{
				fileds.remove("tableName");
			}
			tableEntityManager.addCustomField(fileds);
		}
		
			
		
	}
	/**
	 * 初始化spring托管的实例，读取配置文件，将表格信息存入list中
	 * @param list 
	 * @return void
	 */
	private readCustomFiledsFromFile(ArrayList <HashMap <String,String>> list){

		dynamic.lunch(list);
	}
	/**
	 * 初始化 表格 多重映射的hibernate配置文件
	 * @return void
	 */
	def initXml()
	{
		def beginTime = new Date();
		def endTime ;
		println(beginTime.getTime());
		
		def writer = new PrintWriter (new FileWriter("src/java/cn/gov/xaczj/domain/Table.hbm.xml"),true);
//		def writer = new FileWriter("src/java/cn/gov/xaczj/domain/Table.hbm.xml");
		
	//	def comment = ''' <!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Configuration DTD//EN" "http://svn.compass-project.org/svn/compass/trunk/lib/hibernate/hibernate-mapping-3.0.dtd">'''
		def comment = ''' <!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Configuration DTD//EN" "./hibernate-mapping-3.0.dtd">'''
		int cnt=countXml();
		def xml = new StreamingMarkupBuilder().bind { 
			mkp.pi(xml: "version='1.0'  encoding='UTF-8' standalone='no'") 
			mkp.yieldUnescaped(comment)
		
			"hibernate-mapping"( "auto-import":"true", "default-access":"property", "default-cascade":"none", "default-lazy":"true"){
				for(int i=1;i<=cnt;i++)
				{
					"class"('abstract':"false","dynamic-insert":"false","dynamic-update":"false",
						"optimistic-lock":"version","polymorphism":"implicit","select-before-update":"false", 
						"name":"cn.gov.xaczj.domain.Table","table":"tbl_table${i}","entity-name":"table${i}")
					 {
						id("column":"id" ,"name":"id"){
								"generator"( "class":"native")
						}

						property("column":"initFillTime","generated":"never","lazy":"false","name":"initFillTime","optimistic-lock":"true","type":"date","unique":"false")
						property("column":"initFillPost","name":"initFillPost","optimistic-lock":"true")
						property("column":"inChargePost","name":"inChargePost","optimistic-lock":"true")
						property("column":"receivePost","name":"receivePost","optimistic-lock":"true")
						property("column":"status","generated":"never","lazy":"false","name":"status","optimistic-lock":"true","type":"short","unique":"false")
						property("column":"planTime","generated":"never","lazy":"false","name":"planTime","optimistic-lock":"true","type":"date","unique":"false")
						"dynamic-component"("insert":"true","name":"customProperties","optimistic-lock":"true","unique":"false","update":"true"){}
					}
				}
			
		    }
		}
//		println xml
		writer << xml;
		writer.flush();
		writer.close();
		endTime = new Date();
		println(endTime.getTime());
	}
	
	int countXml(){
		def dir = new File("src/groovy/xml")
		int num=0;
		dir.eachFile{
			if(it.name.endsWith('.xml'))
				num++;
		}
		return num;
	}
	
	
}