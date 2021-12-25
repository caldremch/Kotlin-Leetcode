class Solution14 {
    fun longestCommonPrefix(strs: Array<String>): String {
        
        if(strs.isNotEmpty()){

        val size = strs.size
        var c:Char? = null
            //取一个长度
            val len = strs[0].length
           var out:String = ""

            //按照索引对比所有字符
            for (i in 0 until len) {

                //对比每个字符串
                for(j in 0 until size){

                    //触发边界
                    if( i >= strs[j].length){
                        return out
                    }

                    //记录一个char
                    if(c == null){
                        c = strs[j][i]
                    }else if(strs[j][i] != c){
                       return out
                    }
                }

                if(c != null){
                    out += c
                    c = null
                }

            }

            return out
        }

        return ""
    }
}

fun main() {
    val solution = Solution14()
    println(solution.longestCommonPrefix(arrayOf("flower","flow","flight")))
    println(solution.longestCommonPrefix(arrayOf("dog","racecar","car")))
}