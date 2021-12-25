import java.util.Stack
class Solution20 {

    fun isValid(s: String): Boolean {
        val map = hashMapOf<Char,Char>(
            '(' to ')',
            '[' to ']',
            '{' to '}'
        )
        val stack = Stack<Char>()
        var temp:Char
        for(i in 0 until s.length){
            temp = s[i]
            if(stack.empty()){
                stack.push(temp)
            }else{
                if(map[stack.peek()] == temp){
                    stack.pop()
                }else{
                    stack.push(temp)
                }
            }
        }

        return stack.empty()
    }
}

fun main(){
    val solution = Solution20()
    println(solution.isValid("[]"))
    println(solution.isValid("[)"))
    println(solution.isValid("(([][]))"))
}