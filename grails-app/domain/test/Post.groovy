package test

class Post {
	String postName;
	String unit//ԭΪjobtitle
	String operater
	
	static hasMany = [authoritys:Authority]
	static belongsTo = [role:Role,acount:Acount]

	static constraints = {
	}
	
	String toString(){
		return postName;
	}
    
}
