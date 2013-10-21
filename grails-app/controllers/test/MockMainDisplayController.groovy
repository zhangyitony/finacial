package test

import grails.converters.JSON

import java.util.ArrayList;
import java.util.Date
import java.util.HashMap;

import org.hibernate.Query
import org.hibernate.transform.AliasToBeanResultTransformer
import org.springframework.dao.DataIntegrityViolationException
import cn.gov.xaczj.domain.Table;
import cn.gov.xaczj.*;

class MockMainDisplayController {
	
	def beforeInterceptor = [action:this.&auth];
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", getPost:"POST"]
	
	def dynamic;
	def tableList;//spring ioc bean,存放表的列数据类型。自身类型ArrayList <HashMap <String,String>>
	def showMain(){//this action cannot be deleted!dont be stupid!
		
	}
	/**
	 * 选出该帐号的所有角色
	 * @return 所有的角色list
	 */
	def choosePost(){
		def posts = Post.findAllByAcount(Acount.get(session.acount.id));
		println(posts);
		[postList: posts]
		
	}
	
	/**
	 * 根据用户选的角色，将角色存入session中
	 * @return
	 */
	def setAcountPost(){
		println("in setAcountPost");
		println("params"+params);
		session.acountPost = Post.findByPostName(params.select);
		println(session.acountPost.roleId);
		println(session.acountPost);
		redirect(action:"showMain");
	}
	

	
	/**
	 * get should-filled form info,return as json format.
	 * @return json data
	 */
	def getShouldFillTables(){
		Post loginPost = session.acountPost;
		
		//符合结果的集合
		def resultsFromDB = PlanTime.findAll("\
		from PlanTime as p, \
		     Form as f \
		where p.tableId = f.no and p.postId = ?", [(int)loginPost.no])

		def tableListExpando = dynamic.getTableList()		
		def ResultList=[];//存放结果集合，原来的名字容易混淆。
		HashMap map = null;//store a table's data
		def oneResult;
		TableDynamic td;
		int cycle;//should fill time cycle
		int month;
		int num;
		String timeStr = "";//formated time string.
		if(resultsFromDB.size()>0)
		{
			for(i in 0..resultsFromDB.size()-1)
			{
				 map=[:];
				 oneResult = resultsFromDB.get(i);
				 td = tableListExpando.get(oneResult[0].tableId-1);
				 cycle = Integer.parseInt(td.cycle);				
				 timeStr = dateToDisplayString(oneResult[0].planTime,cycle);				 
				map.putAt("id",oneResult[0].id)
				map.putAt("tableId",oneResult[0].tableId)
				map.putAt("name",oneResult[1].name)
				map.putAt("time",timeStr)			
				ResultList.add(map);
			}
		}
		
		///////
		def zeroList = Authority.findAllByPostAndAuthority(loginPost,(short)1).form.id;
//		def zeroList = Authority.findAll("	from Authority as a where a.Post = ? ", [loginPost])
		if(zeroList.size()>0)
		{
			for(i in 0..zeroList.size()-1)
			{
				td = tableListExpando.get((int)zeroList.getAt(i)-1);
				println zeroList.getAt(i);
				cycle = Integer.parseInt(td.cycle);
				if(cycle==0)
				{
					map.clear();
					timeStr = dateToDisplayString(new Date(),cycle);
					
				   map.putAt("id",-1)
				   map.putAt("tableId",(int)zeroList.getAt(i))
				   map.putAt("name",td.entityName.chTableName)
				   println td.entityName.chTableName;
				   map.putAt("time",timeStr)
				   
				   ResultList.add(map);
				}
			}
		}
		
		//////
		
//		println tablelist;
		render ResultList as JSON;
	}
	
	/**
	 * get should-audited form info,return as json format.
	 * 判断是否需要自己审核的规则：当前负责人不是自己，并且接受者是自己。
	 * @return json-formated data
	 */
	def getShouldAuditTables(){
		
		int myPostNo = session.acountPost.no;
		
		LinkedList<HashMap> ResultList=[];//存放返回结果集合
		LinkedList<Table> dataFromTable =[];//临时存放需要审核的全部表
		HashMap map = null;//store a table's data
		
		Post loginPost = session.acountPost;
		ArrayList<TableDynamic> allTableList = dynamic.getTableList();
		int tableId;//表号
		String tableInDBName;//表在数据库中的名字
		String tableRealName;//表的真实名字，中文名称
		
		HashMap tmp ;//临时储存一条发给前台的数据
		String timeStr;//temporary variable store date string
		Set<String> dateSet = new HashSet<>();//store date string of should audit record in each table.every fill cycle only need to give one record to represent the whole cycle 
		for(TableDynamic aTable:allTableList){
			
			 tableInDBName = aTable.entityName.get("tableName");
			tableId = Integer.parseInt(tableInDBName.split("table")[1]);
			tableRealName = aTable.entityName.get("chTableName");
//			println("tableId:"+tableId+" tableDbName:"+tableInDBName+" table real name:"+tableRealName);
			
			Query qy = HibernateUtil.getInstance().getCurrentSession().createSQLQuery("select * from tbl_$tableInDBName as record \
							where record.receivePost = "+myPostNo+" and record.inchargePost != "+myPostNo);
			def afadd = qy.addEntity(tableInDBName.toString());

			dateSet.clear();
			for(Table tb:afadd.list())
			{
				timeStr = dateToDisplayString(tb.initFillTime,Integer.parseInt(aTable.cycle));
				if(!dateSet.add(timeStr)){
					continue;
				}
				tmp = new HashMap<String,String>();
				tmp.put("tableId", tableId);//表号
				tmp.put("name",tableRealName);//表的真实中文名
				tmp.put("time",timeStr);//初始填报时间根据表格的填报周期转换成季度或半年信息
				tmp.put("id", tb.id);//该条记录在原始数据库中的编号，以便后续操作
				ResultList.add(tmp);
			}
		}
		
		render ResultList as JSON;
		
	}	
	
	
	/**
	 * 前台在显示时间信息时，需要根据表格填报规则显示季度信息或上半年下半年，此函数用于生成前台所需的显示字符
	 * @param date 需要转换的时间，类型为Date
	 * @param cycle 填报周期，int
	 * @return String
	 */
		private String dateToDisplayString(Date date,int cycle){
			String timeStr = "";//返回给前台显示的时间字符串
			int month = Integer.parseInt(date.format('MM'));
			int num;
			if (cycle!=0)
			{
				num = month/cycle;
			}
			switch(cycle){
				case 6:
						if(num==0)
							timeStr = "上半年";
						else if(num==1)
							timeStr = "下半年"
						timeStr = date.format('yyyy年')+"${timeStr}"
				break;
				case 3:
						switch(num){
						 case 0:timeStr = "第一季度";break;
						case 1:timeStr = "第二季度";break;
						case 2:timeStr = "第三季度";break;
						case 3:timeStr = "第四季度";break;
						}
					timeStr = date.format('yyyy年')+"${timeStr}"
				break;
				case 1:
						timeStr = date.format('yyyy年/MMM')
				break;
				case 0:
						timeStr = "";
				break;
			}
			
			return timeStr;
		}

	private auth(){
		println("in the auth");
		if( !session.acount ||session.acount?.acountName.equals("admin")){
			println("auth failed or session is timeout");
			redirect(url:'/index.gsp')
			return false
		}

		
		println("auth passed");
	}
	
	
	
}
