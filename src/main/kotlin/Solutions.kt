

    //Two Sum
    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for(index in nums.indices) {
            val complement = target - nums[index]
            val complementIndex = nums.indexOf(complement)
            if (complementIndex != -1 && complementIndex != index)
                return listOf(complementIndex, index).toIntArray()
        }
        return listOf(0, 0).toIntArray()
    }

    /**
     * Binary Search
     */

    fun search(nums: IntArray, target: Int): Int {
//        val index = nums.firstOrNull { it == target }
//        return index ?: -1

        var low = 0
        var high = nums.lastIndex

        while (low <= high) {
            val mid = (low + high)/2
            if (nums[mid] == target) return mid
            if (target > nums[mid]) { low = mid + 1 }
            else if (target < nums[mid]) { high = mid - 1 }
        }

        return -1
    }


    fun main() {
        val result = twoSum(listOf(2, 2, 11, 15).toIntArray(), 4).toList()

        val index = search(intArrayOf(1), 1)

        println("Index: $index")
}
