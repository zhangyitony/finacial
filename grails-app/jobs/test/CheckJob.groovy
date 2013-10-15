package test
import cn.gov.xaczj.*;


class CheckJob {
    static triggers = {

//		simple repeatInterval: 5000l // execute job once in 5 seconds
		/*用于模拟*/
		cron name: 'myTrigger', cronExpression: "0 0 0 15 * ?"
		    }
	def dynamic;
	
	static  n=0 ;
	static start_month=0;
	static start_year=0
	static now_month=0
	static now_year=0
    def execute() {
        // execute job
		def tableList = dynamic.getTableList();
		def tablenum =tableList.size();		
		def cal=Calendar.getInstance()
		def now_month=cal.get(Calendar.MONTH)
		def now_year=cal.get(Calendar.YEAR)
		//def check_token=Record.findByYearAndMonth(now_year,now_month)
		//if(check_token)
		//	return ;
		/*用于模拟*/
		def listnum=Record.list()
		def listnum_id=listnum.size()
		def record_lastDate=Record.get(listnum_id)

		Date now_date=new Date();
//		now_month++
//		if (now_month==12)
//		{
//			now_month=1;
//			now_year++;
//		}
		/*用于模拟*/
		def y_months=(record_lastDate.year-now_year)*12+record_lastDate.month-now_month
		def cc
while(y_months>0)
	{		
		while (count<=tablenum)
		{
			TableDynamic td = tableList.get(count-1);
			cc = Integer.parseInt(td.cycle);
			if(((now_year-start_year)*12+(now_month-start_month))%cc==0&&cc!=0)
			{
				def whynot=Authority.createCriteria()
				def need_id_list=whynot.list
				{
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
						def recordTime=new Record()
						recordTime.record_time=now_date
						plan_times.tableId=count
						plan_times.planTime=cal.getTime()
						plan_times.acountId=need_id_list.get(i).acountId
						plan_times.save()
					}
				}
																																					
			}
		count++
		}
		println("cry"+(n++)+" "+now_date.toLocaleString())	
		
		now_month--	
		if(!now_month)
			{
				now_month=12
				now_year--
			}
		cal.set(Calendar.YEAR,now_year)
		cal.set(Calendar.MONTH,now_month)
			
		y_months--
    }
	}
}
