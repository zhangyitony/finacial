package test

class Acount {
	String acountName
	String password
	int parentAcount
	
	static hasMany = [posts:Post]

	
    static constraints = {
    }
	
	String toString(){
		return acountName;
	}
}
