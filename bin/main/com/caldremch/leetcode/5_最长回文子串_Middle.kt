class Solution5 {


    fun is_palindrome(c: String, start: Int, end: Int): Boolean {
        if (start == end) return true
        if (c[start] == c[end]) {
            val newStart = start+ 1
            val newEnd = end - 1
            if (newStart > newEnd || newStart == newEnd) return true
            return is_palindrome(c, newStart, newEnd)
        }
        return false

    }

    fun longestPalindrome(s: String): String {

        val len = s.length
        val current = arrayListOf<Char>()
        var max_palindrome = ""
        var cur_max_palindrome = 0

        for(i in 0 until len){
            current.clear()
            current.add(s[i])
            for ( j in i until len){
                if(current.contains(s[j])){
                    val cur_start = i
                    val cur_end = j

                    if(is_palindrome(s, cur_start, cur_end)){
                        if(cur_end+1-cur_start>cur_max_palindrome){
                            cur_max_palindrome = cur_end+1-cur_start
                            max_palindrome = s.substring(cur_start, cur_end+1)
                        }
                    }


                }else{
                    current.add(s[j])
                }
            }
        }


        return max_palindrome

    }


}


fun main(args: Array<String>) {

    val s5 = Solution5()

    println(s5.longestPalindrome("a"))
    println(s5.longestPalindrome("aa"))

    /*println(s5.longestPalindrome("babad"))
    println(s5.longestPalindrome("cbbd"))
    println(s5.longestPalindrome("a"))
    println(s5.longestPalindrome("ac"))
    println(s5.longestPalindrome("abcdefg"))
    println(s5.longestPalindrome("abadefgab"))
    println(s5.longestPalindrome("ccc"))
    println(s5.longestPalindrome("ccc"))
    println(s5.longestPalindrome("cccc"))
    println(s5.longestPalindrome("cccbbbbd"))
    println(s5.longestPalindrome("abaccaddda"))
    println(s5.longestPalindrome("alevelb"))
    println(s5.longestPalindrome("cnoond"))
    println(s5.longestPalindrome("bb"))
    println(s5.longestPalindrome("aacabdkacaa"))
    println(s5.longestPalindrome("abcacba"))
    println(s5.is_palindrome("abcacba", 0, 6))
    println(s5.is_palindrome("abcac1a", 0, 6))*/
}