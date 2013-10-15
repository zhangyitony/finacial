package test

class Role {
	String name
	
	static hasMany = [posts:Post,registrations:Registration]	
    static constraints = {
    }	
	String toString(){
		return name
	}
}