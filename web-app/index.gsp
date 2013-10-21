<!DOCTYPE html>
<html>
	<head>
	<link rel="stylesheet" href="${createLinkTo(dir:'js',file:'extjs/resources/css/ext-all.css')}"/>
<%--	 <link rel="stylesheet" href="${createLinkTo(dir:'js',file:'extjs/resources/css/ext-all-neptune.css')}" ></link>--%>
<%--		<script type="text/javascript" src="${createLinkTo(dir:'js',file:'extjs/bootstrap.js')}"></script>--%>
		<script type="text/javascript" src="${createLinkTo(dir:'js',file:'extjs/ext-all-dev.js')}"></script>
		<script type="text/javascript" src="${createLinkTo(dir:'js',file:'extjs/locale/ext-lang-zh_CN.js')}"></script>
		<title>登陆界面</title>
		<script type="text/javascript" charset="utf-8">

		function changePic(){
			　　 $("#imageCaptcha").attr("src","/test/jcaptcha/jpeg/imageCaptcha?id="+new Date());
			   }
		   
		Ext.require([
		               'Ext.tip.QuickTipManager'
		        ]);
		       Ext.onReady(function(){
		    	   Ext.tip.QuickTipManager.init();
		    	   var denglu= Ext.create('Ext.form.Panel', {
		    		     x:50,
	              	     y:70,
	                     //height:120,
	                     //width: 400,
	                     standardSubmit:true,
	                     defaultType: 'textfield',
	                     items: [{
	                        fieldLabel: '用户名',
	                         name: 'acountname',
	                         allowBlank: false
	                         },{
	                         fieldLabel: '密码',
	                         name: 'password',
	                         inputType:'password',
	                         allowBlank: false
	                     },
		                 {
			                 xtype:'panel',
			                 layout:'hbox',
			                 //width:200,
			                 //height:80,
			                 items:[
					                 {xtype:'textfield',fieldLabel:'验证码',name: 'user_typed_captcha',allowBlank: false},
					                 {xtype:'panel',width:140,height:35,html:'<img style="-webkit-user-select: none" src="http://localhost:8080/test/jcaptcha/jpeg/imageCaptcha">'}
					         ]
			                 //bodyStyle:{background:'url(/test/jcaptcha/jpeg/imageCaptcha?id=${new Date()})'}
			              }

<%--		                     ,{--%>
<%--	                         xtype: 'panel',--%>
<%--	                         itemId: 'reCaptcha',--%>
<%--	                         border: false,--%>
<%--	                         html: '<div id="recaptcha">adsf</div>',--%>
<%--	                         listeners:--%>
<%--	                              {--%>
<%--	                                 console.log(Ext.getDom(this.body));--%>
<%--	                                 Recaptcha.create("heres_my_public_key",--%>
<%--	                                     Ext.getDom(this.body),--%>
<%--	                                     {--%>
<%--	                                         theme: "clean",--%>
<%--	                                         callback: Recaptcha.focus_response_field--%>
<%--	                                     }--%>
<%--	                                 );--%>
<%--	                             }--%>
<%--	                         }--%>
	                     
		    	    ],
	                     buttons: [{
	                         text: '重置',
	                            handler: function() {
	                                 this.up('form').getForm().reset();
	                             
	                            }
	                          },{
	                         text: '登陆',
	                             handler:function(){
	                     	       this.up('form').getForm().submit({
										url:'acount/login',
										method:'POST',
										failure:function(response,options){
											Ext.Msg.alert('Tip','login error');
											
											},
		                     	       success:function(response,options){
											Ext.Msg.alert('Tip','login success');
											
											
<%--											alert(options.responseText);--%>
<%--											var resultJson =Ext.JSON.decode(response.responseText);--%>
<%--											alert(resultJson);--%>
<%--											var url = resultJson.data;--%>
<%--											alert(url);--%>
<%--											window.location.href=url;--%>
											}
			                     	        });

	 	 								          }
	                          }
	                     ]
		    	   });

		    	   var main=Ext.create("Ext.panel.Panel",{
		                  layout:'border',
		                  //renderTo:Ext.getBody(),
		                  width:1000,
		                  height:500,
		                  items:[
		                     {xtype:'panel',region:'north',height:142,split:true,html:"logo",bodyStyle:{background:'url(images/index.jpg)'}  },
		                     {xtype:'panel',region:'west',width:500,split:true,html:"风采展示",bodyStyle:{background:'url(images/zhonglou.jpg)'} },
		                     {xtype:'panel',region:'center',
		                     	layout:{type:"absolute"},
		                     	split:true,
		                     	items:[
		                     	   denglu
		                     	]
		                     }
		                  ]
		              })   

	            	  var back=Ext.create("Ext.Viewport",{
	            		     bodyStyle:{background:'#dae7f6'},
  		            	  layout: {
  		            		  align: 'middle',
  		            		  pack: 'center',
  		            		  type: 'hbox'
  		            		},
	            		  items:[main]
	            	  })
		       })
 



		</script> 
	</head>
    <body bgcolor="#dae7f6">
<%--    验证码，陈诚添加，勿删--%>
<%--    <img id="imageCaptcha" width="100px" height="25px" src="/test/jcaptcha/jpeg/imageCaptcha?id=${new Date()}"/>--%>
<%--<jcaptcha:jpeg name="imageCaptcha" height="500px" width="500px"/>  --%>
<%--<g:textField name="user_typed_captcha" value="" />--%>
	</body>
</html>
