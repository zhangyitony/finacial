package test



import org.junit.*
import grails.test.mixin.*

@TestFor(PlanTimeController)
@Mock(PlanTime)
class PlanTimeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/planTime/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.planTimeInstanceList.size() == 0
        assert model.planTimeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.planTimeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.planTimeInstance != null
        assert view == '/planTime/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/planTime/show/1'
        assert controller.flash.message != null
        assert PlanTime.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/planTime/list'

        populateValidParams(params)
        def planTime = new PlanTime(params)

        assert planTime.save() != null

        params.id = planTime.id

        def model = controller.show()

        assert model.planTimeInstance == planTime
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/planTime/list'

        populateValidParams(params)
        def planTime = new PlanTime(params)

        assert planTime.save() != null

        params.id = planTime.id

        def model = controller.edit()

        assert model.planTimeInstance == planTime
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/planTime/list'

        response.reset()

        populateValidParams(params)
        def planTime = new PlanTime(params)

        assert planTime.save() != null

        // test invalid parameters in update
        params.id = planTime.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/planTime/edit"
        assert model.planTimeInstance != null

        planTime.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/planTime/show/$planTime.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        planTime.clearErrors()

        populateValidParams(params)
        params.id = planTime.id
        params.version = -1
        controller.update()

        assert view == "/planTime/edit"
        assert model.planTimeInstance != null
        assert model.planTimeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/planTime/list'

        response.reset()

        populateValidParams(params)
        def planTime = new PlanTime(params)

        assert planTime.save() != null
        assert PlanTime.count() == 1

        params.id = planTime.id

        controller.delete()

        assert PlanTime.count() == 0
        assert PlanTime.get(planTime.id) == null
        assert response.redirectedUrl == '/planTime/list'
    }
}
