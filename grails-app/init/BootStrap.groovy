import read.to.me.grails.api.Book
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->

        def result = '################## running in UNCLEAR mode.'
        println "Application starting ... "
        switch (Environment.current) {
            case Environment.DEVELOPMENT:
                result = 'now running in DEV mode.'
                seedTestData()
                break;
            case Environment.TEST:
                result = 'now running in TEST mode.'
                break;
            case Environment.PRODUCTION:
                result = 'now running in PROD mode.'
                seedProdData()
                break;
        }
        println "current environment: $Environment.current"
        println "$result"
    }

    def destroy = {
        println "Application shutting down... "
    }

    private void seedTestData() {
        def book = null
        println "Start loading books into database"
        book = new Book(id: 1, title: "Mr. Brown Can Moo", author: "Dr. Seuss")
        assert book.save(failOnError: true, flush: true, insert: true)
        book.errors = null
        book = new Book(id: 2, title: "The Cat In The Hat", author: "Dr. Seuss")
        assert book.save(failOnError: true, flush: true, insert: true)
        book.errors = null
        book = new Book(id: 1, title: "Peek-A-Who", author: "Who")
        assert book.save(failOnError: true, flush: true, insert: true)
        book.errors = null
    }
}
