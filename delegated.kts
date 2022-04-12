import java.security.acl.Owner
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

//delegated property
// ability to pass the responsibility to another class or method.
//property will be computed only on first access and then cached
//The first main use of delegated property is lazy initialization


class LazyLoader {
    // this can also be initialized to null
   private  lateinit var lazyLoader:String

    fun getValue():String{
        if (!this::lazyLoader.isInitialized){
            lazyLoader = "Lazzy"
        }
        return lazyLoader
    }

}
//the getter and setter is created by the lamda function
//if the value should be accessible  by all threads we can provide
// if you need the access to be sync|| if access is simulataneous|| only one thread is going to access it
//LazyThreadSafetyMode.SYNCHRONIZED || LazyThreadSafetyMode.PUBLICATION || LazyThreadSafetyMode.NONE
class LazyLoaderBy{
    private val lazyloader by lazy(LazyThreadSafetyMode.NONE){
        "Lazzy using by"
    }

    fun getValue():String{
        return lazyloader
    }
}


//lazyloader
LazyLoader().getValue()
LazyLoaderBy().getValue()




//-------------------------------
//Next is Delegate.Observable
//whenever there is a change in value then the lamda function is executed
//we would be able to achieve this using setter
class ObSetter{
    var count =0

    fun increaseCount(){
        count++
        printCount()
    }

    private fun printCount(){
        println("value of count is $count")
    }
}

// it also helps you to check if the new value is in line with the old value
class ObSetterBy{
    val observable = Delegates.observable(0) { i, j, k ->
        println(k)
    }
    var count by observable
    fun increaseCount(){
        count++
    }

}


val obSetter = ObSetter()
println(obSetter.count)
obSetter.increaseCount()


val obSetterBy = ObSetterBy()
println(obSetterBy.count)
obSetterBy.increaseCount()




//---------------------------------
//Storing objects in map
/**
 * if you prefer to store the values in a map instead of creating variable then this is very useful
 * we can use this when we has a json structure which we can use
 * **/

class User{
    private var map =HashMap<String,String>()

    fun getName(): String?{
        return map["name"]
    }
    fun setName(name:String){
        map["name"] = name
    }

    
}


class UserBy{
    private var map = HashMap<String,String>()
    var name by map
}


val user = User()
user.setName("prasanth")
println(user.getName())


val userBy=UserBy()
userBy.name = "prasanth"
println(userBy.name)


/**
 * -----------------------------------------
 * custom defined delegates
 * any class which has getValue and setValue overridden methods are delegates
 *
 *
 * **/
class UserDelegate{
    var name:String ="prasanth"

    operator fun getValue(thisRef: Login, property: KProperty<*>): String {
        if (property.name=="name"){
            println("name")
        }
        return name
    }
    operator fun setValue(thisRef: Login, property: KProperty<*>, value: String) {
        name = value
    }
}

class Login{
    private var user:UserDelegate = UserDelegate()
    var name by user
}

var login = Login()
println(login.name)