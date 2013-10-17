package test

import java.util.List;

import grails.converters.JSON

import org.hibernate.*;

import cn.gov.xaczj.HibernateUtil;
import cn.gov.xaczj.TableDynamic
import java.io.Serializable;
import java.util.LinkedHashMap.Entry
import org.springframework.dao.DataIntegrityViolationException
import grails.converters.*
import java.util.Map.Entry
import groovy.json.*
import cn.gov.xaczj.*;
class BrowseController {
	def dynamic;
	def tableList;
    def index() { }
	
	def conJson(def forms){
		def taList = [];
		if(forms.size>0)
		{
			for(i in 0..forms.size()-1)
			{
				def tamap=[:];
				tamap.putAt("id", forms.get(i).form.id);
				tamap.putAt("tableName", forms.get(i).form.name);
				taList.add(tamap);
			}
		}
		return taList;
	}
	
	def findtable(){
		Post loginPost = session.acountPost;
	
		if(loginPost.unit ==~"(a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z)*qczj")
		{
			def taList = [];
		//	def unit = loginPost.unit
			def pp = Post.findByParentPost(loginPost.no);
			def forms = Registration.findAllByRole(pp.role);
			taList = conJson(forms);
			render taList as JSON;
		}
		else if(loginPost.unit == "xasczj")	
		{
			
			def qxForms = Registration.findAllByRole(Role.get(4));//区县
			def qxList = conJson(qxForms);
			def kfqForms = Registration.findAllByRole(Role.get(4));//开发区
			def kfqList = conJson(kfqForms);
			def sbjForms = Registration.findAllByRole(Role.get(2));//市本级
			def sbjList = conJson(sbjForms);
			def jsdwForms = Registration.findAllByRole(Role.get(5));//建设单位
			def jsdwList = conJson(jsdwForms);
			def xasczjForms=Registration.findAllByRole(Role.get(3));//西安市财政局
			def xasczjList=conJson(xasczjForms);
			render(contentType: "application/json",encoding: "gbk") {
				qx = qxList;
				kfq = kfqList;	
				sbj = sbjList;
				jsdw = jsdwList;
				xasczj=xasczjList;
			}
		}			
	}
	
	def findYearCycle()

	{		
		try 
		{	
			String formId=params.formId;
		//	String formId="1";
			String chargePost = session.acountPost.no;
		
			String hql ="select planTime from table"+"${formId} "+" where receivePost ="+"${chargePost}"
			def yearlist=[];
			def years = HibernateUtil.getInstance().getCurrentSession().createQuery(hql).list();
			
			years.each {
				if(it!=null)
				{
					if(yearlist.contains(it.format('yyyy'))==false)
					{ 
						yearlist << it.format('yyyy')
					}	
				}
				
			}		
			def tableList = dynamic.getTableList();
			
			TableDynamic td = tableList.get(Integer.parseInt(formId));
			def cycle=td.cycle;
			render(contentType: "application/json",encoding: "gbk") {
				cc = cycle;
				year = yearlist;
				
			}

		} catch (Exception e) {
			println e;
		
		} finally {
	
		}
	}
	def watchtable()
	{
		def table_id=Integer.parseInt(params.gridId)
		def table_year=Integer.parseInt(params.year)
		def id=table_id-1

		def typeList = tableList.get((int)id);
		def tableDyList = dynamic.getTableList();
		Post loginPost = session.acountPost;
		String chargePost = session.acountPost.no;
		TableDynamic td = tableDyList.get((int)id);
		def map=td.entityName;
		Expando table = td.table;
		def tmap = table.getProperties();
		def list1 =change(table);
		def listend = change2(list1);
		//println list1.toString();
		java.sql.Date startime=java.sql.Date.valueOf("${(table_year)}-1-1")
		java.sql.Date endtime=java.sql.Date.valueOf("${(table_year+1)}-1-1")

		String hql ="select ff from table${table_id} ff"+" where receivePost ="+"${chargePost} and planTime<:endtime and planTime>=:startime"
		Query query= HibernateUtil.getInstance().getCurrentSession().createQuery(hql)
		query.setTimestamp("startime",startime)
		query.setTimestamp("endtime",endtime)
		List list=query.list();
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
	//	HibernateUtil.getInstance().reset();
		println trlist;
		render(contentType: "application/json",encoding: "gbk",model: map) {
			title = map;
			columModle = listend;
			data = trlist;
			type = typeList;
		}
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

}
