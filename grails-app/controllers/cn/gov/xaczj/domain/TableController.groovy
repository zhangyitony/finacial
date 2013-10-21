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
		int formNum=Integer.parseInt(params.formId);//table 's no表格的编号
		int postId = session.acountPost.no;
		int parentPostId = session.acountPost.parentPost;//区县财政局的审核员的上级是同级的填报员
		def rawTextData=params.data_rows;//json data from browser,now is text,need decode
		def slurper = new JsonSlurper();//json decoder
		ArrayList<HashMap<String,String>> jsonData = slurper.parseText(rawTextData);//json data from browser,now is in right format.
		println(jsonData);
		int recordId;
		int planTimeNo;//需要填报表中的记录号
		Table tableInDB;
		Transaction tx =null;
		
		PlanTime ptTmp;//模拟一个计划填报记录来将数据交给填报员
		try{
			for(Map tmp:jsonData){
				tx = HibernateUtil.getInstance().getCurrentSession().beginTransaction();
				recordId = tmp.get("id");
				println(recordId);
				tableInDB = (Table)HibernateUtil.getInstance().getCurrentSession().load("table"+"${formNum}", recordId);
				if(postId == parentPostId){
					//上级岗位是自己，说明已经到达最高级，
					//将inChargePost设为postId.再加上receivePost已经是自己了。
					//因此，表示一个数据最终入库的标准是：
					//inChargePost与receivePost都是审核系统里最高级别的审核员的post no.
					//当前是2，表示的是西安市财政局的审核员
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
		int formNum=Integer.parseInt(params.formId);//table 's no表格的编号
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
			System.out.println("delete count : " + count); //删除条数
			
		}
		

	}
	/**
	 *
	 * @return
	 */
	def save() {
		int formNum=Integer.parseInt(params.formId);//table 's no表格的编号
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
						println "deleteid："+delNums[i];
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
			  {//遍历每一条表记录
				  tx = HibernateUtil.getInstance().getCurrentSession().beginTransaction();
				  table = new Table();
				 
				  
		//		   result.get(i).each
		//		  {//遍历一条记录中的每项数据
					  if (jsonData.get(i).containsKey("id")==true)
					  {//更新数据
						  table = (Table)HibernateUtil.getInstance().getCurrentSession().load("table"+"${formNum}", jsonData.get(i).getAt("id"));
						  jsonData.get(i).each
				          {//遍历一条记录中的每项数据
							  if(it.key!="id")
							  {//记录中的id号不需要更新
								  
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
							  //提交表格时更改该条数据的接受者为该条记录的当前负责人的上级的帐号id
							  table.receivePost = Post.findByNo(table.inChargePost).parentPost;
							  
							 
							  
						  }
						  HibernateUtil.getInstance().getCurrentSession().flush();//*/
					  }
					  else
					  {//插入新的数据记录
						  //convert(table)
						  
						  jsonData.get(i).each
						  {//遍历一条记录中的每项数据
							   if(it.key!="id")
							  {//记录中应该无key为id的数据，此处判断多余，需要张验证，如果多余请去除。
								  
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
						
						  table.setInChargePost(postId); //当前负责人
						  table.setInitFillPost(postId); //初始填表人
						  def time = PlanTime.get(planTimeNo).planTime;
						  table.setPlanTime(time);
						  table.setPlanTimeNo(planTimeNo);
						  table.setInitFillTime(new Date());
//						  table.setStatus((short)1); //0是未提 1是已提
						  if(commit.equals("true")){
							  table.setReceivePost(session.acountPost.parentPost);//上报表格，存入当前登录帐号的上级单位的的帐号
							
						  }else{
							  table.setReceivePost(postId);//存草表时，存入自己的帐号
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
	 * 获取表格中的草表，审核表的数据信息
	 * 增添命令码机制，根据命令码选择查询条件
	 * 0，查看当前用户填报的表编号为id的草表记录
	 * 1，查看需要当前用户需要审核的表编号为id的所有记录
	 * @param id 表格的编号
	 * @return 符合查询条件的所有记录，以json返回，格式参照通信你协议（协议未文档化）
	 */
	def select(Long id)
	{
		
		
		int myPostNo = session.acountPost.no;
		int inChargePostNo;
		int receivePostNo;
//		String audit = params.audit;
		String command = params.command;//存储命令码
		int commandNo = Integer.parseInt(params.commandNo);//命令码字符
//		boolean isAudit = audit?.equals("true")?true:false;//是否是查找需要审核的表记录
		
		int index = id-1;
		def typeList = tableList.get(index);
		
		def tableDyList = dynamic.getTableList();
		TableDynamic td = tableDyList.get(index);
		Map formName=td.entityName;//存放表格的entityname与真实中文名称
		
		int tableId = id;//表号
		String tableInDBName = formName.get("tableName");//表在数据库中的名字
		String tableRealName = formName.get("chTableName");//表的真实名字，中文名称
		String sql;
		switch(commandNo){
			case 0:
			//选择需要展示草表的数据
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