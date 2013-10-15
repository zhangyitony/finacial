<!DOCTYPE html>
<html>
	<head>
	<link rel="stylesheet" href="${createLinkTo(dir:'js',file:'extjs/resources/css/ext-all.css')}"/>
    <link rel="stylesheet" href="${createLinkTo(dir:'js',file:'extjs/resources/css/ext-all-neptune.css')}" />
<%--		<script type="text/javascript" src="${createLinkTo(dir:'js',file:'extjs/bootstrap.js')}"></script>--%>
<%--		<script type="text/javascript" src="${createLinkTo(dir:'js',file:'extjs/ext-all.js')}"></script>--%>
		<script type="text/javascript" src="${createLinkTo(dir:'js',file:'extjs/ext-all-dev.js')}"></script>
		<script type="text/javascript" src="${createLinkTo(dir:'js',file:'extjs/locale/ext-lang-zh_CN.js')}"></script>
		<script type="text/javascript" src="${createLinkTo(dir:'js',file:'makeJson.js')}"></script>
		<title>主界面</title>
<%--        <style type="text/css">--%>
<%--               *{font-size:15px!important }--%>
<%--        </style>--%>
		<script type="text/javascript" charset="utf-8">
			var center;	
			var href;
			var href1;
			var table_id;
			var gridinf;
			var del_id_list=["s"];
			var editstore;
			function GetDateT()
			{
			  var d,s;
			  d = new Date();
			  s = (1900+d.getYear()) + "-";
			  s = s + (d.getMonth() + 1) + "-";
			  s += d.getDate();
			  return(s);  
			} 
			function generatURL(json){
				 Ext.Ajax.request({
					 url:'/test/table/select/'+json.tableId,
					 method:'POST',
					 success:function(response){
						 //alert(response.responseText);
						 console.log(response.responseText);
	                     var result=makeJson(response.responseText);
						 editstore = Ext.create('Ext.data.Store', {  
										fields:result.fieldsNames,
										data:result.data,
										autoLoad:true          
							}); 
						Ext.getCmp("editgrid").reconfigure(editstore,result.columModle);  //定义grid的store和column   
					}
			     });
				table_id=json.tableId;
				gridinf ="<div >&emsp;<big>表"+json.tableId+": "+json.name+"</big></div>"+
<%--					"<div>&emsp;<b>填报单位：</b>${session.acount.jobTitle}</div>"+--%>
					"<div>&emsp;<b>填报时间：</b>"+GetDateT()+"</div>";
				Ext.getCmp('gridinfId').body.update(gridinf);
				Ext.getCmp('center').layout.setActiveItem(4);
			};
			var getLastCorrectNumber = function(inputString) {
			    if(inputString.indexOf('-record') == -1) {
				   return inputString.substr(inputString.lastIndexOf()-1);
			    }
			};
		    Ext.onReady(function(){
				//生成超链接
				function generatHref(str){
					var json = Ext.JSON.decode(str);
					var str;
					href = "<big>要填报的表格名称</big><blockquote>";
					href1 = "<big>不定时填报表格</big><br>用户根据需求选择表格进行填报<blockquote>";
					for(var i in json) {
						if(json[i].time==""){
							str = Ext.JSON.encode(json[i]);
							href1 += "<div><a href ='javascript:generatURL("+str+")'>"+json[i].name+"  (表:"+json[i].tableId+")</a></div> <br>";
						}else{
							str = Ext.JSON.encode(json[i]);
							href += "<div><a href ='javascript:generatURL("+str+")'>"+json[i].time+json[i].name+"  (表:"+json[i].tableId+")</a></div> <br>";
						}
					}
					href += "</blockquote>";
					href1 +="</blockquote>";
				};
				//填报表格按钮的响应函数
				function formButtonHandler(){
					Ext.Ajax.request({
<%--						 url:"${createLinkTo(dir:'data',file:'allTables/table.json')}",--%>
						 url:'/test/mockMainDisplay/getShouldFillTables',
						 method:'POST',
						 success:function(response){
						 	var str = response.responseText;
						 	console.log(str);
						 	generatHref(str);
						 	Ext.getCmp('tianbao_1').body.update(href);
						 	Ext.getCmp('tianbao_2').body.update(href1);
						 }
					})
				 	center.layout.setActiveItem(1);
				};
				
				//主菜单四大功能按钮										
	 			var bar = Ext.create(Ext.toolbar.Toolbar,{
	 				//style: 'background-color:C4E8FD;', 
					items:[
					   Ext.create("Ext.button.Button",{
						   	text:"首页",
						   	width:200,
						   	handler:function(){ center.layout.setActiveItem(0);	}
					   }),
					   Ext.create("Ext.button.Button",{
						 	text:"填报表格",
						 	width:200,
						 	handler:formButtonHandler						   						 	
					   }),
					   Ext.create("Ext.button.Button",{
							text:"浏览报表",
							width:200,
							handler:function(){			   	
							   	   center.layout.setActiveItem(5);//跳转到check
							}
						}),
						Ext.create("Ext.button.Button",{
							//hidden:true,
							text:"审核新表",
							width:200,
							handler:function(){
								Ext.Ajax.request({
								 url:'/test/mockMainDisplay/getShouldAuditTables',
								 method:'POST',
								 success:function(response){
								 	//var str = response.responseText;
<%--								 	console.log(str);--%>
<%--								 	generatHref(str);--%>
<%--								 	Ext.getCmp('tianbao_1').body.update(href);--%>
<%--								 	Ext.getCmp('tianbao_2').body.update(href1);--%>
								 }
							})
								center.layout.setActiveItem(2);
							}
						}),					
						Ext.create("Ext.button.Button",{
							//hidden:true,
							text:"查询分析",
							width:200,
							handler:function(){
								center.layout.setActiveItem(3);
							}
						})										
					]
			  });//主菜单四个功能按钮结束

		   //logo	  
	       var logopanel = Ext.create('Ext.panel.Panel', {
		    	bodyStyle:{background:'url(/test/static/images/title.jpg)' }, 
		    	//height:200,
				layout:'absolute',
				//baseCls: 'my-panel-no-border',
		        items:[ 
					   {x:1150,y:50,width:200,xtype:'label',text: '当前用户: ${session.acount.acountName} ${session.acountPost.postName}'},	
					   Ext.create("Ext.button.Button",{
						   region:'south',
						   width:100,
						   height:30,
						   x:1150,
						   y:90,
				   	       text:'退出',
				   	       handler:function(){	
				   	        	window.location.href="/test/Acount/logout";			   	        
					   	   }
			   	        })
		   	     ]   
	       }); //logo结束
	      
      		//主菜单+logo区域定义                      			
			var top=Ext.create("Ext.panel.Panel",{
				//height:200,
				bbar:[bar],
				items:[
				   logopanel
				]
			});//主菜单+logo区域定义结束
				
	      		//首页区域定义
				var shouye=Ext.create("Ext.panel.Panel",{
					 //bodyStyle:'font-size:20px',
			         html:'首页还未开发'
				});//首页区域定义
				
				//选择填报表格页				
				var tianbao=Ext.create("Ext.panel.Panel",{
					layout: 'column',
					height: 600,
					defaults:{
						height: 600,
						autoScroll:true,
						collapsible:false,	
					},
					items:[
						Ext.create("Ext.panel.Panel",{
							columnWidth:.5,
							id:"tianbao_1",
							html:'',
						}),
						Ext.create("Ext.panel.Panel",{
							columnWidth:.5,
							id:"tianbao_2",
							html:'',
						})
					]
				});//选择填报表格页
				
				//填报具体表格
				 var gridinfPanel=Ext.create('Ext.panel.Panel',{
					id:'gridinfId',
					height:100,
					html:'',
					bbar:[
						   {xtype:'button',text:"增加行",
							handler:function(){
				                var rec=Ext.create("Ext.data.Store",{
				                	fields:editgrid.getStore().model.prototype.fields.keys,
				                	data:[]			
				                });                
					   	    	editgrid.getStore().insert(editgrid.getStore().getCount(),rec.data);
						   	}
						  },
						  {xtype:'button',text:"删除行",
						    handler:function(){
						   		var selModel = editgrid.getSelectionModel();
			                    if (selModel.hasSelection()) { 
			                        Ext.Msg.confirm("警告", "确定要删除吗？", function(button) {  
			                            if (button == "yes") {  
			                                var selections = selModel.getSelection();  
			                                Ext.each(selections, function(item) {
				                                var del_id=getLastCorrectNumber(item.id);
				                                if(del_id >= 0){
				                                	del_id_list.push(del_id);	
						                        }
			                                	editgrid.getStore().remove(item);  
			                                });  
			                            }  
			                        });  
			                    }  
			                    else {  
			                        Ext.Msg.alert("错误", '你丫的连一行都没选，我咋删除啊？</br>无法进行删除操作!');  
			                    }
			                 del_id_list = ["s"]; 
						     } 
						  }	  
						]
				});
				var editgrid=Ext.create("Ext.grid.Panel",{
			      	    height:450,
			            id:"editgrid",
			            enableColumnHide:false,
			            enableColumnMove:false,
			            columnLines:true,
			            forceFit:true,
			            plugins: [{ptype: 'cellediting', clicksToEdit: 2}], 
			            columns : []  	
			      });

				var tianbao2=Ext.create("Ext.panel.Panel",{
					tbar:[
					    {text:'返回',handler:function(){ center.layout.setActiveItem(1); } },
					    {text:'复核',handler:function(){ alert(del_id_list); }},
					    {text:'存草表',handler:function(){
					    	var str=unescape(Ext.encode(Ext.pluck(editgrid.getStore().data.items, 'data')).replace(/\\/g, "%") );			    	
							alert(str);
				    		Ext.Ajax.request({
					 			    url: '/test/table/save',  
						            params :{
							            numFuckId:table_id,
							            data_rows:str,
							            del_rows:del_id_list
						            },  
						            method : 'POST',  
						            success : function(response) {
						            	Ext.Msg.alert("成功", '草表保存成功！</br>记得下次来看我哟！'); 
						            }  
	                			});
	                			del_id_list=["ss"];
					       }
					    },
					    {text:'上报上级',handler:function(){
					    	var str=unescape(Ext.encode(Ext.pluck(editgrid.getStore().data.items, 'data')).replace(/\\/g, "%") );			    	
							alert(str);
				    		Ext.Ajax.request({
					 			    url: '/test/table/save',  
						            params :{
							            numFuckId:table_id,
							            data_rows:str,
							            del_rows:del_id_list,
							            commit:true
						            },  
						            method : 'POST',  
						            success : function(response) {
						            	Ext.Msg.alert("成功", '草表保存成功！</br>记得下次来看我哟！'); 
						            }  
	                			});
                			alert(del_id_list);
				    		del_id_list=["ss"];
					    	}
					    },'->',
					    {text:'导出模板'},
					    {text:'导入表格'}
					],
					items:[
					   gridinfPanel,
					   editgrid
					]		
				});//填报具体表格结束
				

				//查看表
				var temp=[];
				var treeurl='/test/static/js/cityTree.json';
			    function treeinit (){
<%--		              if('${session.acount.jobTitle}'=='建设单位'){--%>
<%--						treeurl='/test/static/js/ccTree.json';--%>
<%--					}else if('${session.acount.jobTitle}'=='财政局'){--%>

<%--						treeurl='/test/static/js/cityTree.json';--%>
<%--					}else{--%>
<%--						treeurl='/test/static/js/townTree.json';--%>
<%--					};--%>
			   };

	        
				//树的内容
				var treeStore=Ext.create("Ext.data.TreeStore",{
					id:"treeStore",               
				});
				
				//树
				var tree = new Ext.create("Ext.tree.Panel",{
					width:250,				
					region:'west',
					//store:"treeStore",
					root:{
					   text:'查看表格',
					   child:'treeStore'
					},
					rootVisible:true,
					listeners:{	
					    afterrender:function(store){
					             tree.expandPath(tree.getRootNode().getPath());
					             //tree.expandAll();
					    },			    
					    beforeload:function(store){					         
					           treeinit();
					           store.setProxy({
					            type:'ajax',
							     url:treeurl
							   });
					    },
						itemclick: function(view, record, item, index, e) { 							
							temp[0]=record.raw.id;
							//alert("后台你要返回要选择的表combo~");
				    		Ext.Ajax.request({
				 			    url: '/test/Browse/findtable',  
					            params : {  
						            unit:temp[0]
					            },  
					            method : 'POST',  
					            success : function(response) {
					            	//alert(response.responseText);
					            	var gridlist=Ext.JSON.decode(response.responseText);
					            	var store=[];
                                    for(var i in gridlist){                                       
                                           var tempstr="{"+"id:"+gridlist[i].id+","+"text:"+"'"+gridlist[i].tableName+"'"+"}"; 
                                          // var tempstr='['+"'"+gridlist[i].tableName+"'"+']'; 
                                           //alert(tempstr);
                                           var str=Ext.JSON.decode(unescape(tempstr.replace(/\\/g, "%")) );
                                           //alert(str);
                                          store.push(str);
                                    }; 
                                    alert( unescape(Ext.JSON.encode(store).replace(/\\/g, "%") )); 

                                
                                    //alert(gridstore.data[0].text);
                                   //gridCombo.setValue(store);
                                   
			                    }  
            			   });
				        }		        							
					}
				});



			//选择表的内容
		 var gridstore;
		  //var gridstore=	Ext.create("Ext.data.ArrayStore",{
	    	  // fields:["id","text"],
	    	  // data:[]
	      // });
	      	       
	       //选择表
		  var gridCombo = Ext.create('Ext.form.field.ComboBox', {
			  	emptyText : '请选择要查看的表格',
	        	store:gridstore,
	        	valueField:"text",
	        	listeners:{
	        		select:function(combo, records, eOpts){
	                    temp[1]=combo.value;
	                    alert("后台你要告诉我该表可选年份和该表是半年报表还是季表~");
	                    Ext.Ajax.request({
				 			    url: '',  
					            params : {  
						            unit:temp[0]
					            },  
					            method : 'POST',  
					            success : function(response) {
					            	
			                    }  
            			 });
	               }
		        }
	      });
	      //选择年份内容
	      var yearstore=Ext.create("Ext.data.ArrayStore",{
	    	   fields:["text"],
	    	   data:[
	    	    	["2011年"],
	    	    	["2012年"],
	    		    ["2013年"],
	    		    ["2014年"],
	    		    ["2015年"]
	         ]
	       });
	       //选择年份
			var yearCombo = Ext.create('Ext.form.field.ComboBox', {
			  	emptyText : '请选择年份',
	        	store:yearstore,
	        	listeners:{
	        		select:function(combo, records, eOpts){
	                    temp[2]=combo.value;
	               }
		        }
	      	});
	      //选择季度内容
	      var monthstore=Ext.create("Ext.data.ArrayStore",{
	    	   fields:["text"],
	    	   data:[
	    	    	["第一季度"],
	    	    	["第二季度"],
	    		    ["第三季度"],
	    		    ["第四季度"]
	         ]
	       });
	       //选择季度
		  var monthCombo = Ext.create('Ext.form.field.ComboBox', {
			  	emptyText : '请选择季度',
	        	store:monthstore,
	        	listeners:{
	        		select:function(combo, records, eOpts){
	                    temp[3]=combo.value;
	                    Ext.Ajax.request({
				 			    url: '',  
					            params : {  
						            unit:temp[0]
					            },  
					            method : 'POST',  
					            success : function(response) {
					            	
			                    }  
            			 });
	               }
		        }
      	  });
             var checkGrid=Ext.create("Ext.grid.Panel",{ 
	            id:"checkGrid",  
	            columns : [],  
	            displayInfo : true,  
	            emptyMsg : "没有数据显示",  
	            items : []  
	        });	
				var checkpanel=Ext.create("Ext.panel.Panel",{
					region:'center',
					tbar:[
					   gridCombo,
					   yearCombo,
					   monthCombo,
					   {text:'查看',handler:function(){
					   	 	Ext.Ajax.request({
						 			    url: '/test/table/select/1',  
					            params : {  
						             unit:temp[0],
							         gridName:temp[1],
								     year: temp[2],
								     month:temp[3]
					            },  
					            method : 'POST',  
					            success : function(response) {  
						              //alert(temp[0]+temp[1]+temp[2]+temp[3]);
						              //alert(response.responseText);
						              var json=makeJson(response.responseText);
						              //alert(json);						               
						              var store = Ext.create('Ext.data.Store', {  
							                 fields : json.fieldsNames,//把json的fieldsNames赋给fields  
							                 data : json.data          //把json的data赋给data  
						               });   
						               Ext.getCmp("checkGrid").reconfigure(store, json.columModle);  //定义grid的store和column   
					            }  
	                      });
					     }
					   },
					   {text:'导出为excel'}
					],
					items:[
					   checkGrid
					]
				});        	
				var check=Ext.create("Ext.panel.Panel",{
					layout:'border',
					items:[
					   tree,
					   checkpanel
					]
				});//查看表结束
				

			var shenhe=Ext.create("Ext.panel.Panel",{
				 //html:"shenhe"
				 items:[
				     {xtype:'text',text:'西安市财政局未审核表格：共一张'},
				     {xtype:'button',text:'西安市房屋保障资金表',
				     	   handler:function(){
				     	   	center.layout.setActiveItem(6);			     	   	
				     	   }
				     }			    
				 ]
			});//审核界面结束
			var shenhe2=Ext.create("Ext.panel.Panel",{
				 html:"shenhe2"
			});
				
			var chaxun=Ext.create("Ext.panel.Panel",{
				 html:"chaxun"
			});
				
				//主区域定义		
				var center=Ext.create("Ext.panel.Panel",{
					id:'center',
					height:600,
					layout:'card',
					items:[
					   shouye,
					   tianbao,
					   shenhe,
					   chaxun,
					   tianbao2,
					   check,
					   shenhe2
					]
				});				
				var main=Ext.create("Ext.panel.Panel",{
					renderTo:Ext.getBody(),
					items:[
					   top,
					   center
					]
				})//主区域定义结束
		   })
		</script> 
	</head>
	<body>
	</body>
</html>
