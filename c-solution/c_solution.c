//
// Created by Caldremch on 2021/12/14.
//

#include "c_solution.h"
#include <string.h>
#include <stdlib.h>

int is_palindrome(char *c, int start, int end) {
    if (start == end) {
        return 1;
    }
    if (c[start] == c[end]) {
        end -= 1;
        start += 1;
        if (start > end || start == end) return 1;
        return is_palindrome(c, start, end);
    }
    return 0;

}

int is_exist(char *src, int src_len, char target) {
    int exist = 0;
    for (int i = 0; i < src_len; ++i) {
        if (src[i] == target) {
            exist = 1;
            break;
        }
    }
    return exist;
}

char *longestPalindrome(char *s) {
    int len = strlen(s);
    char *map = malloc(len * sizeof(char));
    char *max_palindrome = malloc(len * sizeof(char));
    int cur_max_palindrome = 0;

    //查找每个字符为开始的回文
    for (int i = 0; i < len; ++i) {
        memset(map, 0, len);
        map[i] = s[i];
        for (int j = i; j < len; ++j) {
            if (is_exist(map, len, s[j])) {
                //相等, 则判断是否是回文
                int cur_start = i;
                int cur_end = j;
                if (is_palindrome(s, cur_start, cur_end)) {
                    if ((cur_end + 1 - cur_start) > cur_max_palindrome) {
                        cur_max_palindrome = cur_end + 1 - cur_start;
                        memset(max_palindrome, 0, len);
                        memcpy(max_palindrome, s + cur_start, cur_max_palindrome);
                    }

                }
            } else {
                map[j] = s[j];
            }
        }
    }
    free(map);
    return max_palindrome;
}
