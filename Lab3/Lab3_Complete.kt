/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */


/* // 1. VARIABLES AND BASIC OPERATIONS 
fun main() {
    val a = 5
    val b = 6
    println(a + b)
    var c = a + b
    println("Using concatenation: The result of " + a + " + " + b + " = " + c)
    println("Using string templates: The result of $a + $b = $c")
    c++
    println("The value of incremented c is $c")
    
    // Test con val 
    val d = 10
    // d = 11 // Esto causaría error porque val es inmutable
    
    // Reading input 
    // val input = readln() // En REPL se asigna manual como pide el PDF
    val input = "5"
    println("Input: $input")
}
*/

/*
// 2. CONTROL FLOW - CALCULATOR, POWER, FACTORIAL 
fun main() {
    // Para cumplir con el punto 3.4 (Looped calculator)
    var continueLoop = true
    while (continueLoop) {
        val num1 = 5.0
        val num2 = 3.0
        val operator = "^" // Cambiar para probar +, -, *, /, ^, !
        
        if (operator == "exit") {
            continueLoop = false
        } else {
            val result = when (operator) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0.0) num1 / num2 else "Error"
                "^" -> powerFor(num1, num2.toInt())
                "!" -> factorial(num1.toInt())
                else -> "Invalid"
            }
            println("Output: $result")
            continueLoop = false // Simulación de una vuelta para REPL
        }
    }
}

fun powerFor(base: Double, exp: Int): Double {
    var res = 1.0
    for (i in 1..exp) res *= base
    return res
}

fun powerWhile(base: Double, exp: Int): Double {
    var res = 1.0
    var i = 0
    while (i < exp) {
        res *= base
        i++
    }
    return res
}

fun powerRepeat(base: Double, exp: Int): Double {
    var res = 1.0
    repeat(exp) { res *= base }
    return res
}

fun factorial(n: Int): Long {
    var res = 1L
    for (i in 1..n) res *= i
    return res
}
*/

/*
// 3. FIBONACCI, PYRAMID, REVERSE STRING 
fun main() {
    // Fibonacci 
    fib(7)
    
    // Pyramid 
    printPyramid(5)
    
    // Reverse String 
    println(reverseString("hello"))
}

fun fib(n: Int) {
    var a = 1
    var b = 1
    repeat(n) {
        print("$a ")
        val next = a + b
        a = b
        b = next
    }
    println()
}

fun printPyramid(n: Int) {
    for (i in n downTo 1) {
        for (j in 1..i) print("*")
        println()
    }
}

fun reverseString(s: String): String {
    var res = ""
    for (i in s.length - 1 downTo 0) {
        res += s[i]
    }
    return res
}
*/

/*
// 4. ARRAYS AND SORTING 
fun main() {
    val names = arrayOf("Anna", "John", "Mark")
    for (name in names) println(name)
    for (i in names.indices) println("$i: ${names[i]}")
    
    var longest = ""
    for (name in names) {
        if (name.length > longest.length) longest = name
    }
    println("Longest: $longest")

    // Sorting (4.5)
    val numbers = IntArray(100) { (1..1000).random() }
    bubbleSort(numbers)
    println("Sorted array: ${numbers.joinToString()}")
}

fun bubbleSort(arr: IntArray) {
    for (i in 0 until arr.size - 1) {
        for (j in 0 until arr.size - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}
*/

// 5. CLASSES AND OBJECTS 
fun main() {
    val myDog = Dog("Puffy", 6)
    val myFish = Fish("Nemo", 1)
    
    println(myDog.toString())
    myDog.move()
    
    println(myFish.toString())
    myFish.move()
    
    // Polymorphism test 
    val animal: Animal = Fish("Goldie", 2)
    animal.move() // Executes Fish.move() due to override
}

open class Animal(val name: String, val age: Int, val species: String) {
    open fun move() {
        println("Moving...")
    }
    
    override fun toString(): String {
        return "Hi. I'm a $species. I'm $age years old and my name is $name."
    }
}

class Fish(name: String, age: Int) : Animal(name, age, "fish") {
    override fun move() {
        println("swimming")
    }
}

class Dog(name: String, age: Int) : Animal(name, age, "dog") {
    override fun move() {
        println("running")
    }
}
