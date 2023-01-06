
fun transform(input: ArrayList<Int>): ArrayList<String> {
    val temp = ArrayList<String>()
    for (item in input) {
        temp.add("$item")
    }
    return  temp
}

// Bubble sort
/* Take the first element and compare it with the element to the next one. If it's greater than to the next one, swap it. After first round, the largest element of the array
    will be at the end. Worst case complexity is O(n^2) and best case complexity is O(n)
*/

fun bubbleSort(input: ArrayList<Int>): ArrayList<Int> {
    var count = 0
    for (i in 0 until input.size) {
        count ++
        var swapped = false
        for (j in 0 until  input.size - i -1) {
            if (input[j] > input[j+1]) {
                swapped = true
                val temp = input[j]
                input[j] = input[j+1]
                input[j+1] = temp
            }
        }

        if (!swapped)
            break
    }
    println("Count: $count")
    return input
}

/* Selection Sort
    Consider the first element of the array to be minimum number. Compare it with other elements of the list, if it's less than the first value swap them
    After first iteration, first element of the array is sorted.
    Complexity is O(N^2)
 */
fun selectionSort(input: ArrayList<Int>) {
    for(i in 0 until input.size) {
        var minIndex = i
        for (j in i until input.size) {
            if (input[j] < input[minIndex])  {
                minIndex = j
            }
        }

        val temp = input[minIndex]
        input[minIndex] = input[i]
        input[i] = temp
    }

    println("Selection sort result: ${input.toList()}")
}

fun main(args: Array<String>) {
    val studentAge = ArrayList<Int>()
    studentAge.add(-2)
    studentAge.add(45)
    studentAge.add(0)
    studentAge.add(11)
    studentAge.add(-9)
    val output = bubbleSort(studentAge)
    println("Bubble sort output: ${output.toList()}")

    selectionSort(studentAge)


}
