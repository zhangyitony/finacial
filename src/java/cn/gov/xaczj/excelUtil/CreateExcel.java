package cn.gov.xaczj.excelUtil;



//生成Excel的类
import java.io.File;

import jxl.CellType;
import jxl.Workbook;
import jxl.Sheet;
import jxl.Cell;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

//const ArrayList<>

class unit{
	int rnum=0,cnum=0,zrs=0,zcs=0;
	String content;
	
	public void writeat(WritableSheet sheet){
		 try {
			 sheet.addCell(new Label(cnum,rnum,content));
			 sheet.mergeCells(cnum, rnum, cnum+zcs, rnum+zrs);
		 } catch (Exception e) {
	            System.out.println(e);
	        }
	}
}


public class CreateExcel {
	/*public ArrayList<unit>  dataswitch(){
		unit temp=new unit();
		ArrayList<unit> sw = new ArrayList<>();
		//sw.add(0, element);
		
		return sw;
	}*/
  public static String writeExcel(ArrayList<ArrayList<String>> data,int formId) {
  	
  	String  fileUrl = "";
      try {
          // 打开文件
         /* WritableWorkbook book = Workbook.createWorkbook(new File("test.xls"));
          // 生成名为“第一页”的工作表，参数0表示这是第一页
          WritableSheet sheet = book.createSheet("第一页", 0);
          // 在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
          // 以及单元格内容为test
          Label label = new Label(0, 0, "a");
          sheet.addCell(new Label(1,0,"b"));
          // 将定义好的单元格添加到工作表中
          sheet.addCell(label);

          /*
           * 生成一个保存数字的单元格 必须使用Number的完整包路径，否则有语法歧义 单元格位置是第二列，第一行，值为789.123
           */
       /*   sheet.mergeCells(1, 0, 2, 0);
          //jxl.write.Number number = new jxl.write.Number(1, 0, 555.12541);
          sheet.addCell(new Label(0,1,"1"));
          sheet.addCell(new Label(1,1,"2"));
          sheet.addCell(new Label(2,1,"3"));
          unit nihao=new unit();
          nihao.cnum =3;
          nihao.rnum =4;
          nihao.zcs =2;
          nihao.zrs =3;
          nihao.content="我是卖报的小行家";
          nihao.writeat(sheet);

          // 写入数据并关闭文件
          book.write();
          book.close();*/
      /*	Workbook book = Workbook.getWorkbook(new File("Test.xls"));   
          //get a Sheet object.    
          Sheet sheet = book.getSheet(0);   
          //get 1st-Column,1st-Row content.   
          Cell cell = sheet.getCell(0, 0);   
          String result = cell.getContents();   
          System.out.println(result);   
          book.close();  
          
           if (wc.getType() == CellType.LABEL) {
		        	 Label l = (Label) wc;
		        	 l.setString("The value has been modified.");
		        	 }*/
      //	String [] sw = new String[10];
      //	sw={"1","2"};
      	//String a[]={"4","5","6","1","2","3"};
      	
      	//int i,j;
      	int srn=0,scn=0;
      	switch(formId)
      	{
      	case(1):{
      		srn=11;
      		scn=1;
      		break;
      	}
      	
      	}
      	Long timeM = new Date().getTime();
      	String timeStamp = timeM.toString();
      	fileUrl = "D:\\Book"+formId+timeStamp+".xls";
      	Workbook workBook = Workbook.getWorkbook(new File("Test.xls")); //////////////////注意此处更改表名
      	 // 利用已经创建的Excel工作薄创建新的可写入的Excel工作薄
      	 WritableWorkbook wwb = Workbook.createWorkbook(new File(fileUrl), workBook);
      	 // 读取第一张工作表
      	 WritableSheet ws = wwb.getSheet(0);
      	 // 获取第一个单元格对象
      	// 
      	 // 决断单元格的类型，做出相应的转化
      	 
//      	 ArrayList<ArrayList<String>> data = new ArrayList<>();
//      	 
//           // 第一列
//           ArrayList <String>col_lst = new ArrayList<>();
//           col_lst.add("a");// 第一行，第一列
//           col_lst.add("bc");// 第一行，第二列
//    
//           data.add(col_lst);
//    
//           // 第二列
//           col_lst = new ArrayList<>();
//           col_lst.add("d");// 第二行，第一列
//           col_lst.add("ef");// 第二行，第二列
//    
//           data.add(col_lst);
      	 
      	 int x;
      	 int y;
      	 ArrayList<String> value;
      	 for(x = 0;x<data.size();x++){
      		value = data.get(x);
      		 for(y = 0;y < value.size();y++){
      			 ws.addCell(new Label(x+scn,y+srn,value.get(y)));
      		 }
      	 }
      	 
      	/* for(i=0;i<2;i++)
	         {
      		 for(j=0;j<2;j++){
	        		 
      			 ws.addCell(new Label(7+i,7+j,a[i+j]));
		        		     
		        	     
		        	 
	        	 }
      	 }
      	 */
      	
      	 // 写入Excel对象
      	 wwb.write();
      	 wwb.close();
      	 // 操作完成时，关闭对象，翻译占用的内存空间
      	 workBook.close();
          System.out.println("Success!");

      } catch (Exception e) {
          System.out.println(e);
      }
		return fileUrl;
  }
  public static void main(String args[]){
  		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
 	 
      // 第一列
      ArrayList <String>col_lst = new ArrayList<String>();
      col_lst.add("yu");// 第一行，第一列
      col_lst.add("hang");// 第一行，第二列

      data.add(col_lst);

      // 第二列
      col_lst = new ArrayList<String>();
      col_lst.add("ni");// 第二行，第一列
      col_lst.add("hao");// 第二行，第二列

      data.add(col_lst);
      
  	CreateExcel.writeExcel(data, 1);
  }
}

