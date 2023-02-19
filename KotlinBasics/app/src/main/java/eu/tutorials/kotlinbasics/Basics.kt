package eu.tutorials.kotlinbasics



/* Safe cast and unsafe cast operator
fun main() {
    val location: Any = "Kotlin"
    val safeString: String? = location as? String
    val safeInt: Int? = location as? Int
    println(safeString)
    println(safeInt)
}
 */

/* Lambda
fun main() {
    // lambda
    val sum: (Int, Int) -> Int = { a:Int, b: Int -> a + b }
    //val sum = { a:Int, b:Int -> a+b }
    println(sum(34,5))
}
*/

/* *****
fun main() {
    val fruits = setOf("Orange", "Apple", "Grape", "Apple")
    println(fruits.toSortedSet())

    val newFruits = fruits.toMutableList()
    newFruits.add("Water Melon")
    newFruits.add("Pear")
    //println(newFruits.elementAt(4))

    val daysOfTheWeek = mapOf(1 to "Monday", 2 to "Tuesday", 3 to "Wednesday")
    //println(daysOfTheWeek[2])
    for(key in daysOfTheWeek.keys) {
        print(" $key is to ${daysOfTheWeek[key]}")
    }

    val fruitsMap = mapOf(1 to Fruit("Grape", 2.5), 2 to Fruit("Apple", 1.0))
    val newDaysOfWeek = daysOfTheWeek.toMutableMap()
    newDaysOfWeek[4] = "Thursday"
    newDaysOfWeek[5] = "Friday"

    println(newDaysOfWeek.toSortedMap())
}

data class Fruit(val name: String, val price: Double)
*/
/* *******
fun main() {
    val months = listOf("January", "February", "March")
    val anyTypes = listOf(1,2,3,true, false, "String")
    //println(anyTypes.size)
    //println(months[0])

    val additionMonths = months.toMutableList()
    val newMonths = arrayOf("April", "May", "June")
    additionMonths.addAll(newMonths)
    additionMonths.add("July")
    println(additionMonths)

    val days = mutableListOf<String>("Mon", "Tue", "Wed")
    days.add("Thu")
    days[2] = "Sunday"
    //days.removeAt(0)
    val removeList = mutableListOf<String>("Mon", "Wed")
    days.removeAll(removeList)
    println(days)
}
*/

/* *******
fun main() {
    //val numbers: IntArray = intArrayOf(1,2,3,4,5,6)
    //val numbers = intArrayOf(1,2,3,4,5,6)
    val numbers = arrayOf(1,2,3,4,5,6)

    //print(numbers.contentToString())
    for(i in 5 downTo 0) {
        numbers[i] = i
    }
    println("\nFinal values ${numbers.contentToString()}")

    val fruits = arrayOf(Fruit("Apple", 2.5), Fruit("Grape", 3.5))
    //println(fruits.contentToString())
    for(fruit in fruits) {
        println("${fruit.name}")
    }

    for(index in fruits.indices) {
        println("${fruits[index].name} is in index $index")
    }
}

data class Fruit(val name: String, val price: Double)
*/
/* ****
import kotlin.math.floor

fun main() {
    val stringList : List<String> = listOf("Denis", "Frank", "Michael", "Garry")
    val mixedTypeList : List<Any> = listOf("Denis", "31", 5, "BDay", 70.5, "weighs", "Kg")

    for(value in mixedTypeList) {
        when(value) {
            is Int -> println("Integer: '$value'")
            is Double -> println("Double: '$value' with Floor value ${floor(value)}")
            is String -> println("String: '$value' of length ${value.length} ")
            else -> println("Unknown Type")
        }
    }

    // Smart Cast
    val obj1: Any = "I have a dream"
    if(obj1 !is String) {
        println("Not a String")
    } else {
        println("Found a String of length ${obj1.length}")
    }

    // explicit (unsafe) casting using the "as" keyword - can go wrong
    val str1: String = obj1 as String
    println(str1.length)

    //val obj2: Any = 1337
    //val str2: String = obj2 as String
    //println(str2)

    // explicit (safe) casting using the as? keyword
    val obj3: Any = 1337
    val str3: String? = obj3 as? String // works
    println(str3) // prints null
}
*/

