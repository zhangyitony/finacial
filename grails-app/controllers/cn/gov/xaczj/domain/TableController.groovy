package cn.gov.xaczj.domain

import java.io.Serializable;
import java.util.List;
import java.util.LinkedHashMap.Entry
import org.springframework.dao.DataIntegrityViolationException
import cn.gov.xaczj.TableDynamic
import grails.converters.*
import java.util.Map.Entry
import groovy.json.*


import org.hibernate.*;

import cn.gov.xaczj.*;
import cn.gov.xaczj.domain.Table;
import test.*;
class TableController {
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	def dynamic;
	def tableList;
	
	def searchtype(String name)
	{
//			
		def table=tableList.get(0);
		if (table.get(name)=="big_decimal")
			return "java.math.BigDecimal";
		else if (name=="id")
			return "java.lang.integer"
		else		
			return "java.lang."+table.get(name);
	}
	
	def deleteall()
	{

		Session session = HibernateUtil.getInstance().getCurrentSession();			
		Transaction tx = null;		
		try {		
		tx = session.beginTransaction();
			
		String hql = "delete table1 where id != 99"		
		Query query = session.createQuery(hql);;		
		int count  = query.executeUpdate();		
		 tx.commit();		
		System.out.println("delete count : " + count); //ɾ������		
		} catch (Exception e) {	
		println e;	
		
		} finally {		
		System.out.println("delete count : " + count); //ɾ������
		}
		

	}
    def save() {	
		num=params.numId;
		def accountid = session.acount.id;
		deleteall();
		Session hSession = HibernateUtil.getInstance().getCurrentSession();	
		
		Transaction tx =null;
		
		try {
			  def text=params.a;			
			  def slurper = new JsonSlurper()		  			
			  def result = slurper.parseText(text);
			  for(i in 0..result.size()-1)
			  {			
				  tx = hSession.beginTransaction();
				  Table table = new Table();
				  
				  result.get(i).each
				  {
					  if(it.key!="id")
					  {
						  String aa = it.value;
						  if (aa!=null && aa!="" )
						  {
							  def tmp;
							  def ta=tableList.get(num-1);
							  def ina=ta.get(it.key);
							  if(ina=="big_decimal")
							  {
								 Class c = Class.forName("java.math.BigDecimal");
								 tmp = c.newInstance(it.value);
							  }
							  else if(ina=="string")
							  {															
								 tmp = it.value;
							  }
							  else if(ina=="integer")
							  {
								 
								 Class c = Class.forName("java.lang.Integer");
								 tmp = c.newInstance(it.value);
							  }
							  println tmp;
							  table.setValueOfCustomField(it.key,tmp);
						 }
					  }					  			
				 }
				 table.setInChargeAcount(accountid); //��ǰ������
				 table.setInitFillAcount(accountid); //��ʼ�����
				 table.setPlanTime(PlanTime.findAllByAcountId(accountid));
				 table.setInitFillTime(new Date().getTime());
				 table.setStatus(1); //0��δ�� 1������
				 Serializable id = hSession.save("table"+"${num}",table);
//				 if ( i % 20 == 0 ) { //20, same as the JDBC batch size
//					 //flush a batch of inserts and release memory:
//					 session.flush();
//					 session.clear();
//				 }
				 tx.commit();
				 def tmp = [success:true];
				render tmp as JSON;
			 }
			 	
			  } catch (Exception e) {
					 
					  System.out.println("e = " + e);
					  def tmp = [success:false];
					  render tmp as JSON;
			  }
	}
	

	
	def select(Long id)
	{
		def tableList = dynamic.getTableList()
		//render(view: "hello", model: [userInstance: user,roleInstance:role,registrationInstance:registration,authorityInstance:authority])
		id=id-1;
		TableDynamic td = tableList.get((int)id);
		def map=td.entityName;
		Expando table = td.table;
		def tmap = table.getProperties();
//		tmap.get("investgatePlan");
	
		def list1 =change(table);
		def listend = change2(list1);
		println list1.toString();
		
		Session session = HibernateUtil.getInstance().getCurrentSession();		
		Criteria criteria = session.createCriteria("table"+"${id+1}");
		// criteria.add(Restrictions.eq(CustomizableEntityManager.CUSTOM_COMPONENT_NAME + ".dy_summoney", 232323));
		criteria.setMaxResults(50);
		List list = criteria.list();
		def trlist=[];
		if(list.size != 0 )
		{
			for(i in 0..list.size()-1)
			{
				Map sendmap = list.get(i).getProperties();
				def mm=[:];
				sendmap.each {
					if(it.key.toString()=="id")
						mm.put("id", it.value);
					if(it.key.toString()=="name")
						mm.put("name", it.value);
					if(it.key.toString()=="customProperties")
					{
						it.value.each {
						mm.put("${it.key}",it.value);
						}
					}
				}
				trlist.add(mm);
			}
		}
								 
		println trlist;	
		render(contentType: "application/json",encoding: "gbk",model: map) {				
			title = map;
			columModle = listend;
			data = trlist;
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