package test

import grails.converters.JSON
import org.hibernate.*;
import cn.gov.xaczj.HibernateUtil;
import cn.gov.xaczj.TableDynamic

class BrowseController {
	def dynamic;
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
		Acount loginAcount = session.acount;
	
		if(loginAcount.jobTitle == "blqczj")
		{
			def taList = [];
			def jt = Acount.get(loginAcount.id).jobTitle;
			def role = Acount.findByParentAcount(jt).role;
			def forms = Registration.findAllByRole(role);
			taList = conJson(forms);
			render taList as JSON;
		}
		else if(loginAcount.jobTitle == "xasczj")	
		{
			
			def qxForms = Registration.findAllByRole(Role.get(4));//区县
			def qxList = conJson(qxForms);
			def kfqForms = Registration.findAllByRole(Role.get(8));//开发区
			def kfqList = conJson(kfqForms);
			def sbjForms = Registration.findAllByRole(Role.get(9));//市本级
			def sbjList = conJson(sbjForms);
			def jsdwForms = Registration.findAllByRole(Role.get(5));//市本级
			def jsdwList = conJson(jsdwForms);
			render(contentType: "application/json",encoding: "gbk") {
				qx = qxList;
				kfq = kfqList;	
				sbj = sbjList;
				jsdw = jsdwList;
			}
		}			
	}
	
	def findYearCycle()
	{		
		try 
		{
			def formId=params.formId;
			String hql ="select planTime from table"+"${formId}"
			def yearlist=[];
			def years = HibernateUtil.getInstance().getCurrentSession().createQuery(
				hql).list();
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
			formId=formId-1;
			TableDynamic td = tableList.get((int)formId);
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
}
