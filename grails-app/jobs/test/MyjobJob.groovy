package test


//import java.text.SimpleDateFormat
import java.util.Calendar
import cn.gov.xaczj.*;

class MyjobJob {	
	
	def dynamic;
	
	static  n=0 ;
		static  numbers=[11,12,13,14];
	static  orignaL_time=[0,0,0,0];
	
	static start_month=0;
	static start_year=0
	static now_month=0
	static now_year=0
	//static 
    static triggers = {
	//	simple repeatInterval: 50000l // execute job once in 5 seconds
     //   cron name: 'myTrigger', cronExpression: "* * 22 * * ?"
	}

	//def timeout=10001;
	def group="Mygroup"
    def execute() {
        // execut//e job
		//
//		
		def tableList = dynamic.getTableList();
		def tablenum =tableList.size();
		
		
		def cal=Calendar.getInstance()
		//def now_month=cal.get(Calendar.MONTH)
		//def now_year=cal.get(Calendar.YEAR)	
		def count=1
		Date now_date=new Date();
		now_month++
		if (now_month==12)
		{
			now_month=1;
			now_year++;
		}
		while (count<=tablenum)
		{
			TableDynamic td = tableList.get(count-1);
			int cc = Integer.parseInt(td.cycle);
			
			if(cc != 0 && ((now_year-start_year)*12+(now_month-start_month))%cc==0)
			{																
				def whynot=Authority.createCriteria()
				def need_id_list=whynot.list {
					form{
						eq("no",count)
						}											
				}
				if(need_id_list.size()>0)
				{
					for(i in 0..need_id_list.size()-1)
					{
						println need_id_list[i]
						def plan_times=new PlanTime()
						plan_times.tableId=count
						plan_times.planTime=now_date
						plan_times.acountId=need_id_list.get(i).acountId
						plan_times.save()
					}
				}														
																																					
			}
		count++								
		}		
		println(" cry"+(n++)+" "+now_date.toLocaleString());		 
		return;
    }
}
