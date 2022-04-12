/**
 * Kotlin Generics
 * mostly similar to java
 * it can allow type parameters
 *
 *
 * **/


interface Callback<T>{
    fun success(t:T)
}

class CallbackImpl:Callback<String>{
    override fun success(t: String) {
        println(t)
    }
}


var callback = CallbackImpl()
callback.success("hello")
var callback2 = object:Callback<Int>{
    override fun success(t: Int) {
        println(t.toString())
    }
}

callback2.success(Integer.valueOf(12))


/**
 * Type Variance
 * Covariant 	If it accepts subtypes but not supertypes eg <? extend User> in java
 * Contravariant	If it accepts supertypes but not subtypes <? super User> in java
 * Bivariant	If it accepts both supertypes and subtypes
 * Invariant	 If it accepts neither supertypes nor subtypes.
 *
 *
 * wildcards are also present in kotlin
 * there are two keywords in and out
 *
 * **/
open class Base{
    open fun print(){
        println("Base")
    }
}
class Child:Base(){
    override fun print(){
        println("Child")
    }
}
class Super<in T>(){

}


var superObj = Super<Base>()
var dependentObj = Super<Child>()
var childObj:Super<Child> = superObj
//var superiorObj:Super<Base> = dependentObj

//------

var arraylistany:ArrayList<in String> = ArrayList<Any>()
var arraylistany:ArrayList<out Any> = ArrayList<String>()
var arraylistany:ArrayList<*> = ArrayList<String>()



/**
 *
 * **/