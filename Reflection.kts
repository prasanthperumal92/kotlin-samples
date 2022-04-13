import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.memberProperties

/**
 * Reflection
 * It is the ability to check the class properties and methods in runtime.
 * It uses kotlin reflect.jvm for interoperability between
 * The reflect framework provides with certain classes like
 * KClass
 * KFunction which is a part of KCallable
 * KProperty
 *
 * **/

var c: KClass<String> = String::class
c.constructors
c.nestedClasses

class Box{
    var isOpen:Boolean= false
     var height:Double=0.0
     var width:Double=0.0
    lateinit var label:String
    class Lid{

    }

    fun print(){
        println("this is a box")
    }
}

var boxClass: KClass<Box> = Box::class
boxClass.nestedClasses.stream().forEach { println(it.simpleName) }
boxClass.memberProperties.stream().forEach {property: KProperty1<Box,*> ->
    println(property.name)
    println(property.isLateinit)
}

val box = boxClass.createInstance()
box.print()


fun isOdd(number:Int):Boolean{
    return number%2!=0
}
// we can refer a function using the scope reference
var isMyNumberOdd = ::isOdd

println(::box.name)
println(::box.get().print())







