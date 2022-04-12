/**
 *runs in the context/scope of an object
 *the default scope functions are let, run, with , apply and also
 * these are basically functions which accept Block and return the result object
 *
 * **/
interface FullName{
    fun getFullName():String
}
class Person{
    var firstName="Prasanth";
    var lastName="Perumal"

    fun getFullName(block: Person.() -> String):String{
        return block()
    }
}


Person().getFullName (){
    return@getFullName this.firstName+this.lastName
}