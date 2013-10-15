/*
	�������ã�
	�Ӻ�̨JSON�ļ��л���е�JSON����
	����: 
	json:��̨���͵�json�ļ�
	arr :Array���ͣ���ʼֵΪ��
*/

function makeTextClean(str){
			str = str.replace(/\s/g,"");
			str= str.replace(/\[{/g,"{");
			str= str.replace(/},{/g,",");
			str= str.replace(/\]/g,"");
			return str;
	}
		
	function makeColumJson(json,arr){
		for(var i in json) {
			if(typeof json[i] == 'object'){
				if(i == "columModle"){
					arr.push("{\""+i+"\": [");
					makeColumJson(json[i],arr);
					arr.push("]}");
				}else {
					arr.push("{\"text\":\""+i+"\",\"columns\": [");
					makeColumJson(json[i],arr);
					arr.push("]}");
				}
			}else {
				
				arr.push("{\"text\":\""+json[i]+"\",\"dataIndex\":\""+i+"\",\"editor\":\"textfield\"}");
				//arr.push("{\"text\":\""+json[i]+"\",\"dataIndex\":\""+i+"\"}");
			}
		}
	}		
	/*
	����: 
	json:��̨���͵�json�ļ�
	arr :Array���ͣ���ʼֵΪ��
	*/
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
	/*������*/
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
			temp.columModle = sendJson.columModle;
			delete sendJson.columModle;
			
			str = Ext.JSON.encode(temp);
			str=unescape(str.replace(/\\/g, "%"));
			str = makeTextClean(str);
			var json = Ext.JSON.decode(str);
			
			var arr= new Array ();
			var arr1 = new Array();
			
			makeColumJson(json,arr);
			var cols=makeJsonClean(arr);
			//document.write(cols+"---this is cols</br>");
			
			makeFieldsJson(json,arr1);
			var fieldsName=makeJsonClean(arr1);
			//document.write(fieldsName+"this is fields</br>");
			
			colsJson = Ext.JSON.decode(cols);
			fieldJson = Ext.JSON.decode(fieldsName);
			
			sendJson.columModle = colsJson.columModle;
			sendJson.fieldsNames = fieldJson.fieldsNames;
			
			return sendJson;
	}