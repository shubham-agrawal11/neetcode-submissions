class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var zeroes = 0
        var product = 1
        var newArr = IntArray(nums.size) {0}

        nums.forEach {
            if (it == 0) {
                zeroes++
            }
            if (zeroes > 1) {
                println("More than 1 zero")
                return IntArray(nums.size) { 0 }
            }
            if (it != 0) {
                // println("product = $product it=$it")
                product *= it
            }
        }
        // println("Product = $product")
        for (i in nums.indices) {
            if (zeroes == 1) {
                if (nums[i] == 0) {
                    newArr[i] = product
                }
                continue
            }
            newArr[i] = product / nums[i]
        }
        return newArr
    }
}
