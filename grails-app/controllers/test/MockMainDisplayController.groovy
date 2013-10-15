package test

import grails.converters.JSON
import java.util.Date
import org.springframework.dao.DataIntegrityViolationException
import cn.gov.xaczj.*;

class MockMainDisplayController {
	
	def beforeInterceptor = [action:this.&auth];
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", getPost:"POST"]
	
	def dynamic;
	
	def showMain(){
		
	}
	
	def choosePost(){
		def posts = Post.findAllByAcount(Acount.get(session.acount.id));
		println(posts);
		[postList: posts]
		
	}
	
	def setAcountPost(){
		println("in setAcountPost");
		println("params"+params);
		session.acountPost = Post.findByPostName(params.select);
		println(session.acountPost);
		redirect(action:"showMain");
	}
	

	
	/**
	 * get should-filled form info,return as json format.
	 * @return json data
	 */
	def getShouldFillTables(){
		Post loginPost = session.acountPost;
		def results = PlanTime.findAll("\
		from PlanTime as p, \
		     Form as f \
		where p.tableId = f.no and p.postId = ?", [(int)loginPost.id])

		def tableList = dynamic.getTableList()		
		def tablelist=[];
		HashMap map = null;//store a table's data
		def ss;
		TableDynamic td;
		int cycle;//should fill time cycle
		int month;
		int num;
		String timeStr = "";//formated time string.
		if(results.size()>0)
		{
			for(i in 0..results.size()-1)
			{
				 map=[:];
				 ss = results.get(i);
				 td = tableList.get(ss[0].tableId-1);
				 cycle = Integer.parseInt(td.cycle);
				 month = Integer.parseInt(ss[0].planTime.format('MM'));
				 timeStr = "";
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
							 timeStr = ss[0].planTime.format('yyyy年')+"${timeStr}"
					 break;
					 case 3:
					 		switch(num){
					 		 case 0:timeStr = "第一季度";break;
							 case 1:timeStr = "第二季度";break;
							 case 2:timeStr = "第三季度";break;
							 case 3:timeStr = "第四季度";break;
							 }
						 timeStr = ss[0].planTime.format('yyyy年')+"${timeStr}"
					 break;
					 case 1:
					 		timeStr = ss[0].planTime.format('yyyy年/MMM')
					 break;
					 case 0:
					 		timeStr = "";	
					 break;
				 }
				map.putAt("id",ss[0].id)
				map.putAt("tableId",ss[0].tableId)
				map.putAt("name",ss[1].name)
				map.putAt("time",timeStr)
				
				tablelist.add(map);
			}
		}
		
		
//		println tablelist;
		render tablelist as JSON;
	}
	
	
	
	private auth(){
		println("in the auth");
		if( !session.acount ||session.acount?.acountName.equals("admin")){
			println("auth failed or session is timeout");
			redirect(url:'/index.gsp')
			return false
		}
//		else if(session.acount?.acountName.equals("admin")){
//			println("admin should not get into commit system");
//			redirect(url:'/index.gsp')
//			return false
//		}
		
		println("auth passed");
	}
	
	
	
}
