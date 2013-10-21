package test


//import java.text.SimpleDateFormat
import java.util.Calendar
import cn.gov.xaczj.*;

class MyjobJob {	
	
	def dynamic;
	
	static  n=0 ;
	static start_month=1//�п�����9������
	static start_year=2010
	def now_month=1
    def now_year=2019
	//static 
    static triggers = {
		//
//		simple repeatInterval: 10000l // execute job once in 5 seconds
        /*����ģ��*/
		cron name: 'myTrigger', cronExpression: "0 0 0 1 * ?"
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
		Calendar cac
		def now_month=cal.get(Calendar.MONTH)+1
		def now_year=cal.get(Calendar.YEAR)	
//		println("${now_month},${now_year}")
		def count=1
		def listnum=Record.list()
		def listnum_id=listnum.size()
//		println(listnum)
		def record_lastDate=Record.get(listnum_id)
//		println(record_lastDate)
		Date now_date=new Date();
//		now_month++
//		if (now_month==12)
//		{
//			now_month=1;
//			now_year++;
//		}
		/*����ģ��*/
		
		def y_months
		if (listnum_id!=0)
			{
				y_months=(now_year-record_lastDate.year)*12+now_month-record_lastDate.month
//				println("-----"+((now_year-record_lastDate.year)*12+now_month-record_lastDate.month))
			}
		else{
			y_months=1
			}
		def cc
//		println("chae:="+y_months)
		while(y_months>0)
		{
//			println("1"+count+" "+tablenum)
			count=1
			while (count<=tablenum)
			{
//				println("2")
				TableDynamic td = tableList.get(count-1);
				cc = Integer.parseInt(td.cycle);
				println("cc:${cc}")
				if(cc!=0)
				println("${now_year}-${start_year}-${now_month}-${start_month}-${(((now_year-start_year)*12+(now_month-start_month))%cc==0)}")
				if(cc!=0 && ((now_year-start_year)*12+(now_month-start_month))%cc==0)
				{																
					def whynot=Authority.createCriteria()
					def need_id_list=whynot.list 
					{
						and{
							form{
								eq("no",count)
								}	
							eq("authority",(short)1)
							}										
					}
					//println(need_id_list)
					if(need_id_list.size()>0)
					{
						for(i in 0..need_id_list.size()-1)
						{
							//println need_id_list[i]
							def plan_times=new PlanTime()
							def recordTime=new Record()
							cac=Calendar.getInstance()
							cac.setTime(now_date)
							recordTime.year=cac.get(Calendar.YEAR)
							recordTime.month=cac.get(Calendar.MONTH)+1
							recordTime.save()
							plan_times.tableId=count
							plan_times.planTime=cal.getTime()
							plan_times.postId=need_id_list.get(i).postId
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
//			println("year"+now_year+"month"+now_month)
			cal.set(Calendar.YEAR,now_year)
			cal.set(Calendar.MONTH,now_month-1)
			//println(cal)	
			y_months--
//			println("sss"+y_months)
		}
			
	   }
	}
