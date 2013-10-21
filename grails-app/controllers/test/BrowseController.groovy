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
			
			def qxForms = Registration.findAllByRole(Role.get(4));//����
			def qxList = conJson(qxForms);
			def kfqForms = Registration.findAllByRole(Role.get(4));//������
			def kfqList = conJson(kfqForms);
			def sbjForms = Registration.findAllByRole(Role.get(2));//�б���
			def sbjList = conJson(sbjForms);
			def jsdwForms = Registration.findAllByRole(Role.get(5));//���赥λ
			def jsdwList = conJson(jsdwForms);
			def xasczjForms=Registration.findAllByRole(Role.get(3));//�����в�����
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
			def APost=session.acountPost.parentPost;
			if(Post.findByNo(APost).parentPost==1)//�鿴��ǰ��¼���Ƿ������ز��������Ա ���� �����в��������Ա
			{
				String formId=params.formId;
				String inChargePost = session.acountPost.parentPost;
				String receivePost = session.acountPost.parentPost;
//				inChargePost = session.acountPost.parentPost;
//				receivePost =  session.acountPost.parentPost;
				String hql ="select planTime from table${formId}  where receivePost = ${receivePost} and inChargePost = ${inChargePost}" //�鿴���ؼ����Ա�ϴ��ļ�¼�������ܣ�
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
				
				receivePost =  Post.findByNo(receivePost).parentPost;//�鿴���ؼ����Ա�ϴ��ļ�¼�����ϱ��ϼ���
				hql ="select planTime from table"+"${formId} "+" where receivePost ="+"${receivePost}"+" and inChargePost ="+"${inChargePost}"
				years = HibernateUtil.getInstance().getCurrentSession().createQuery(hql).list();
				years.each {
					if(it!=null)
					{
						if(yearlist.contains(it.format('yyyy'))==false)
						{
							yearlist << it.format('yyyy')
						}
					}
				}
				
				inChargePost = Post.findByNo(inChargePost).parentPost; //�鿴�����в��������Ա�ϴ��ļ�¼�������ܣ�		
				hql ="select planTime from table"+"${formId} "+" where receivePost ="+"${receivePost}"+" and inChargePost ="+"${inChargePost}"	
				years = HibernateUtil.getInstance().getCurrentSession().createQuery(hql).list();
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
				TableDynamic td = tableList.get(Integer.parseInt(formId)-1);
				def cycle=td.cycle;
				render(contentType: "application/json",encoding: "gbk") {
					cc = cycle;
					year = yearlist;
					
				}
			}
			
		} catch (Exception e) {
			println(e.getStackTrace()) ;
		
		} finally {
			
		}
	}
	
	
	def watchtable()
	{
		def table_id=Integer.parseInt(params.gridId)
		def table_year=Integer.parseInt(params.year)
		def table_time=Integer.parseInt(params.cycle)
		def id=table_id-1

		def typeList = tableList.get((int)id);
		def tableDyList = dynamic.getTableList();
		Post loginPost = session.acountPost;
	
		TableDynamic td = tableDyList.get((int)id);
		def map=td.entityName;
		int cycle=Integer.parseInt(td.cycle);
		Expando table = td.table;
		def tmap = table.getProperties();
		def list1 =change(table);
		def listend = change2(list1);
		java.sql.Date startime;
		java.sql.Date endtime;
		switch(cycle){
			case 6:
					if(table_time==0)
					{
						startime=java.sql.Date.valueOf("${(table_year)}-1-1")
						endtime=java.sql.Date.valueOf("${(table_year)}-6-1")
					}				
					else if(table_time==1)
					{
						startime=java.sql.Date.valueOf("${(table_year)}-6-1")
						endtime=java.sql.Date.valueOf("${(table_year+1)}-1-1")
					}	
				
					break;
			case 3:
					switch(table_time)
					{
						case 0:					
							startime=java.sql.Date.valueOf("${(table_year)}-1-1");
							endtime=java.sql.Date.valueOf("${(table_year)}-4-1");
							break;					
						case 1:
							startime=java.sql.Date.valueOf("${(table_year)}-4-1");
							endtime=java.sql.Date.valueOf("${(table_year)}-7-1");
							break;	
						case 2:
							startime=java.sql.Date.valueOf("${(table_year)}-7-1");
							endtime=java.sql.Date.valueOf("${(table_year)}-10-1");
							break;
						case 3:
							startime=java.sql.Date.valueOf("${(table_year)}-10-1");
							endtime=java.sql.Date.valueOf("${(table_year+1)}-1-1");
							break;
					}
					break;
			case 1:
					startime=java.sql.Date.valueOf("${(table_year)}-1-1")
					endtime=java.sql.Date.valueOf("${(table_year+1)}-1-1")
					break;
			case 0:					
					break;
		}
	
		List list;
		if(loginPost.unit ==~"(a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z)*qczj")
		{
			String chargePost = session.acountPost.no;
			String hql ="from table${table_id} "+" where receivePost ="+"${chargePost} and planTime<:endtime and planTime>=:startime"
			Query query= HibernateUtil.getInstance().getCurrentSession().createQuery(hql)
			query.setTimestamp("startime",startime)
			query.setTimestamp("endtime",endtime)
			list=query.list();
			String sql ="select * from tbl_table${table_id} as tt ,Post as po where tt.initFillPost=po.no and po.parent_post=${chargePost} and tt.receivePost = 2 and planTime<${endtime} and planTime>=${startime}"
			println sql;
			query= HibernateUtil.getInstance().getCurrentSession().createSQLQuery(sql)
		//	query.setTimestamp("startime",startime)
		//	query.setTimestamp("endtime",endtime)
			
			List list2 = query.list();
			while(!list2.isEmpty())
			{
				list << list2.pop();
			}
		}
		else if(loginPost.unit == "xasczj")
		{
			String chargePost = session.acountPost.no;
			String hql ="select ff from table${table_id} ff"+" where receivePost ="+"${chargePost} and planTime<:endtime and planTime>=:startime"
			Query query= HibernateUtil.getInstance().getCurrentSession().createQuery(hql)
			query.setTimestamp("startime",startime)
			query.setTimestamp("endtime",endtime)
			list=query.list();
		}
		
		
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
