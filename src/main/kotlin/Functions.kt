

/*
    Infix function must be:
        1. An extension function or member function
        2. Must accept only a single parameter
        3. The parameter must not accept variable number of arguments and must have no default value
 */

// Infix function on int

infix fun Int.repeat(message: String) = message.repeat(this)
infix fun String.toArray(input: String): MutableList<Char> {
    val charList = mutableListOf<Char>()
    for (char in input) {
        charList.add(char)
    }
    return charList
}

// Infix member function
class Person(val name: String) {
    private val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) = likedPeople.add(other)

    fun printLikedPeople() {
        println("Liked people list is: ${likedPeople.toList()}")
    }
}

//Function with variable number of arguments
fun printAll(vararg names: String) {
    for (name in names) {
        print("$name ")
    }

    println()
}

// This is a generic function which can accept variable number of parameters of any type.
fun <T> mutableStackOf(vararg element: T) = mutableListOf(*element)

// Use of "When" as statement
fun printType(input: Any) {
    when(input) {
        is String -> println("Input type is String")
        is Int -> println("Input type is Integer")
        is Boolean -> println("Input type is Boolean")
        else -> println("Unknown type")
    }
}

/**
 * Use of "When" as expression
  */
fun printValue(input: Int) {
    val value = when(input) {
        1 -> "One"
        2 -> "Two"
        3 -> "Three"
        else -> "$input"
    }

    println("Passed value is: $value")
}
/*
Higher order function is a function that takes another function as a parameter or return a function
 */
// Higher Order function
fun<T, U> calculate(first: T, second: U, operation: (T, U) -> T): T{
    return operation(first, second)
}


fun main() {
    println(2 repeat "Bye ")
    println("Good Morning" toArray "Good Morning" )

    val david = Person("David")
    val add = Person("Add")
    david likes add
    david.printLikedPeople()

    printAll("Adam", "David", "Kalen")

    println("Result of string mutableStackOf ${mutableStackOf("Banana", "Apple", "Mango").toList()}")
    println("Result of integer mutableStackOf ${mutableStackOf(1, 2, 3, 4, 5).toList()}")

    val input = "Pakistan India Australia"
    println("Length: " + input.length)
    println("Count: "+ input.count())

    // When as statement
    printType(12.0)

    // When as expression
    printValue(2)
    printValue(5)

    // Call to higher order function
    println("Generic and Higher order function: " + calculate("Number ", 44) { a, b ->
        a + b
    })


}