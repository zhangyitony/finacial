package cn.gov.xaczj.domain

import java.io.Serializable;
import java.util.List;
import java.util.LinkedHashMap.Entry
import org.springframework.dao.DataIntegrityViolationException
import grails.converters.*
import java.util.Map.Entry
import groovy.json.*
import org.hibernate.*;
import cn.gov.xaczj.*;
import test.*;

class TableController {
	def beforeInterceptor = [action:this.&auth];
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	def dynamic;
	def tableList;

	def delete(int i,String num)
	{

		HibernateUtil.getInstance().getCurrentSession();
		Transaction tx = null;
		int count;
		try {
		tx = HibernateUtil.getInstance().getCurrentSession().beginTransaction();
			
		String hql = "delete table"+"${i}"+" where id = ${num}"
		println hql;
		Query query = HibernateUtil.getInstance().getCurrentSession().createQuery(hql);;
		count  = query.executeUpdate();
		tx.commit();
	//	HibernateUtil.getInstance().reset();
		} catch (Exception e) {
			println e;
		
		} finally {
			System.out.println("delete count : " + count); //ɾ������
			
		}
		

	}
	/**
	 *
	 * @return
	 */
	def save() {
		int formNum=Integer.parseInt(params.numFuckId);
		// num=params.numfuckId;
		int postId = session.acountPost.no;
		def delNums = params.del_rows;
		def commit = params.commit;
		def planTimeId = params.planTime;
		if (delNums!=null)
		{
			println delNums.size();
				for(i in 0..delNums.size()-1)
				{
					if(delNums[i]!="ss" && delNums[i]!='s')
					{
						println "deleteid��"+delNums[i];
						delete(formNum,delNums[i]);
					}
				}
		}
		HibernateUtil.getInstance().getCurrentSession();
		Transaction tx =null;

		try {
			  def text=params.data_rows;
			  def slurper = new JsonSlurper()
			  def result = slurper.parseText(text);
			  Table table = null;
			  for(i in 0..result.size()-1)
			  {//����ÿһ�����¼
				  tx = HibernateUtil.getInstance().getCurrentSession().beginTransaction();
				  table = new Table();
				 
				  
		//		   result.get(i).each
		//		  {//����һ����¼�е�ÿ������
					  if (result.get(i).containsKey("id")==true)
					  {//��������
						  table = (Table)HibernateUtil.getInstance().getCurrentSession().load("table"+"${formNum}", result.get(i).getAt("id"));
						  result.get(i).each
				          {//����һ����¼�е�ÿ������
							  if(it.key!="id")
							  {//��¼�е�id�Ų���Ҫ����
								  
								  String dataValue = it.value;
								  if (dataValue!=null && dataValue!="" )
								  {
									  def tmp;
									  def ta=tableList.get(formNum-1);
									  def dataType=ta.get(it.key);
									  if(dataType=="big_decimal")
									  {
										 tmp = Class.forName("java.math.BigDecimal").newInstance(it.value);
									  }
									  else if(dataType=="string")
									  {
										 tmp = it.value;
									  }
									  else if(dataType=="integer")
									  {
										 tmp = Class.forName("java.lang.Integer").newInstance(it.value);
									  }
									  println tmp;
									  table.setValueOfCustomField(it.key,tmp);
								 }
							  }
				          }
						  if(commit.equals("true")){
							  //�ύ���ʱ���ĸ������ݵĽ�����Ϊ������¼�ĵ�ǰ�����˵��ϼ����ʺ�id
							  table.receivePost = Post.findByNo(table.inChargePost).parentPost;
						  }
						  HibernateUtil.getInstance().getCurrentSession().flush();//*/
					  }
					  else
					  {//�����µ����ݼ�¼
						  //convert(table)
						  
						  result.get(i).each
						  {//����һ����¼�е�ÿ������
							   if(it.key!="id")
							  {//��¼��Ӧ����keyΪid�����ݣ��˴��ж϶��࣬��Ҫ����֤�����������ȥ����
								  
								  String aa = it.value;
								  if (aa!=null && aa!="" )
								  {
									 
									  def tmp;
									  def ta=tableList.get(formNum-1);
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
						
						  table.setInChargePost(postId); //��ǰ������
						  table.setInitFillPost(postId); //��ʼ�����
						  def time = PlanTime.get(planTimeId).planTime;
						  table.setPlanTime(time);
						  table.setInitFillTime(new Date());
						  table.setStatus((short)1); //0��δ�� 1������
						  if(commit.equals("true")){
							  table.setReceivePost(session.acountPost.parentPost);//�ϱ���񣬴��뵱ǰ��¼�ʺŵ��ϼ���λ�ĵ��ʺ�
						  }else{
							  table.setReceivePost(postId);//��ݱ�ʱ�������Լ����ʺ�
						  }
								 
						  Serializable id = HibernateUtil.getInstance().getCurrentSession().save("table"+"${formNum}",table);
					  }
													
			
				 tx.commit();
			//	 HibernateUtil.getInstance().reset();
				
			     }	
			  	  def tmp = [success:true];
				  render tmp as JSON;
			  } catch (Exception e) {
					 
					  System.out.println("e = " + e);
					  def tmp = [success:false];
					  render tmp as JSON;
			  }
			  
			
	}
	

	
	def select(Long id)
	{
		id--;
		def typeList = tableList.get((int)id);
		def tableDyList = dynamic.getTableList();
		
		TableDynamic td = tableDyList.get((int)id);
		def map=td.entityName;
		Expando table = td.table;
		def tmap = table.getProperties();
		def list1 =change(table);
		def listend = change2(list1);
		println list1.toString();
		HibernateUtil.getInstance().getCurrentSession();
		Criteria criteria = HibernateUtil.getInstance().getCurrentSession().createCriteria("table"+"${id+1}");
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
	//	HibernateUtil.getInstance().reset();
		println trlist;
		render(contentType: "application/json",encoding: "gbk",model: map) {
			title = map;
			columModle = listend;
			data = trlist;
			type = typeList;
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
	private auth(){
		println("in the auth");
		if(!session.acount){
			redirect(url:'/index.gsp')
			return false
		}
	}
		
}