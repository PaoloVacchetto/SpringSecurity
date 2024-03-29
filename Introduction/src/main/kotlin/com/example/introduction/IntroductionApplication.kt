package com.example.introduction

import org.springframework.boot.autoconfigure.SpringBootApplication
import java.awt.Point
import kotlin.properties.Delegates

@SpringBootApplication
class IntroductionApplication

data class Point (var x: Int, var y: Int)
fun main(args: Array<String>) {
    //runApplication<IntroductionApplication>(*args)
    println("Hello World!")

    nullableType("ehi")
    collectionTest()
    println(describeNumber(10))
    loop()
    val s = Segment(1,2,3,4);
    s.nome = "ciao";
    s.cognome = "peppo";
    println("${s.nome} , ${s.cognome}, ${s.samantha}");
    s.samantha = "Vacchetto";

    MySingleton.increment();
    println(MySingleton.counter);
    MySingleton.increment();

    println(MySingleton.counter);
    s.second()

    val p1 = Point(1,1);
    val p2 = Point(1,1);

    println("${p1 == p2}")

    println(getSuccessfulCode(HttpStatusCode.OK))

}

fun Segment.second() {
    println("extension functions")
}

fun describeNumber(num:Int): String {
    return when (num) {
        0 -> "Zero"
        1-> "One"
        else -> "Other"
    }
}
fun nullableType(x : String?) {

    var a: String = "abc"
    val b:String?
    var c:String? = null
//    c = "a"

    println(c)
    b = null;
    if (x !== null) {
        val len = x.length
    }


    println(b)
    val lenc = c?.length

    println(lenc)
    println(lenc)
    c = "ehi"

    val d = c ?: "default"

    println(d)

}

fun collectionTest(){

    val readOnlyShapes = listOf("triangle", "square", "circle");

    println(readOnlyShapes)


    val shapes = mutableListOf("triangle", "square", "base" )
    shapes.add("pentagon")
    shapes.remove("triangle")
    println(shapes)

    //same thing with setOf and MutableSetOf
    //every declaration of lists can be done specifying the type of the list
    // or letting the type inference to understand by itself the type

    val readOnlyFruit = setOf("apple", "banana", "cherry", "cherry")
    println(readOnlyFruit);

    //map -> "key" to "value"

    val readOnlyMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 200 )
    println(readOnlyMenu)


    val specialMap = mapOf<Int,Int>(20 to 20, 10 to 10 )

    println(specialMap)


}

fun loop() {
    val iter = intArrayOf(1,2,3,4,8,16,32,64).iterator();
    for (item in iter) println(item);

    val data = intArrayOf(1,2,3,4,8,16,32,64);
    for ((index,value) in data.withIndex())
        println("data[$index] = $value")

    for (i in 1..10) println(i)
}

class Segment (val start: Point, val end: Point) {



    constructor(x1 : Int, y1 : Int , x2: Int, y2: Int) : this (Point(x1, y1) , Point(x2,y2)) {
        println(" secondary constructor");
    }

    constructor() : this (Point(0,0), Point(0,0)) {
        println("third constructor");
    }

     var nome: String? = null
         get() = field.toString()
        set(value:String?) { field = "$value ecco qua " }


    lateinit var cognome : String;

    val lazyValue : String by lazy {
        "String lazy"
    }

    var samantha : String by Delegates.observable("<Iacocca>") {
        prop, old, new -> println("$old -> $new")
    };

    init {
        println("this is the init block")
        nome = "ciao";

    }




}


object MySingleton  {
    private var _counter = 0
    fun increment() {++ _counter}
    var counter = _counter;
}

open class Rectangle (var w: Double, var h : Double) {
    open fun draw() {
        println("sto disegnando...")
    }
}

interface Polygon {
    fun area (): Double
}

class Square (l : Double ) : Rectangle(l,l), Polygon {
    override fun draw() {
        println("disegno quadraro...")
    }

    override fun area() = w * h;
}


enum class HttpStatusCode ( val value :Int) {
    OK(200), CREATED(201), NOT_FOUND(404), ACCESS_DENIED(403), INTERNAL_SERVER_ERROR(500)
}

fun getSuccessfulCode(code: HttpStatusCode) : Int? = when (code) {
    HttpStatusCode.OK -> code.value
    HttpStatusCode.ACCESS_DENIED -> null
    HttpStatusCode.INTERNAL_SERVER_ERROR-> null
    HttpStatusCode.CREATED-> code.value
    HttpStatusCode.NOT_FOUND -> null
}
