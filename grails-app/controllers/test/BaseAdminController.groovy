package test

import org.springframework.dao.DataIntegrityViolationException

class BaseAdminController {

	def beforeInterceptor = [action:this.&adminAuth];
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def adminIndex(){
		
	}
	private adminAuth(){
		println("in the admin auth");
		
		if(!(session.acount)||!(session.acount?.acountName.equals("admin"))){
			redirect(url:'/index.gsp')
			return false
		}
	}
}
