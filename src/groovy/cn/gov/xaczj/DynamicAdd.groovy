package cn.gov.xaczj;

import java.lang.annotation.Documented;

class DynamicAdd {
	ArrayList<TableDynamic> tableList= new ArrayList<TableDynamic>();
	
	public void lunch(ArrayList <HashMap <String,String>> list)
	{
		
		def dir = new File("src/groovy/xml")
		dir.eachFile{
			if(it.name.endsWith('.xml'))
			{
				println it.name
				HashMap<String,String> fileds = new HashMap<String,String>();
				XmlParser parser = new XmlParser();
				Node doc = parser.parse("src/groovy/xml/${it.name}");
				
				TableDynamic tableDy = new TableDynamic();
				def namemap=[:];
				namemap.putAt("tableName",doc.attribute("identifier"));
				namemap.putAt("chTableName",,doc.attribute("chTableName"));				
				tableDy.entityName = namemap;
				tableDy.cycle= doc.attribute("cycle")
				String tableId = doc.attribute("identifier");
				if(tableId == null){
					throw new Exception("missing table id ");
				}
				fileds.put("tableName",tableId);
				def params = doc.children().get(0)
				def operators = doc.children().get(1);
				int cnt=0;
				params.each{
					
					outputChildren(it,1,tableDy.table,fileds,cnt++);
				}
				println(tableDy.table);
				int index = Integer.parseInt(tableId.split('table')[1]);
				tableList.putAt(index-1, tableDy);
				list.putAt(index-1, fileds);
			}						
		}								
	}
	
	private  outputChildren( node, level,table1)
	{
		def param = new Expando();
		def ind;
		def tabel11 = table1;
		
		node.each {
			if(it.children().size() == 0)
			{
				param?."${it.attribute("name")}" = "";
			}
			else
			{
				param?."${it.attribute("name")}" = "";
				outputChildren(it,++level,param)
			}
		}
		table1.putAt(node.attribute("name"), param);
		return table1;
	}
	
	
	
	private  outputChildren( node, level,table1,HashMap<String,String> fileds,int cnt)
	{
		def param = new Expando();
		def ind;
		def tabel11 = table1;
		String name;
		String type;
		String value;
		
		param?."${node.attribute("value")}" = "";
		param?.num = cnt++;
		int ccnt=0;
		node.each {
			
			if(it.children().size() == 0)
			{
				param?."${it.attribute("name")}" = "";
				
				outputChildren(it,++level,param,fileds,ccnt++);
			//	def par = new Expando();
			//	param?.par?."${it.attribute("value")}" = "";
			//	param?."${it.attribute("value")}" = "";
				name = "${it.attribute("name")}";
				type = "${it.attribute("type")}";
			//	value = "${it.attribute("value")}";
//				System.out.println("on building,name:"+name);
//				System.out.println("on building,type:"+type);
				fileds.putAt(name,type);
			}
			else
			{
				param?."${it.attribute("name")}" = "";
			//	param?."${it.attribute("value")}" = "";
			//	value = "${it.attribute("value")}";
				outputChildren(it,++level,param,fileds,ccnt++)
			}
		}
		name = node.attribute("name");
		type = node.attribute("type");
//		param?."${node.attribute("value")}" = "";
	//	value = node.attribute("value");
		
		if(type != null)
		{
			fileds.putAt(name,type);
		}
		
		table1.putAt(name, param);
	
		return table1;
	}
}
