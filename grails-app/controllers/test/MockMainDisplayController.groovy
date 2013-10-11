package test

import grails.converters.JSON
import java.util.Date
import org.springframework.dao.DataIntegrityViolationException

class MockMainDisplayController {
	
	def beforeInterceptor = [action:this.&auth];
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def showMain(){
		//鏂规硶鎵ц瀹屾瘯鍚庝細灏濊瘯杩涘叆-first->showMain.jsp -then->showMain.gsp,璁ㄨ涓婚〉闈㈡槸鍚﹂渶瑕佹敼鍚嶇О锛堬紵锛夈�
		
	}
	
	def getShouldFillTables(){
		Acount loginAcount = session.acount;
//		def temp = PlanTime.findByAcountId(loginAcount.id);
//		def aa = Form.get(temp.tableId);
//		
		def results = PlanTime.findAll("\
		from PlanTime as p, \
		     Form as f \
		where p.tableId = f.no and p.acountId = ?", [(int)loginAcount.id])
//TODO:	将results按协议组成有效json；	
		def map=[:];
		for(i in 0..results.size()-1)
		{
			def ss = results.get(i);
			println ss[0].tableId;
			println ss[1].name;
			map.putAt("${ss[0].tableId}",ss[1].name)
		}
		
		render map as JSON;
	}
	
	private auth(){
		println("in the auth");
		if(!session.acount){
			redirect(url:'/index.gsp')
			return false
		}
	}
	
	
	
	
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
