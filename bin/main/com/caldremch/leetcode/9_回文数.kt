

class Solution9 {
    fun isPalindrome(x: Int): Boolean {
      if(x<0) return false
        //先进行整数反转
        var y = x
        var reverseInt = 0
        while(y != 0){
            reverseInt = reverseInt*10 + y % 10
            y /=10
        }
        return reverseInt == x
    }
}


fun main(args: Array<String>) {
    val solution = Solution9()
    println(solution.isPalindrome(121))
    println(solution.isPalindrome(123))
}