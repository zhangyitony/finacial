package test

import org.springframework.dao.DataIntegrityViolationException

class PlanTimeController extends BaseAdminController {

	def beforeInterceptor = [action:this.&adminAuth];
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [planTimeInstanceList: PlanTime.list(params), planTimeInstanceTotal: PlanTime.count()]
    }

    def create() {
        [planTimeInstance: new PlanTime(params)]
    }

    def save() {
        def planTimeInstance = new PlanTime(params)
        if (!planTimeInstance.save(flush: true)) {
            render(view: "create", model: [planTimeInstance: planTimeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'planTime.label', default: 'PlanTime'), planTimeInstance.id])
        redirect(action: "show", id: planTimeInstance.id)
    }

    def show(Long id) {
        def planTimeInstance = PlanTime.get(id)
        if (!planTimeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'planTime.label', default: 'PlanTime'), id])
            redirect(action: "list")
            return
        }

        [planTimeInstance: planTimeInstance]
    }

    def edit(Long id) {
        def planTimeInstance = PlanTime.get(id)
        if (!planTimeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'planTime.label', default: 'PlanTime'), id])
            redirect(action: "list")
            return
        }

        [planTimeInstance: planTimeInstance]
    }

    def update(Long id, Long version) {
        def planTimeInstance = PlanTime.get(id)
        if (!planTimeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'planTime.label', default: 'PlanTime'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (planTimeInstance.version > version) {
                planTimeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'planTime.label', default: 'PlanTime')] as Object[],
                          "Another user has updated this PlanTime while you were editing")
                render(view: "edit", model: [planTimeInstance: planTimeInstance])
                return
            }
        }

        planTimeInstance.properties = params

        if (!planTimeInstance.save(flush: true)) {
            render(view: "edit", model: [planTimeInstance: planTimeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'planTime.label', default: 'PlanTime'), planTimeInstance.id])
        redirect(action: "show", id: planTimeInstance.id)
    }

    def delete(Long id) {
        def planTimeInstance = PlanTime.get(id)
        if (!planTimeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'planTime.label', default: 'PlanTime'), id])
            redirect(action: "list")
            return
        }

        try {
            planTimeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'planTime.label', default: 'PlanTime'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'planTime.label', default: 'PlanTime'), id])
            redirect(action: "show", id: id)
        }
    }
}
