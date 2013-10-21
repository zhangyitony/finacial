package test

import cn.gov.xaczj.TableDynamic
import java.io.Serializable;
import java.util.List;
import java.util.LinkedHashMap.Entry
import org.springframework.dao.DataIntegrityViolationException
import grails.converters.*
import java.util.Map.Entry
import groovy.json.*
import org.hibernate.*;
import cn.gov.xaczj.*;
import cn.gov.xaczj.domain.Table

class PrintController {
	def dynamic;
	def tableList;
	
	
	def makeList(Long id)
	{

		int myPostNo = session.acountPost.no;
//		int inChargePostNo;
//		int receivePostNo;
//		String audit = params.audit;
//		String command = params.command;//存储命令码
//		int commandNo = Integer.parseInt(params.commandNo);//命令码字符
//		boolean isAudit = audit?.equals("true")?true:false;//是否是查找需要审核的表记录
		
		int index = id-1;
//		def typeList = tableList.get(index);
		
		def tableDyList = dynamic.getTableList();
		TableDynamic td = tableDyList.get(index);
		Map formName=td.entityName;//存放表格的entityname与真实中文名称
		
		int tableId = id;//表号
		String tableInDBName = formName.get("tableName");//表在数据库中的名字
//		String tableRealName = formName.get("chTableName");//表的真实名字，中文名称
		String sql;
//		switch(commandNo){
//			case 0:
			//选择需要展示草表的数据
			sql = "select * from tbl_$tableInDBName as record where record.receivePost = "+myPostNo+" and record.inchargePost = "+myPostNo;
//			break;
//			case 1:
//			sql = "select * from tbl_$tableInDBName as record where record.receivePost = "+myPostNo+" and record.inchargePost != "+myPostNo;
//			break;
			
//		}
		
		Query qy = HibernateUtil.getInstance().getCurrentSession().createSQLQuery(sql);
		def afadd = qy.addEntity(tableInDBName.toString());
		
		def list1 =change(td.table);
		def listend = change2(list1);
		List resultList=[];
		makeOrder(list1,resultList);
		println resultList;
	//	println list1.toString();
		List<Table> resultFromDB = afadd.list();
		def trlist=[];
		Map tbInfoInExpando;
		for(Table tbValue: resultFromDB)
		{
			tbInfoInExpando = tbValue.getProperties();
			def mm=[:];
			mm.put("id", tbInfoInExpando.get("id"));
			mm.put("name", tbInfoInExpando.get("name"));
			mm.putAll(tbInfoInExpando.get("customProperties"));
			trlist.add(mm);
		}
		println trlist;
		def reList=[];
		if(trlist.size()>0)
		{
			for(i in 0..trlist.size()-1)
			{
				def List=[];
				def li = trlist.pop();
				resultList.each{
					def de =it ;
					List.add(li.getAt("${de}"));
				}
				println List;
				reList.add(List);
			}
			
		}
		
		
		println reList;
		
		
		
		render(contentType: "application/json",encoding: "gbk",model: HashMap) {
		//	title = formName;
			columModle = listend;
		//	data = trlist;
		//	type = typeList;
		}
	}
	
	
	List makeOrder(li,resultList)
	{
		
		li.each{
			Map map=it;
			if(!map.containsKey("child"))
			{
				resultList << map.getAt("id");
			}
			else 
			{
				makeOrder(it.getAt("child"),resultList)
			}
		}
		
	}
	
	List change(table)
	{
		def tmap = table.getProperties();
		def list = [];
		int i;
		for(i=0;i<10;i++)
		{
			tmap.each {
				if(it.value.class.name=="groovy.util.Expando")
				{
					Expando aa = it.value;
					
			   
				   if(aa.num==i)
				   {
					   def name;
					   def map = [:];
					   if(it.value.class.name=="groovy.util.Expando")
					   {
					   
						   map.putAt("id", it.key)
					   }
					   println("|"+it.key+"->"+it.value+"|");
					   println it.value.class.name;
					   if(it.value.class.name=="groovy.util.Expando")
					   {
						   Expando child = it.value;
						   for(Entry e:child.getProperties().entrySet()){
							   println("|"+e.key+"->"+e.value+"|");
							   println(e.value);
							   if (e.value == "")
								name = e.key;
										
						   }
						   println name;
						   map.putAt("name", name)
						   if(it.value.getProperties().entrySet().size()!=2)
						   {
							   def li = [];
							   map.putAt("child", change(child))
						   }
					   }
					   if(it.value.class.name=="groovy.util.Expando")
					   {
						   list.add(map);
					   }
					   println list;
				   }
				}
				
				
			}
		}
		
		return list
	}

	List change2( llist)
	{
		def ll=[];
		def size=llist.size()
		for(int i=0;i<size;i++)
		{
			def map=[:];
			def aa=llist.get(i);
			if (!aa.containsKey("child"))
				map.putAt("${llist.get(i).getAt("id")}", llist.get(i).getAt("name"));
			else
				map.putAt("${llist.get(i).getAt("name")}",change2(llist.get(i).getAt("child")) );
			ll.add(map);
		}
		return ll
	}
	
}
