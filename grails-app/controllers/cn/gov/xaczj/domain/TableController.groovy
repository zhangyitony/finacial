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

	public acceptData(){
		println("in acceptData");
		int formNum=Integer.parseInt(params.formId);//table 's no���ı��
		int postId = session.acountPost.no;
		int parentPostId = session.acountPost.parentPost;//���ز����ֵ����Ա���ϼ���ͬ�����Ա
		def rawTextData=params.data_rows;//json data from browser,now is text,need decode
		def slurper = new JsonSlurper();//json decoder
		ArrayList<HashMap<String,String>> jsonData = slurper.parseText(rawTextData);//json data from browser,now is in right format.
		println(jsonData);
		int recordId;
		int planTimeNo;//��Ҫ����еļ�¼��
		Table tableInDB;
		Transaction tx =null;
		
		PlanTime ptTmp;//ģ��һ���ƻ����¼�������ݽ����Ա
		try{
			for(Map tmp:jsonData){
				tx = HibernateUtil.getInstance().getCurrentSession().beginTransaction();
				recordId = tmp.get("id");
				println(recordId);
				tableInDB = (Table)HibernateUtil.getInstance().getCurrentSession().load("table"+"${formNum}", recordId);
				if(postId == parentPostId){
					//�ϼ���λ���Լ���˵���Ѿ�������߼���
					//��inChargePost��ΪpostId.�ټ���receivePost�Ѿ����Լ��ˡ�
					//��ˣ���ʾһ�������������ı�׼�ǣ�
					//inChargePost��receivePost�������ϵͳ����߼�������Ա��post no.
					//��ǰ��2����ʾ���������в����ֵ����Ա
					tableInDB.inChargePost = postId;
				}else{
				
				tableInDB.inChargePost = parentPostId;
				tableInDB.receivePost = parentPostId;
				ptTmp = new PlanTime();
				ptTmp.tableId =formNum ;
				ptTmp.planTime = tableInDB.planTime;
				ptTmp.postId = parentPostId;
				ptTmp.save();
				}
				
				HibernateUtil.getInstance().getCurrentSession().flush();
				tx.commit();
			}
			def tmp = [success:true];
			render tmp as JSON;
		} catch (Exception e) {
			  System.out.println(e.getStackTrace());
			  def tmp = [success:false];
			  render tmp as JSON;
			  }

	}
	
	public denyData(){
		println("in denyData");
		int formNum=Integer.parseInt(params.formId);//table 's no���ı��
		int postId = session.acountPost.no;
		def rawTextData=params.data_rows;//json data from browser,now is text,need decode
		def slurper = new JsonSlurper();//json decoder
		ArrayList<HashMap<String,String>> jsonData = slurper.parseText(rawTextData);//json data from browser,now is in right format.
		println(jsonData);
		int recordId;
		Table tableInDB;
		Transaction tx =null;
		try{
			for(Map tmp:jsonData){
				tx = HibernateUtil.getInstance().getCurrentSession().beginTransaction();
				recordId = tmp.get("id");
				println(recordId);
				tableInDB = (Table)HibernateUtil.getInstance().getCurrentSession().load("table"+"${formNum}", recordId);
				tableInDB.receivePost = tableInDB.inChargePost;//
				HibernateUtil.getInstance().getCurrentSession().flush();
				tx.commit();
			}
			def tmp = [success:true];
			render tmp as JSON;
		} catch (Exception e) {
			  System.out.println(e.getStackTrace());
			  def tmp = [success:false];
			  render tmp as JSON;
			  }

	}
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
		int formNum=Integer.parseInt(params.formId);//table 's no���ı��
		int postId = session.acountPost.no;
		def delNums = params.del_rows;
		def commit = params.commit;
		int  planTimeNo = Integer.parseInt(params.planTimeNo);
		if (delNums!=null&& (!delNums.equals("ss")))
		{//record need to delete.
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
			  def jsonData = slurper.parseText(text);
			  Table table = null;
			  if(jsonData.size()> 0){
				  
			  
			  for(i in 0..jsonData.size()-1)
			  {//����ÿһ�����¼
				  tx = HibernateUtil.getInstance().getCurrentSession().beginTransaction();
				  table = new Table();
				 
				  
		//		   result.get(i).each
		//		  {//����һ����¼�е�ÿ������
					  if (jsonData.get(i).containsKey("id")==true)
					  {//��������
						  table = (Table)HibernateUtil.getInstance().getCurrentSession().load("table"+"${formNum}", jsonData.get(i).getAt("id"));
						  jsonData.get(i).each
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
						  
						  jsonData.get(i).each
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
						  def time = PlanTime.get(planTimeNo).planTime;
						  table.setPlanTime(time);
						  table.setPlanTimeNo(planTimeNo);
						  table.setInitFillTime(new Date());
//						  table.setStatus((short)1); //0��δ�� 1������
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
			  if(commit.equals("true")){
				  if(PlanTime.get(planTimeNo)){
					  PlanTime.get(planTimeNo).delete();
				  }
			  }
			  
			 
			  	
			  }
			  	  def tmp = [success:true];
				  render tmp as JSON;
			  } catch (Exception e) {
					 
					  System.out.println("e = " + e);
					  def tmp = [success:false];
					  render tmp as JSON;
			  }
			  
			
	}
	

	/**
	 * ��ȡ����еĲݱ���˱��������Ϣ
	 * ������������ƣ�����������ѡ���ѯ����
	 * 0���鿴��ǰ�û���ı���Ϊid�Ĳݱ��¼
	 * 1���鿴��Ҫ��ǰ�û���Ҫ��˵ı���Ϊid�����м�¼
	 * @param id ���ı��
	 * @return ���ϲ�ѯ���������м�¼����json���أ���ʽ����ͨ����Э�飨Э��δ�ĵ�����
	 */
	def select(Long id)
	{
		
		
		int myPostNo = session.acountPost.no;
		int inChargePostNo;
		int receivePostNo;
//		String audit = params.audit;
		String command = params.command;//�洢������
		int commandNo = Integer.parseInt(params.commandNo);//�������ַ�
//		boolean isAudit = audit?.equals("true")?true:false;//�Ƿ��ǲ�����Ҫ��˵ı��¼
		
		int index = id-1;
		def typeList = tableList.get(index);
		
		def tableDyList = dynamic.getTableList();
		TableDynamic td = tableDyList.get(index);
		Map formName=td.entityName;//��ű���entityname����ʵ��������
		
		int tableId = id;//���
		String tableInDBName = formName.get("tableName");//�������ݿ��е�����
		String tableRealName = formName.get("chTableName");//�����ʵ���֣���������
		String sql;
		switch(commandNo){
			case 0:
			//ѡ����Ҫչʾ�ݱ������
			sql = "select * from tbl_$tableInDBName as record where record.receivePost = "+myPostNo+" and record.inchargePost = "+myPostNo;
			break;
			case 1:
			sql = "select * from tbl_$tableInDBName as record where record.receivePost = "+myPostNo+" and record.inchargePost != "+myPostNo;
			break;
			
		}
		
		Query qy = HibernateUtil.getInstance().getCurrentSession().createSQLQuery(sql);
		def afadd = qy.addEntity(tableInDBName.toString());
		
		def list1 =change(td.table);
		def listend = change2(list1);
		println list1.toString();
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
		render(contentType: "application/json",encoding: "gbk",model: HashMap) {
			title = formName;
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