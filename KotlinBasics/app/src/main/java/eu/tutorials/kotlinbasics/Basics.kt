package eu.tutorials.kotlinbasics

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
