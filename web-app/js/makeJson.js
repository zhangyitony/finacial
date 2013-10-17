
function makeTextClean(str){
			str = str.replace(/\s/g,"");
			str = str.replace(/\n/g,"");
			str = str.replace(/\r/g,"");
			str= str.replace(/\[{/g,"{");
			str= str.replace(/},{/g,",");
			str= str.replace(/\]/g,"");
			return str;
	}
function makeColumJson(json,arr,jsonx){
	
	for(var i in json) {
		if(typeof json[i] == 'object'){
			if(i == "columModle"){
				arr.push("{\""+i+"\": [");
				makeColumJson(json["columModle"],arr,jsonx);
				arr.push("]}");
			}else {
				arr.push("{\"text\":\""+i+"\",\"columns\": [");
				makeColumJson(json[i],arr,jsonx);
				arr.push("]}");
			}
		}else 
		{
			
			
			
           			 for(var j in jsonx){
           				
						if( i==j &&jsonx[j]=="big_decimal"){
							
							arr.push("{\"text\":\""+json[i]+"\",\"dataIndex\":\""+i+"\",\"editor\":\"numberfield\"}");
						}
						else if(i==j &&jsonx[j]=="string"){
							
							arr.push("{\"text\":\""+json[i]+"\",\"dataIndex\":\""+i+"\",\"editor\":\"textfield\"}");
						}
						else if(i==j &&jsonx[j]=="calendar_date"){
							
							arr.push("{\"text\":\""+json[i]+"\",\"dataIndex\":\""+i+"\",\"editor\":\"datefield\"}");
						}
						else if(i==j &&jsonx[j]=="integer"){
							
							arr.push("{\"text\":\""+json[i]+"\",\"dataIndex\":\""+i+"\",\"editor\":\"numberfield\"}");
						}
						
           			 }
			
			
		
			//arr.push("{\"text\":\""+json[i]+"\",\"dataIndex\":\""+i+"\",\"editor\":\"textfield\"}");
			
		}
	}
}

	function makeFieldsJson(json,arr){
		for(var i in json){
			if(typeof json[i] == 'object'){
				if(i == "columModle"){
					arr.push("{\"fieldsNames\": [");
					makeFieldsJson(json[i],arr);
					arr.push("]}");
				}else {
					makeFieldsJson(json[i],arr);
				}
			}else {
				arr.push("{\"name\":\""+i+"\"}");
			}
		}
	}

	function makeJsonClean(arr){
		var str = arr.toString();
		str = str.replace(/\[,/g,"[");
		str = str.replace(/\]},/g,"]}");
		str = str.replace(/},\]/g,"}]");
		str = str.replace(/}{/g,"},{");
		return str;
	}
	
	function testFun(json){
		for(var i in json) {
			document.write(i+":"+json[i]+"</br>");
			if(typeof json[i] == 'object'){
					testFun(json[i]);
			}
		}
	}

	function makeJson(str){
			
			var sendJson = Ext.JSON.decode(str);
			var temp={};
			var stemp={};
			var strr;
			temp.columModle = sendJson.columModle;
			stemp.type=sendJson.type;     //////////
			
			delete sendJson.columModle;
			
			str = Ext.JSON.encode(temp);
			str=unescape(str.replace(/\\/g, "%"));
			str = makeTextClean(str);
			
			var json = Ext.JSON.decode(str);
			
			
			strr = Ext.JSON.encode(stemp);
			strr = unescape(strr.replace(/\\/g, "%"));
			strr = makeTextClean(strr);
			var jsonx = Ext.JSON.decode(strr);
			
			var arr= new Array ();
			var arr1 = new Array();
			
			makeColumJson(json,arr,jsonx["type"]);
			
			var cols=makeJsonClean(arr);
			
			
			makeFieldsJson(json,arr1);
			var fieldsName=makeJsonClean(arr1);
		
			
			colsJson = Ext.JSON.decode(cols);
			fieldJson = Ext.JSON.decode(fieldsName);
			
			sendJson.columModle = colsJson.columModle;
			sendJson.fieldsNames = fieldJson.fieldsNames;
			var xixi= Ext.JSON.encode(sendJson);
				xixi = unescape(xixi.replace(/\\/g, "%"));
			//Ext.Msg.alert("xx",xixi);//console.log(sendJson.responseText);
			
			
			return sendJson;
			
	}