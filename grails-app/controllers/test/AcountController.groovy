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
        [acountInstanceList: Acount.list(params), acountInstanceTotal: Acount.count()]
    }

    def create() {
        [acountInstance: new Acount(params)]
    }

    def save() {
        def acountInstance = new Acount(params)
        if (!acountInstance.save(flush: true)) {
            render(view: "create", model: [acountInstance: acountInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'acount.label', default: 'User'), acountInstance.id])
        redirect(action: "show", id: acountInstance.id)
    }

    def show(Long id) {
        def acountInstance = Acount.get(id)
        if (!acountInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'acount.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        [acountInstance: acountInstance]
    }

    def edit(Long id) {
        def acountInstance = Acount.get(id)
        if (!acountInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'acount.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        [acountInstance: acountInstance]
    }

    def update(Long id, Long version) {
        def acountInstance = Acount.get(id)
        if (!acountInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'acount.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (acountInstance.version > version) {
                acountInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'acount.label', default: 'User')] as Object[],
                          "Another acount has updated this User while you were editing")
                render(view: "edit", model: [acountInstance: acountInstance])
                return
            }
        }

        acountInstance.properties = params

        if (!acountInstance.save(flush: true)) {
            render(view: "edit", model: [acountInstance: acountInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'acount.label', default: 'User'), acountInstance.id])
        redirect(action: "show", id: acountInstance.id)
    }

    def delete(Long id) {
        def acountInstance = Acount.get(id)
        if (!acountInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'acount.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        try {
            acountInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'acount.label', default: 'User'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'acount.label', default: 'User'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def register = {}
	
	/**
	 * chen modify
	 * acount login.undone
	 */
	def login = {
		def acount = Acount.findByAcountNameAndPassword(params.acountname,params.password);
		def tmp;
		if(acount){
			session.acountId = acount.id;
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
		
//		println("login acountname:"+params.acountname+"|password:"+params.password);
		
		
	}
	
	def logout = {
		session.invalidate()
		redirect(action:'login')
	}
	
	def auth(){
		if(!session.acountId){
			redirect(action:'login',controller:'acount')
			return false
		}
	}
	
	def beforeInterceprtor = [action:this.&auth,expect:['register','save','login','loginCheck','logout']]
	
}
