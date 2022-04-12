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



/**
 * block is a class which has an overridden
 * operator invoke function
 *
 *
 * **/

interface Block{
    operator fun invoke():String
}

var block = object:Block{
    override fun invoke(): String {
        return "g"
    }
}

block()



/**
 * Apply
 * always will return @this
 * the value of the original object never changes
 * provides null safety checks
 * **/
class User{
    var name:String?= null
}
var user = User()

val apply = user.apply {
    name = "Prasanth"
}

println(apply.name)
println(user.name)


/**
 * Let
 * can return any object
 * provides an it object which can be altered
 * provides null sfety
 *
 * **/

val let = user.let {
    it.name = "name"
    it.name.equals("")
}

println(user.name)
println(let)


/**
 * run
 * can return any object
 * provides a this object which can be altered
 * doesnt send a null object inside with the use of null safe check
 * **/
var user1:User?=user
val run = user1?.run {
    this.name = "username"
    this.name.equals("")
}

println(user.name)
println(run)



/**
 * WITH
 * can return any object
 * provides a this object which can be altered
 * sends a null value as it is to the scope
 * **/
var user2:User? = user
val with = with(user2) {
    this?.name = "username1"
    this?.name.equals("")
}

println(with)
println(user.name)



/**
 * ALSO
 * mainly used for chaining
 * always return the same object
 * it provide it as an object
 * it is null safe
 * **/

var user3 = user

val also = user3.also { it.name = "username3" }

println(user3.name)



