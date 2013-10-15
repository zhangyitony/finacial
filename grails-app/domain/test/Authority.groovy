package test

class Authority {
	short authority
	static belongsTo = [post:Post, form:Form]
    static constraints = {
    }
}
