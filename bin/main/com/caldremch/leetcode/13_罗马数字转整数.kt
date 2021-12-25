class Solution13 {
    fun romanToInt(s: String): Int {

        val map = hashMapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )

        var total:Int = 0
        var subValue:Int = 0
        var i:Int = 0
        var temp:Int = 0

        while(i<s.length){
            temp = map[s[i]]!!
            if(((i+1)< s.length) && map[s[i+1]]!! > temp && subValue == 0){
                subValue+=temp;
            }else if(subValue !=0){
                total += temp-subValue
                subValue = 0
            }else{
                total += temp;
            }
            i++
        }
        return total

    }
}

fun main() {
    val  solution = Solution13()
    println(solution.romanToInt("III"))
    println(solution.romanToInt("IV"))
    println(solution.romanToInt("IX"))
    println(solution.romanToInt("LVIII"))
    println(solution.romanToInt("MCMXCIV"))
}