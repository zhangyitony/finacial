package test

class Post {
	int no;//编号木材0
	String postName;
	String unit//原来的jobtitle
	String operater
	int parentPost;//上级单位的编号，no
	
	static hasMany = [authoritys:Authority]
	static belongsTo = [role:Role,acount:Acount]

	static constraints = {
	}
	
	String toString(){
		return postName;
	}  
}
