

/**
 * Lists example
 */
fun  listExample() {
    /*
    List is ordered collection of items. List can be mutable or immutable.
 */

    val users = mutableListOf<String>()
    val names = listOf<String>()
    users.add("aaa")
    users.add("bbb")

    users.forEach { item ->
        println("User: $item")
    }

    // To prevent unwanted modification, obtain read-only views of mutable lists
    val systemUsers = mutableListOf("Adam", "Ball", "Catt")
    val readOnlyUsers: List<String> = systemUsers

    systemUsers.add("David")

    println("Users: ${readOnlyUsers.toList()}")

}

/**
 * Set is an unordered collection of unique items that doesn't support duplicates.
 */
class SetExample {
    val openIssues = mutableSetOf("Ticket 01", "Ticket 02", "Ticket 03")
    val readOnlyOpenIssues: Set<String> = openIssues
    var constantIssue = setOf("a", "b", "c", "d")
    fun addIssue(issue: String): Boolean {
        return openIssues.add(issue)
    }

    fun getStatusLog(isAdded: Boolean): String {
        return if (isAdded) "Added Correctly." else "marked as duplicated and rejected."
    }
}

/**
 * Map is a collection of key/value pairs where key is unique and can be used to retrieve the corresponding value. We can use the "to" infix function.
 * We can use mapOf() and mutableMapOf() to create immutable and mutable maps respectively.
 */
fun mapsExample() {
    val alphaNumbers = mutableMapOf(1 to "One", 2 to "Two")
    val readOnlyAlphaNumbers: Map<Int, String> = alphaNumbers
    alphaNumbers[3] = "Four"
    alphaNumbers[3] = "Three"
    for ((k,v) in readOnlyAlphaNumbers) {
        println("$k: $v")
    }

}


fun main() {
    listExample()

    // Example of set
    val setExample = SetExample()
    println("Ticket ${setExample.getStatusLog(setExample.addIssue("Ticket 04"))}")
    println("********Maps**************")
    mapsExample()

    println("********filter********")
    val numbers = listOf(-1, 0, 1, 2, -2, 3, -3, 5)
    val positives = numbers.filter { it > 0 }
    val negatives = numbers.filter { x -> x < 0 }
    println("Positives: $positives")
    println("Negatives: $negatives")

    println()
    println("*********** Use of map and forEach ************")
    val result = numbers.map { value ->
        if (value >= 0) "$value is positive" else "$value is negative"
    }

    result.forEach { item ->
        print("$item, ")
    }

    println()

    // Function any returns true if there's at least one element matching the criteria
    println("Any number GT 5: " + numbers.any { it > 6 })

    // function "all" returns true if all the elements in the list match the criteria
    println("All numbers are less than 5 ${numbers.all { it < 5 }}" )
    println("None of the numbers is less than 5 ${numbers.none { it < 5 }}" )

    // Using groupBy and associatedBy
    val ages = listOf(1, 2, 3, 4, 5)
    val groups = ages.groupBy { it % 2 }
    val associates = ages.associateBy { it % 2 }
    println("Groups: $groups")
    println("Associates: $associates")

    val posNeg = numbers.partition { it > 0 }
    println("Positive numbers: ${posNeg.first}")
    println("Negative numbers: ${posNeg.second}")
    println("Positive numbers joined: ${posNeg.first.joinToString(separator = ",")}")
    val alphaNumbers = listOf("One", "Two", "Three")
    val coll = listOf(numbers, alphaNumbers)
    val mapped = coll.flatten()
    println("flatMap result: $mapped")

}