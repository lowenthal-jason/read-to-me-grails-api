package read.to.me.grails.api


import grails.rest.*
import grails.rest.RestfulController
import grails.converters.*

class BookController extends RestfulController {
    static responseFormats = ['json','xml']
    BookController(){
        super(Book)
    }
}
