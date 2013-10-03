package test

import org.springframework.dao.DataIntegrityViolationException
import cn.gov.xaczj.TableDynamic
import grails.converters.*
import groovy.json.*

import java.util.Map.Entry

class AcountController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [userInstanceList: Acount.list(params), userInstanceTotal: Acount.count()]
    }

    def create() {
        [userInstance: new Acount(params)]
    }

    def save() {
        def userInstance = new Acount(params)
        if (!userInstance.save(flush: true)) {
            render(view: "create", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(action: "show", id: userInstance.id)
    }

    def show(Long id) {
        def userInstance = Acount.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        [userInstance: userInstance]
    }

    def edit(Long id) {
        def userInstance = Acount.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        [userInstance: userInstance]
    }

    def update(Long id, Long version) {
        def userInstance = Acount.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (userInstance.version > version) {
                userInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'user.label', default: 'User')] as Object[],
                          "Another user has updated this User while you were editing")
                render(view: "edit", model: [userInstance: userInstance])
                return
            }
        }

        userInstance.properties = params

        if (!userInstance.save(flush: true)) {
            render(view: "edit", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(action: "show", id: userInstance.id)
    }

    def delete(Long id) {
        def userInstance = Acount.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        try {
            userInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def register = {}
	
	/**
	 * chen modify
	 * user login.undone
	 */
	def login = {
		def acount = Acount.findByAcountNameAndPassword(params.acountname,params.password);
		def tmp;
		if(acount){
			session.userId = acount.id;
			flash.message = message(code:'login.success',args:[acount.acountName]);
			println("login success!");
//			redirect(url:"/main1.gsp");
			tmp =[success:true]
			render tmp as JSON;
		}else{
			flash.message = message(code:'login.failed');
			println("login failed!");
			tmp =[success:false]
			render tmp as JSON;
		}
		
//		println("login username:"+params.username+"|password:"+params.password);
		
		
	}
	
	def logout = {
		session.invalidate()
		redirect(action:'login')
	}
	
	def auth(){
		if(!session.userId){
			redirect(action:'login',controller:'acount')
			return false
		}
	}
	
	def beforeInterceprtor = [action:this.&auth,expect:['register','save','login','loginCheck','logout']]
	
}
