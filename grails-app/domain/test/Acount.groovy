package test

class Acount {
	String acountName
	String password
	
	
	static hasMany = [posts:Post]

	
    static constraints = {
    }
	
	String toString(){
		return acountName;
	}
}