/* ***
abstract class Mammal(private val name: String, private val origin: String,
    private val weight: Double) {

    // abstract property (must be overwritten by subclasses
    abstract var maxSpeed: Double

    // abstract methods (must be implemented by subclasses)
    abstract fun run()
    abstract fun breath()

    // concrete (non abstract) method
    fun displayDetails() {
        println("Name: $name, Origin: $origin, Weight: $weight " +
                "Max speed: $maxSpeed")
    }
}

class Human(name: String, origin: String, weight: Double,
            override var maxSpeed: Double): Mammal(name, origin, weight) {

    override fun run() {
        println("Runs on two legs")
    }

    override fun breath() {
        println("Breathe through mouth or nose")
    }
}

class Elephant(name: String, origin: String, weight: Double,
            override var maxSpeed: Double): Mammal(name, origin, weight) {

    override fun run() {
        println("Runs on four legs")
    }

    override fun breath() {
        println("Breathe through the trunk")
    }
}

fun main() {
    val human = Human("Denis", "Russia", 70.0, 28.0)
    val elephant = Elephant("Rosy", "India", 5400.0, 25.0)

    human.run()
    elephant.run()

    human.breath()
    elephant.breath()
}
*/

/* ******
interface Drivable {
    val maxSpeed: Double
    fun drive(): String
    fun brake() {
        println("The drivable is braking")
    }
}

open class Car(override val maxSpeed: Double, val name: String,
               val brand: String): Drivable {
    open var range: Double = 0.0

    fun extendRange(amount: Double) {
        if(amount > 0) {
            range += amount
        }
    }

    //override fun drive(): String = "driving the interface drive"
    override fun drive(): String {
        return "driving the interface drive"
    }

    open fun drive(distance: Double) {
        println("Drove for $distance KM")
    }
}

class ElectricCar(maxSpeed: Double, name: String, brand: String, batteryLife: Double)
    : Car(maxSpeed, name, brand) {

    var chargerType = "Type1"
    override var range = batteryLife * 6

    override fun drive(distance: Double) {
        println("Drove for $distance KM on electricity")
    }

    override fun drive(): String {
        return "Drove for $range KM on electricity"
    }

    override fun brake() {
        super.brake()
        println("brake inside of electric car")
    }
}

fun main() {
    var audiA3 = Car(200.0,"A3", "Audi")
    var teslaS = ElectricCar(240.0, "S-Model", "Tesla", 85.0)
    teslaS.chargerType = "Type2"
    teslaS.extendRange(200.0)

    println(teslaS.drive())
    teslaS.brake()
    audiA3.brake()

    audiA3.drive(200.0)
    teslaS.drive(200.0)
}
*/
/* ******
data class User(val id: Long, var name: String)

fun main() {
    val user1 = User(1, "Denis")
    val user2 = User(1, "Michael")

    println(user1 == user2)

    println("User Details: $user1")

    val updatedUser = user1.copy(name="Dennis Panjuta")
    println(user1)
    println(updatedUser)

    println(updatedUser.component1()) // print 1
    println(updatedUser.component2()) // prints Dennis Panjuta

    val (id,name) = updatedUser
    println("id=$id, name=$name")
}
*/

/* **********************
fun main() {
    var myCar = Car()
    println("brand is : ${myCar.myBrand}")
    myCar.maxSpeed = 240
    println("Maxspeed is : ${myCar.maxSpeed}")
}

class Car() {
    lateinit var owner : String

    val myBrand: String = "BMW"
        // custom getter
    get() {
        return field.toLowerCase()
    }

    var maxSpeed: Int = 250
        //get() = field
        set(value) {
            field = if(value > 0) value else throw IllegalArgumentException("Maxspeed has to be positive")
        }

    var myModel : String = "M5"
        private set

    init {
        this.owner = "Frank"
    }
}
*/


