
import java.lang.IllegalArgumentException
import java.util.Random

fun main(args: Array<String>) {
    println("Hello World");

    /**
     * DATA TYPES
     */
    println("-:: DATA TYPES ::-")

    val name = "Elise"      //immutable
    var myAge = 32          //mutable

    //define type
    var bigInt: Int = Int.MAX_VALUE
    var smallInt: Int = Int.MIN_VALUE
    println("Biggest int: " + bigInt)
    println("Smalles int: $smallInt")
    println("Sum: " + (bigInt + smallInt))

    // Long, Double, Float, Boolean, Short (16bytes), Byte (8bytes), Char

    var letterGrade: Char = 'A'
    println("A is a Char: ${letterGrade is Char}")

    //Casting:
    println("3.14 to Int: " + ( 3.14.toInt()))  //prints "3"
    println("A to Int: " + ('A'.toInt()))       //prints 65

    //Strings
    val longStr = """
        This is a loooooong string with a lot of content.
    """.trimIndent()
    println("String length: ${longStr.length}")

    var str1 = "A random string"
    var str2 = "a random string"
    println("Strings equal: ${str1.equals(str2)}")  //prints false
    println("Compare A to B: ${"A".compareTo("B")}") //prints -1

    println("Second index: ${str1.get(2)}") //prints "r"
    println("String 2 - 7: ${str1.subSequence(2, 8)}") //prints "random"
    println("Contains random: ${str1.contains("random")}")  //prints true

    /**
     * ARRAYS
     */
    println("-:: ARRAYS ::-")
    var myArray = arrayOf(1, 1.23, "Elise")
    println(myArray[2])
    myArray[1] = 3.14
    println("Array length: ${myArray.size}")
    println("Elise in array: ${myArray.contains("Elise")}")
    var partOfArray = myArray.copyOfRange(0,1)  //first two elements
    println("First: ${myArray.first()}")
    println("Elise index: ${myArray.indexOf("Elise")}")

    var sqArray = Array(5, { x -> x*x}) //for each element, multiply by itself
    println(sqArray[2]) //prints 4

    var dataSpecificArray: Array<Int> = arrayOf(1,2,3)


    /**
     * RANGES
     */
    println("-:: RANGES ::-")
    val oneToTen = 1..10
    val alphabet = "A".."Z"
    println("R inside alphabet: ${"R" in alphabet}")
    val tenToOne = 10.downTo(1)
    val twoTo20 = 2.rangeTo(20)

    val range3 = oneToTen.step(3)   //adds 3 to each step

    for(x in range3) println("range3: $x")
    for(x in range3.reversed()) println("Reverse: $x")

    /**
     * WHEN
     */
    println("-:: WHEN ::-")

    val age = 8

    when(age) {
        0,1,2,3,4 -> println("Go to preschool")
        5 -> println("Go to indergarden")
        in 6..17 -> {
            val grade = age - 5
            println("Go to Grade $grade")
        }
        else -> println("Go to college")
    }

    /**
     * LOOPING
     */
    println("-:: LOOPING ::-")

    for(x in 1..10){
        println("Loop: $x")
    }

    val rand = Random()
    val magicNum = rand.nextInt(50) + 1
    var guess = 0
    while(magicNum != guess) {
        guess += 1
    }
    println("Magic number was $guess")

    for(x in 1..20) {
        if (x % 2 == 0) {
            continue        //goes to the top of the for-loop
        }
        println("Odd values: $x")

        if(x == 15) break   //exits the for-loop
    }

    var intArray: Array<Int> = arrayOf(3,6,9)
    for(i in intArray.indices) {
        println("Array indices: ${intArray[i]}")
    }

    for((index, value) in intArray.withIndex()) {
        println("Index: $index Value: $value")
    }

    /**
     * FUNCTIONS
     */
    println("-:: FUNCTIONS ::-")

    fun add(num1: Int, num2: Int) : Int = num1 + num2
    println("5 + 4 = ${add(5,4)}")

    //return type not required in single-line functions
    // default values
    fun subtract(num1: Int = 1, num2: Int = 2) = num1 - num2
    println("5 - 4 = ${subtract(5,4)}")

    //with named values
    println("4 - 5 = ${subtract(num2 = 5, num1 = 4)}")

    fun sayHello(name: String) : Unit = println("Hello $name")
    sayHello("Elise")

    //function that returns two values
    fun nextTwo(num: Int): Pair<Int, Int> {
        return Pair(num+1, num+2)
    }
    val (two, three) = nextTwo(1)
    println("1 $two $three")

    fun getSum(vararg nums: Int): Int {
        var sum = 0
        nums.forEach { n -> sum += n }
        return sum
    }
    println("Sum of 1..5= ${getSum(1,2,3,4,5)}")

    val multiply = {num1: Int, num2: Int -> num1 * num2}
    println("5 * 3 : ${multiply(5,3)}")

    fun factorialOf(x: Int): Int {
     tailrec fun factTail(y: Int, z: Int): Int {
         if(y == 0) return z
         else return (factTail(y - 1, y * z))
     }
        return factTail(x, 1)
    }
    println("5! = ${factorialOf(5)}")

    //Higher order function
    val numList = 1..20
    val evenList = numList.filter{ it % 2 == 0 }
    evenList.forEach { n -> println(n)}

    //function that creates functions
    fun makeMathFunction(num1: Int): (Int) -> Int = {num2 -> num1 * num2}
    val mult3 = makeMathFunction(3)
    println("5 * 3 = ${mult3(3)}")

    fun mathOnList(numList: Array<Int>, myFunc: (num: Int) -> Int) {
        for(num in numList){
            println("MathOnList ${myFunc(num)}")
        }
    }

    val multiply2 = {num1: Int -> num1 * 2}
    val numList2 = arrayOf(1,2,3,4,5)

    mathOnList(numList2, multiply2)

    /**
     * Collection Operators
     */
    println("-:: COLLECTION OPERATORS ::-")
    val numRange2 = 1..10
    val listSum = numRange2.reduce { x, y -> x + y }
    println("Reduce Sum: $listSum")

    val listSum2 = numRange2.fold(5) { x, y -> x + y }
    println("Fold sum: $listSum2")

    println("Any evens : ${numRange2.any { it % 2 == 0}}") //prints true
    println("All evens : ${numRange2.all { it % 2 == 0}}") //prints false

    val big3 = numRange2.filter { it > 7 }
    big3.forEach { n -> println(">7 : $n") }

    val times7 = numRange2.map { it * 7}
    times7.forEach { n -> println("*7 : $n") }

    /**
     * Exception handling
     */
    println("-:: Exception Handling ::-")
    val divisor = 0

    try {
        if(divisor == 0) {
            throw IllegalArgumentException("Can't divide by zero")
        } else {
            println("5 / $divisor = ${5/divisor}")
        }
    } catch (e: IllegalArgumentException) {
        println("${e.message}")
    }

    /**
     * Lists
     */
    println("-:: Lists ::-")

    var mutableList: MutableList<Int> = mutableListOf(1,2,3,4,5)
    val immutabelList: List<Int> = listOf(1,2,3)
    mutableList.add(6)

    println("First item in the list: ${immutabelList.first()}")
    println("Last item in the list: ${immutabelList.last()}")

    var subList = mutableList.subList(0,3)
    println("Size: ${mutableList.size}")

    subList.clear()
    mutableList.remove(1)
    mutableList.removeAt(1)

    mutableList.forEach { n -> println("Mutable list: $n") }
}

