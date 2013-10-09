package test

import org.springframework.dao.DataIntegrityViolationException

class MockMainDisplayController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def showMain(){
		//方法执行完毕后会尝试进入-first->showMain.jsp -then->showMain.gsp,讨论主页面是否需要改名称（？）。
		[userid:session.uerId]
	}
	
	def private auth(){
		if(!session.userId){
			redirect(action:'login',controller:'acount')
			return false
		}
	}
	
	def beforeInterceprtor = [action:this.&auth,expect:['someAction']]
	
	
//    def index() {
//        redirect(action: "list", params: params)
//    }
//
//    def list(Integer max) {
//        params.max = Math.min(max ?: 10, 100)
//        [mockMainDisplayInstanceList: MockMainDisplay.list(params), mockMainDisplayInstanceTotal: MockMainDisplay.count()]
//    }
//
//    def create() {
//        [mockMainDisplayInstance: new MockMainDisplay(params)]
//    }
//
//    def save() {
//        def mockMainDisplayInstance = new MockMainDisplay(params)
//        if (!mockMainDisplayInstance.save(flush: true)) {
//            render(view: "create", model: [mockMainDisplayInstance: mockMainDisplayInstance])
//            return
//        }
//
//        flash.message = message(code: 'default.created.message', args: [message(code: 'mockMainDisplay.label', default: 'MockMainDisplay'), mockMainDisplayInstance.id])
//        redirect(action: "show", id: mockMainDisplayInstance.id)
//    }
//
//    def show(Long id) {
//        def mockMainDisplayInstance = MockMainDisplay.get(id)
//        if (!mockMainDisplayInstance) {
//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mockMainDisplay.label', default: 'MockMainDisplay'), id])
//            redirect(action: "list")
//            return
//        }
//
//        [mockMainDisplayInstance: mockMainDisplayInstance]
//    }
//
//    def edit(Long id) {
//        def mockMainDisplayInstance = MockMainDisplay.get(id)
//        if (!mockMainDisplayInstance) {
//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mockMainDisplay.label', default: 'MockMainDisplay'), id])
//            redirect(action: "list")
//            return
//        }
//
//        [mockMainDisplayInstance: mockMainDisplayInstance]
//    }
//
//    def update(Long id, Long version) {
//        def mockMainDisplayInstance = MockMainDisplay.get(id)
//        if (!mockMainDisplayInstance) {
//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mockMainDisplay.label', default: 'MockMainDisplay'), id])
//            redirect(action: "list")
//            return
//        }
//
//        if (version != null) {
//            if (mockMainDisplayInstance.version > version) {
//                mockMainDisplayInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
//                          [message(code: 'mockMainDisplay.label', default: 'MockMainDisplay')] as Object[],
//                          "Another user has updated this MockMainDisplay while you were editing")
//                render(view: "edit", model: [mockMainDisplayInstance: mockMainDisplayInstance])
//                return
//            }
//        }
//
//        mockMainDisplayInstance.properties = params
//
//        if (!mockMainDisplayInstance.save(flush: true)) {
//            render(view: "edit", model: [mockMainDisplayInstance: mockMainDisplayInstance])
//            return
//        }
//
//        flash.message = message(code: 'default.updated.message', args: [message(code: 'mockMainDisplay.label', default: 'MockMainDisplay'), mockMainDisplayInstance.id])
//        redirect(action: "show", id: mockMainDisplayInstance.id)
//    }
//
//    def delete(Long id) {
//        def mockMainDisplayInstance = MockMainDisplay.get(id)
//        if (!mockMainDisplayInstance) {
//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mockMainDisplay.label', default: 'MockMainDisplay'), id])
//            redirect(action: "list")
//            return
//        }
//
//        try {
//            mockMainDisplayInstance.delete(flush: true)
//            flash.message = message(code: 'default.deleted.message', args: [message(code: 'mockMainDisplay.label', default: 'MockMainDisplay'), id])
//            redirect(action: "list")
//        }
//        catch (DataIntegrityViolationException e) {
//            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'mockMainDisplay.label', default: 'MockMainDisplay'), id])
//            redirect(action: "show", id: id)
//        }
//    }
}
