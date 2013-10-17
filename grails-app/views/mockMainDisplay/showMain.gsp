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
			var fillHref;
			var fillHref1;
			var auditHref;
			var table_id;
			var gridinf;
			var del_id_list=["ss"];
			var editstore;
			var plan_time_id;
			
			//生成日期的函数。返回值为年-月-日
			function GetDateT()
			{
			  var d,s;
			  d = new Date();
			  s = (1900+d.getYear()) + "-";
			  s = s + (d.getMonth() + 1) + "-";
			  s += d.getDate();
			  return(s);  
			} 

			//生成请求报表的URL  例如：/test/table/select/'+json.tableId
			function generatFillURL(json){
				 Ext.Ajax.request({
					 url:'/test/table/select/'+json.tableId,
					 method:'POST',
					 success:function(response){
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
				plan_time_id = json.id;
				gridinf ="<div >&emsp;<big>表"+json.tableId+": "+json.name+"</big></div>"+
					"<div>&emsp;<b>填报时间：</b>"+GetDateT()+"</div>";
				Ext.getCmp('gridinfId').body.update(gridinf);
				Ext.getCmp('center').layout.setActiveItem(4);
			};

			function generatAuditURL(json){
				Ext.Ajax.request({
					 url:'/test/table/select/'+json.tableId,
					 method:'POST',
					 params:{
						 audit:true
					 },
					 success:function(response){
						 console.log(response.responseText);
	                     var result=makeJson(response.responseText);
	                     auditstore = Ext.create('Ext.data.Store', {  
										fields:result.fieldsNames,
										data:result.data,
										autoLoad:true          
							}); 
						Ext.getCmp("auditGrid").reconfigure(auditstore,result.columModle);  //定义grid的store和column   
					}
			     });
				/*table_id=json.tableId;
				plan_time_id = json.id;
				gridinf ="<div >&emsp;<big>表"+json.tableId+": "+json.name+"</big></div>"+
					"<div>&emsp;<b>时间：</b>"+GetDateT()+"</div>";
				Ext.getCmp('gridinfId').body.update(gridinf);*/
				Ext.getCmp('center').layout.setActiveItem(6);
			}
			var getLastCorrectNumber = function(inputString) {
			    if(inputString.indexOf('-record') == -1) {
				   return inputString.substr(inputString.lastIndexOf('-')+1);
			    }
			};
		    Ext.onReady(function(){
				//生成填报表格的超链接
				function generatFillHref(str){
					var json = Ext.JSON.decode(str);
					var str;
					fillHref = "<big>要填报的表格名称</big><blockquote>";
					fillHref1 = "<big>不定时填报表格</big><br>用户根据需求选择表格进行填报<blockquote>";
					for(var i in json) {
						if(json[i].time==""){
							str = Ext.JSON.encode(json[i]);
							fillHref1 += "<div><a href ='javascript:generatFillURL("+str+")'>"+json[i].name+"  (表:"+json[i].tableId+")</a></div> <br>";
						}else{
							str = Ext.JSON.encode(json[i]);
							fillHref += "<div><a href ='javascript:generatFillURL("+str+")'>"+json[i].time+json[i].name+"  (表:"+json[i].tableId+")</a></div> <br>";
						}
					}
					fillHref += "</blockquote>";
					fillHref1 +="</blockquote>";
				};
				//生成审核表格的超链接
				function generatAuditHref(str){
					var json = Ext.JSON.decode(str);
					var str;
					auditHref = "<big>要审核的表格名称</big><blockquote>";
					for(var i in json) {
							str = Ext.JSON.encode(json[i]);
							auditHref += "<div><a href ='javascript:generatAuditURL("+str+")'>"+json[i].time+json[i].name+"  (表:"+json[i].tableId+")</a></div> <br>";
					}
					auditHref += "</blockquote>";
				};
				//填报表格按钮的响应函数
				function formButtonHandler(){
					Ext.Ajax.request({
						 url:'/test/mockMainDisplay/getShouldFillTables',
						 method:'POST',
						 success:function(response){
						 	var str = response.responseText;
						 	//console.log(str);
						 	generatFillHref(str);
						 	Ext.getCmp('tianbao_1').body.update(fillHref);
						 	Ext.getCmp('tianbao_2').body.update(fillHref1);
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
									 	var str = response.responseText;
									 	alert(str);
									 	generatAuditHref(str);
									 	Ext.getCmp('shenhe').body.update(auditHref);
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
					   {x:1100,y:50,width:250,xtype:'label',text: '当前用户: ${session.acount.acountName} ${session.acountPost.postName}'},	
					   Ext.create("Ext.button.Button",{
						   region:'south',
						   width:100,
						   height:30,
						   x:1100,
						   y:90,
				   	       text:'退出',
				   	       handler:function(){	
				   	        	window.location.href="/test/Acount/logout";			   	        
					   	   }
			   	        }),
						   Ext.create("Ext.button.Button",{
							   region:'south',
							   width:100,
							   height:30,
							   x:1230,
							   y:90,
					   	       text:'切换岗位',
					   	       handler:function(){	
					   	        	window.location.href="/test/mockMainDisplay/choosePost";			   	        
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
					//height: 600,
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
				                                if(del_id > 0){
				                                	del_id_list.push(del_id);	
						                        }
			                                	editgrid.getStore().remove(item);  
			                                });  
			                            }  
			                        });  
			                    }  
			                    else {  
			                        Ext.Msg.alert("错误", ' </br>无法进行删除操作!');  
			                    }
						     } 
						  }	  
						]
				});
				var editGrid=Ext.create("Ext.grid.Panel",{
			      	    height:450,
			            id:"editgrid",
			            enableColumnHide:false,
			            enableColumnMove:false,
			            columnLines:true,
			            plugins: [{ptype: 'cellediting', clicksToEdit: 2}], 
			            columns : []  	
			      });

			   var auditGrid = Ext.create("Ext.grid.Panel",{
		      	    height:450,
		            id:"auditGrid",
		            enableColumnHide:false,
		            enableColumnMove:false,
		            columnLines:true,
		            //plugins: [{ptype: 'cellediting', clicksToEdit: 2}], 
		            columns : []  	
		      });

				var tianbao2=Ext.create("Ext.panel.Panel",{
					tbar:[
					    {text:'返回',handler:function(){ center.layout.setActiveItem(1); } },
					    {text:'复核',handler:function(){ alert(del_id_list); }},
					    {text:'存草表',handler:function(){
					    	var str=unescape(Ext.encode(Ext.pluck(editgrid.getStore().data.items, 'data')).replace(/\\/g, "%") );			    	
				    		Ext.Ajax.request({
					 			    url: '/test/table/save',  
						            params :{
							            numFuckId:table_id,
							            data_rows:str,
							            del_rows:del_id_list,
							            planTime:plan_time_id,
							            commit:false
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
						            	Ext.Msg.alert("成功", '提交上级成功'); 
						            }  
	                			});
				    		del_id_list=["ss"];
					    	}
					    },'->',
					    {text:'导出模板'},
					    {text:'导入表格'}
					],
					items:[
					   gridinfPanel,
					   editGrid
					]		
				});//填报具体表格结束
				

				//查看表
				var temp=[];
				var treeurl='';
			    function treeinit (){
				   // alert(${session.acountPost.roleId});
				    if(${session.acountPost.roleId}==2){
				    	treeurl='/test/static/js/cityTree.json';
					 }else if(${session.acountPost.roleId}==6){
					    	treeurl='/test/static/js/ccTree.json';
				     }else{
					    	treeurl='/test/static/js/townTree.json';
					 }
			   };
			   
			//树
			Ext.create("Ext.data.TreeStore",{
				id:"treeStore"
			});			
		       
			var tree= new Ext.create("Ext.tree.Panel",{				
				region:'west',
       	        width: 250,
       	        root:{
           	        text:'查看表格',
           	        child:'treeStore'
           	     },
				rootVisible:true,
				listeners:{
					afterrender:function(store){
						tree.expandPath(tree.getRootNode().getPath());
					},
					beforeload:function(store){
						treeinit();
						store.setProxy({
							type:'ajax',
							url:treeurl
						});
					},
					itemclick:function(view,record,item,index,e){	
						var store=[];		
						temp[0]=record.raw.id;
						gridstore.setProxy({
							url:'/test/Browse/findtable',
							type:'ajax',
							reader:{
								type:'json'
							}
						});
					}
				}
			});//树结束
			
		 var gridstore=Ext.create("Ext.data.ArrayStore",{
	    	   fields:["id","tableName"],
	       });
       //选择表
		  var gridCombo = Ext.create('Ext.form.field.ComboBox', {
		  	emptyText : '请选择表名',
		  	displayField:"tableName",
            store:gridstore,
            listeners:{
            	select:function(combo, records, eOpts){
                    temp[1]=combo.getStore().findRecord("tableName",combo.value).raw.id;
                    //alert(temp[1]);
                    Ext.Ajax.request({
			 			    url: '/test/Browse/findYearCycle',  
				            params : {  
					            formId:temp[1]
				            },  
				            method : 'POST',  
				            success : function(response) {
				            	//alert(response.responseText);
				            	var tempjson=Ext.JSON.decode(response.responseText);	
				            	//alert(tempjson.year)
				            	var nianstore=[];
				            	for(var i in tempjson.year){
					            	nianstore.push([tempjson.year[i]]);
					            };
					            console.log(nianstore);
				            	yearCombo.getStore().setProxy({
					            	type:'memory',
					            	reader:{
						            	type:'array'
						            },
						            data:nianstore
					            });			            		
			       			     switch(tempjson.cc){
			       			     case "3":
			       			            var jidu=[["第一季度"],["第二季度"],["第三季度"],["第四季度"]];
					       			     monthCombo.getStore().setProxy({
						       			     type:'memory',
						       			     reader:{
							       			     type:'array'
							       			  },
							       			  data:jidu				       			  
					       			     });
					       			    	break;
			       			     case "6":
			       			    	var year=[["上半年"],["下半年"]];
			       			    	monthCombo.getStore().setProxy({
						       			     type:'memory',
						       			     reader:{
							       			     type:'array'
							       			  },
							       			  data:year				       			  
					       			});
			       			    	break;            			     
			       			     default:
			       			        break;			       			          			            	
		                    }  
		                    }
        			 });       			     
               }
            }
      });
      //选择年份内容
      var yearstore=Ext.create("Ext.data.ArrayStore",{
    	   fields:["text"],
    	   data:[]
       });
       //选择年份
		  var yearCombo = Ext.create('Ext.form.field.ComboBox', {
		  	emptyText : '请选择年份',
            store:yearstore
      });
      //选择季度内容
      var monthstore=Ext.create("Ext.data.ArrayStore",{
    	   fields:["text"],
    	   data:[]
       });
       //选择季度
		  var monthCombo = Ext.create('Ext.form.field.ComboBox', {
		  	emptyText : '请选择季度',
           store:monthstore
      });
      
			var checkgrid=Ext.create("Ext.panel.Panel",{
				region:'center',
				tbar:[
				   gridCombo,
				   yearCombo,
				   monthCombo,
				   {text:'查看',handler:function(){
				   	 	Ext.Ajax.request({
			 			    url: '/test/Browse/watchtable',  
				            params : {  
					             unit:temp[0],
						         gridId:temp[1],
							     year: temp[2],
							     cycle:temp[3]
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
				]
			});	
						
			var check=Ext.create("Ext.panel.Panel",{
               layout:'border',
				items:[
				   tree,
				   checkgrid
				]
			});//查看表结束
			
		//审核界面
      var shenhe2=Ext.create("Ext.panel.Panel",{
      	tbar:[
				    {text:'返回',handler:function(){
				    	  center.layout.setActiveItem(2);
				       }
				    },
				    {text:'接收',handler:function(){
					    	var str=unescape(Ext.encode(Ext.pluck(editgrid.getStore().data.items, 'data')).replace(/\\/g, "%") );			    	
				    		Ext.Ajax.request({
					 			    url: '/test/table/acceptData',  
						            params :{
							            numFuckId:table_id,
							            data_rows:str
						            },  
						            method : 'POST',  
						            success : function(response) {
						            	Ext.Msg.alert("成功", '接收成功！</br>FUCK F--U--C--K！'); 
						            }  
	                			});	
					       }
				    },
				    {text:'拒绝',handler:function(){
					    	var str=unescape(Ext.encode(Ext.pluck(editgrid.getStore().data.items, 'data')).replace(/\\/g, "%") );			    	
				    		Ext.Ajax.request({
					 			    url: '/test/table/denyData',  
						            params :{
							            numFuckId:table_id,
							            data_rows:str
						            },  
						            method : 'POST',  
						            success : function(response) {
						            	Ext.Msg.alert("成功", '拒绝成功！</br>FUCK F--U--C--K！'); 
						            }  
	                			});	
					       }
					 },'->',
				    {text:'上一张'},
				    {text:'下一张'}
				],
				items:[
				auditGrid
				]	
      });
			var shenhe=Ext.create("Ext.panel.Panel",{
				 id:'shenhe',
				 html:''
			});//审核界面结束
			
			
			var chaxun=Ext.create("Ext.panel.Panel",{
				 html:"chaxun"
			});
			
			//主区域定义			
			var center=Ext.create("Ext.panel.Panel",{
				id:'center',
				height:800,
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
		});
	</script>
</head>
<body>		
</body>
</html>
			