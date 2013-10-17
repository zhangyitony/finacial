package cn.gov.xaczj;

import groovy.util.Expando;

class TableDynamic {
	Map entityName;//tableName:entityname in Hibernate，such as table1,table2;chTableName:table 's real name
	String cycle;
	Expando table;//store table custom fileds
	Expando operate;//store relationship between some fileds
	TableDynamic() {
		this.table = new Expando();
		this.operate = new Expando();
	}
}