/* **********
class Person(firstName: String = "John", lastName: String = "Doe") {
    // Member Variables - properties
    var age : Int? = null
    var hobby : String = "watch netflix"
    var firstName : String? = null

    init {
        this.firstName = firstName
        println("Initialized a new Person object with " +
                "firstname = $firstName and lastName = $lastName")
    }

    // member secondary constructor
    constructor(firstName: String, lastName: String, age: Int)
        : this(firstName, lastName) {
            this.age = age
        println("Initialized a new Person object with " +
                "firstname = $firstName, lastName = $lastName and age $age")
        }

    // member functions - methods
    fun stateHobby() {
        println("$firstName\'s hobby is $hobby")
    }
}

fun main() {
    var aleksi: Person = Person("Aleksi", "Khlebnikov", 31)
    var john: Person = Person()
    var johnPeterson = Person(lastName = "Peterson")

    aleksi.hobby = "to skateboard"
    aleksi.stateHobby()
}
*/


/* **************
fun main(){
    //var name: String = "Denis"
    // name = null -> compilation error
    var nullableName: String? = "Denis"
    nullableName = null

    //var len = name.length
    if(nullableName != null) {
        var len2 = nullableName.length
    } else {
        null
    }
    // above statement of if replacable by line under
    var len2 = nullableName?.length
    //println(nullableName?.lowercase())
    //nullableName?.let { println(it.length) }

    var name = nullableName ?: "Guest"
    println("name is $name")

    println(nullableName!!.toLowerCase())
}

fun avg(a: Double, b: Double): Double{
    return (a+b)/2
}

fun addUp(a: Int, b: Int) : Int{
    return a+b
}

fun myFunction() {
    println("Called from myFunction")
}


fun run() {
    // immutable variable
    // TODO: Add new functionality

    /*
    This
    is a
    comment
     */

    // type String
    val myName = "Denis"
    // type int
    var myAge = 31

    // integers
    var myByte: Byte = 13 // byte 8 bit
    val myShort: Short = 125    // short 16bit
    val myInt: Int = 123123123  // int 32 bit
    val myLong: Long = 1000012345677 // long (64 bit)

    // float numbers
    val myFloat: Float = 13.37F
    val myDouble: Double = 3.141567889456546546

    // booleans
    var isSunny: Boolean = true
    isSunny = false

    // characters
    val letterChar = 'A'
    val digitChar = '1'

    //Strings
    val myStr = "Helloo World"
    var firstCharInStr = myStr[0]
    var lastCharInStr = myStr[myStr.length - 1]

    print("First character " + firstCharInStr + "\n")
    println("Length of myStr is ${myStr.length}")

    var result = 5+3
    val a = 5.0
    val b = 3
    var resultDouble : Double
    resultDouble = a / b
    print(resultDouble)

    var height1 = 100
    var height2 = 120
    if (height1 > height2){
        println("height1 bigger")
    } else {
        println("height2 bigger")
    }

    var season = 3
    when(season) {
        1 -> println("Spring")
        2 -> println("Summer")
        3 -> {
            println("Fall")
            println("Autumn")
        }
        4 -> println("Winter")
        else -> println("Invalid Season")
    }

    var month = 3
    when(month) {
        in 3..5 -> println("Spring")
        in 6..8 -> println("Summer")
        in 9..11 -> println("Fall")
        12, 1, 2 -> println("Winter")
        else -> println("Invalid month")
    }

    var x : Any = 13.37
    when (x) {
        is Int -> println("$x an Int")
        is Double -> println("$x an Double")
        is String -> println("$x an String")
        else -> println("$x is none of the above")
    }

    var y = 1
    while(y <= 10) {
        print("$y ")
        ++y
    }
    println("\nwhile loop is done")

    y = 1
    do {
        print("$y ")
        y++
    } while(y<=10)
    println("\ndo..while done")

    for(num in 1..10) { // or for (num in 1 until 10) or for (num in 10 downTo 1 step 2)
        // another way for (i in 10.downTo(1).step(2))
        print("$num ")
    }
    println("\nfor done")

}
*/