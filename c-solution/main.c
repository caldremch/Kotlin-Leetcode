#include <stdio.h>
#include "c_solution.h"
#include <string.h>

int main() {
    char *s = "aba";
    printf("是回文:%d\n", is_palindrome(s, 0, strlen(s) - 1));
    printf("最长回文子串:%s\n", longestPalindrome("aba"));
    printf("最长回文子串:%s\n", longestPalindrome("babad"));
    printf("最长回文子串:%s\n", longestPalindrome("cbbd"));
    printf("最长回文子串:%s\n", longestPalindrome("a"));
    printf("最长回文子串:%s\n", longestPalindrome("ac"));
    printf("最长回文子串:%s\n", longestPalindrome("abcdefg"));
    printf("最长回文子串:%s\n", longestPalindrome("abadefgab"));
    printf("最长回文子串:%s\n", longestPalindrome("ccc"));
    printf("最长回文子串:%s\n", longestPalindrome("ccc"));
    printf("最长回文子串:%s\n", longestPalindrome("cccc"));
    printf("最长回文子串:%s\n", longestPalindrome("cccbbbbd"));
    printf("最长回文子串:%s\n", longestPalindrome("abaccaddda"));
    printf("最长回文子串:%s\n", longestPalindrome("alevelb"));
    printf("最长回文子串:%s\n", longestPalindrome("cnoond"));
    printf("最长回文子串:%s\n", longestPalindrome("bb"));
    printf("最长回文子串:%s\n", longestPalindrome("aacabdkacaa"));
    printf("最长回文子串:%s\n", longestPalindrome("abcacba"));
    printf("最长回文子串:%s\n", longestPalindrome("a"));

    return 0;
}
