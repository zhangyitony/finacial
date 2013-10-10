package test

class Authority {
	short authority
	static belongsTo = [acount:Acount, form:Form]
    static constraints = {
    }
}
