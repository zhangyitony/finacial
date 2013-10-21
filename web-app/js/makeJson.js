
Ext.define('Ext.form.field.dec', {
    extend:'Ext.form.field.Number',
    alias: 'widget.decnum',
    alternateClassName: ['Ext.form.decnum'],
    decimalPrecision : 8
})
Ext.define('Ext.form.field.itg', {
    extend:'Ext.form.field.Number',
    alias: 'widget.itgnum',
    alternateClassName: ['Ext.form.itgnum'],
    allowDecimals : false
})
    

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
		if(i.indexOf('level') != -1){
			continue;
		}
		if(i.indexOf('ap_proj_name')!= -1){
			arr.push("{\"text\":\""+json[i]+"\",\"locked\": true,\"dataIndex\":\""+i+"\",\"editor\":\"textfield\",\"align\":\"center\",\"width\":150}");
			continue;
		}
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
					
					arr.push("{\"text\":\""+json[i]+"\",\"dataIndex\":\""+i+"\",\"editor\":\"decnum\",\"align\":\"center\",\"width\":150}");
				}
				else if(i==j &&jsonx[j]=="string"){
					
					arr.push("{\"text\":\""+json[i]+"\",\"dataIndex\":\""+i+"\",\"editor\":\"textfield\",\"align\":\"center\",\"width\":150}");
				}
				else if(i==j &&jsonx[j]=="calendar_date"){
					
					arr.push("{\"text\":\""+json[i]+"\",\"dataIndex\":\""+i+"\",\"editor\":\"datefield\",\"align\":\"center\",\"width\":100}");
				}
				else if(i==j &&jsonx[j]=="integer"){
					
					arr.push("{\"text\":\""+json[i]+"\",\"dataIndex\":\""+i+"\",\"editor\":\"itgnum\",\"align\":\"center\",\"width\":80}");
				}
   			 }
		}
	}
}

function makeColumJsonTest(json,arr,jsonx){
	for(var i in json) {
		if(i.indexOf('level') != -1){
			arr.push("{\"text\":\""+json[i]+"\",\"dataIndex\":\""+i+"\",\"editor\":\"combo\",\"align\":\"center\",\"width\":150}");
			continue;
		}
		if(i.indexOf('ap_proj_name')!= -1){
			arr.push("{\"text\":\""+json[i]+"\",locked: true,\"dataIndex\":\""+i+"\",\"editor\":\"textfield\",\"align\":\"center\",\"width\":150}");
			alert("in it");
			continue;
		}
		if(typeof json[i] == 'object'){
			if(i == "columModle"){
				arr.push("{\""+i+"\": [");
				makeColumJsonTest(json["columModle"],arr,jsonx);
				arr.push("]}");
			}else {
				arr.push("{\"text\":\""+i+"\",\"columns\": [");
				makeColumJsonTest(json[i],arr,jsonx);
				arr.push("]}");
			}
		}else 
		{
   			 for(var j in jsonx){
   				
				if( i==j &&jsonx[j]=="big_decimal"){
					
					arr.push("{\"text\":\""+json[i]+"\",\"dataIndex\":\""+i+"\",\"editor\":\"decnum\",\"align\":\"center\",\"width\":150}");
				}
				else if(i==j &&jsonx[j]=="string"){
					
					arr.push("{\"text\":\""+json[i]+"\",\"dataIndex\":\""+i+"\",\"editor\":\"textfield\",\"align\":\"center\",\"width\":150}");
				}
				else if(i==j &&jsonx[j]=="calendar_date"){
					
					arr.push("{\"text\":\""+json[i]+"\",\"dataIndex\":\""+i+"\",\"editor\":\"datefield\",\"align\":\"center\",\"width\":100}");
				}
				else if(i==j &&jsonx[j]=="integer"){
					
					arr.push("{\"text\":\""+json[i]+"\",\"dataIndex\":\""+i+"\",\"editor\":\"itgnum\",\"align\":\"center\",\"width\":80}");
				}
   			 }
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
			console.log(i+":"+json[i]);
			if(typeof json[i] == 'object'){
					testFun(json[i]);
			}
		}
	}
	//得到分组信息的函数
	function getLevels(json){
		var arr=new Array();
		for(var i in json.columModle){
			if(i.indexOf('level') != -1){
				arr.push(i);
			}
		}
		return arr;
	}

	function makeJson(str){
			
			var sendJson = Ext.JSON.decode(str);
			var temp={};
			var stemp={};
			var strr;
			var addLineColsJson = {};
			temp.columModle = sendJson.columModle;	
			stemp.type=sendJson.type;     //////////
			
			delete sendJson["columModle"];
			
			str = Ext.JSON.encode(temp);
			str=unescape(str.replace(/\\/g, "%"));
			str = makeTextClean(str);
			
			var json = Ext.JSON.decode(str);
			var levelArr = getLevels(json);
			
			strr = Ext.JSON.encode(stemp);
			strr = unescape(strr.replace(/\\/g, "%"));
			strr = makeTextClean(strr);
			var jsonx = Ext.JSON.decode(strr);
			
			var arr= new Array ();
			var arr1 = new Array();
			var arr2 = new Array();
			makeColumJson(json,arr,jsonx["type"]);
			console.log(arr);
			
			makeColumJsonTest(json,arr2,jsonx["type"]);
			
			var cols=makeJsonClean(arr);
			var cols1 = makeJsonClean(arr2);
			
			makeFieldsJson(json,arr1);
			
			var fieldsName=makeJsonClean(arr1);
			
			var colsJson = Ext.JSON.decode(cols);
			var colsJson1 = Ext.JSON.decode(cols1);
			
			fieldJson = Ext.JSON.decode(fieldsName);
			
			sendJson.columModle1 = colsJson1.columModle;
			sendJson.columModle = colsJson.columModle;
			sendJson.fieldsNames = fieldJson.fieldsNames;
			sendJson.levelArr = levelArr;
			
			return sendJson;
	}