


fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }

    val sortedString = strs.sorted()
    println("SortedString: $sortedString")
    var pointer = 0
    while (pointer < sortedString.first().length) {
        if (sortedString.first()[pointer] == sortedString.last()[pointer]) {
            pointer ++
        } else
            break
    }

    return sortedString.first().substring(0 until pointer)
}


    fun isValid(s: String): Boolean {
        if (s.count() % 2 != 0) {
            return false
        }
        val temp = mutableListOf<Char>()
        for (char in s) {
            when(char) {
                '{' -> temp.add('}')
                '[' -> temp.add(']')
                '(' -> temp.add(')')
                else -> if (temp.isEmpty() || char != temp.removeLast())  {
                        return false
                    }
            }
        }

        println("Temp list: "+ temp.toList())
        return temp.isEmpty()
    }

fun mergeTwoList(l1: List<Int>, l2: List<Int>): List<Int> {
    if (l1.isEmpty()) {
        return l2
    } else if (l2.isEmpty()) {
        return l1
    }
    val bothList = listOf(l1, l2)
    return bothList.flatten()
}

fun searchInsert(nums: IntArray, target: Int): Int {
    if (nums.contains(target)) { return nums.indexOf(target) } // return the index if value exist
    return  nums.filter { it < target }.size
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val mappedArray = (nums1 + nums2).sorted()
    return if (mappedArray.count() % 2 != 0) {
        mappedArray[mappedArray.count()/2].toDouble()
    } else {
        (mappedArray[mappedArray.count()/2].toDouble() + mappedArray[mappedArray.count()/2 - 1]) / 2

    }
}

fun lengthOfLastWord(s: String): Int {
    return s.trim().substringAfterLast(" ").count()
}

fun isPalindrome(input: Int): Boolean {

    return input.toString().reversed() == input.toString().reversed()
}

fun threeSum(nums: IntArray): List<List<Int>> {
    if (nums.count() < 3) return emptyList()

    val outputList = mutableSetOf<List<Int>>()
     val nums = nums.toSet().toList().sorted()
    for (i in 0 until nums.size - 2) {
        var j = i + 1
        var k = nums.size - 1
        while (j < k) {
            val sum = nums[i] + nums[j] + nums[k]
            if (sum == 0) {
                outputList.add(listOf(nums[i], nums[j], nums[k]))
                j++
            } else if (sum > 0) { k-- }
            else { j++ }
        }
    }

    return outputList.toList()
}

fun reverse(x: Int): Int {
    return if (x == 0 || isValidInt(x) ) {
        0
    } else if (x < 0) {
        val xString = x.toString().substring(1).reversed().toInt()
        -1 * xString
    } else {
        val temp = x.toString().reversed()
        temp.toInt()

    }
}

fun isValidInt(x: Int): Boolean {
    return !(x > Int.MAX_VALUE/10 || x < Int.MIN_VALUE/10)
}

fun main() {

    println("Reverse of -2147483648: ${reverse(-2147483648)}")

    println(")[: " + isValid("[({("))

    println("**********mergeTwoList*******")
    val l1 = listOf(1, 2, 3, 4)
    val l2 = listOf(5, 6, 7, 8)
    println("Sorted list: ${mergeTwoList(l1, l2)}")

    println("******Search Insert*******")
    println("searchInsert: ${searchInsert(intArrayOf(1, 3, 4, 5), 6)}")

    println("FindMedianSortedArray: ${findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4))}")

    println("Length of last word: ${lengthOfLastWord("Apple banana  add  ")}")

    println("-121 is palindrome: ${isPalindrome(-121)}")

    println("Three sum result of [-2,0,1,1,2] is:   ${threeSum(intArrayOf(-2,0,1,1,2))}")

}