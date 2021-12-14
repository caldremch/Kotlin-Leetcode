class Solution5 {


    fun longestPalindrome(s: String): String {

        if (s.isEmpty()) return ""

        val map = HashMap<Char, Int>(s.length)

        //同一时间只有一个最大的回文, 如果都没有, 最大回文个数都是1
        var cLen = 0;
        var maxStartIndex = 0;
        val size = s.length
        var max:String = ""

        s.toCharArray().forEachIndexed { index, c ->
            if (map.containsKey(c)) {
                //有回文, 是否大于之前的回文
                if ((index - map[c]!!) > cLen) {

                    if(index+1<size && c == s[index+1]){
                        return@forEachIndexed
                    }

                    //判断是否是回文, 如果不是,进行下标变换, 供下一个回文判断

                    var subString:String = ""

                    for (x in map[c]!!..index){
                        subString+=s[x]
                    }

                    var i = 0
                    var j = subString.length
                    val jishu = (j % 2 != 0)


                    if (j == 1) {
                        return@forEachIndexed
                    }

                    if (j == 2) {
                        //存储当前的回文开始
                        maxStartIndex = map[c]!!
                        cLen = subString.length;//回文跨度
                        map[c] = index
                        max = subString
                        //改变index, 用于计算下一次回文
                        return@forEachIndexed
                    }

                    j = j - 1;

                    var continueRun = true

                    while (subString[i] == subString[j] && continueRun) {
                        i++
                        j--
                        if(jishu){
                            continueRun = i != j
                        }else{
                            continueRun = (i != (j+1))
                        }
                    }

                    if(jishu){
                        continueRun = i == j
                    }else{
                        continueRun = (i == (j+1))
                    }

                    if (continueRun) {
                        //存储当前的回文开始
                        maxStartIndex = map[c]!!
                        cLen = subString.length;//回文跨度
                        map[c] = index
                        max = subString
                    }else{

                    }


                }
            } else {
                map[c] = index;
            }

        }

        return if(max.isEmpty()) s[0].toString() else max;

    }


}


fun main(args: Array<String>) {

    val s5 = Solution5()
    println(s5.longestPalindrome("babad")            )
    println(s5.longestPalindrome("cbbd")             )
    println(s5.longestPalindrome("a")                )
    println(s5.longestPalindrome("ac")               )
    println(s5.longestPalindrome("abcdefg")      )
    println(s5.longestPalindrome("abadefgab")      )
    println(s5.longestPalindrome("ccc")              )
    println(s5.longestPalindrome("ccc")             )
    println(s5.longestPalindrome("cccc")            )
    println(s5.longestPalindrome("cccbbbbd")            )
    println(s5.longestPalindrome("abaccaddda")          )
    println(s5.longestPalindrome("alevelb")               )
    println(s5.longestPalindrome("cnoond")                 )
    println(s5.longestPalindrome("bb")                         )
    println(s5.longestPalindrome("aacabdkacaa")                )
    println(s5.longestPalindrome("abcacba")                 )
}