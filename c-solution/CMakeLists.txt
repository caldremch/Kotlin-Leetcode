cmake_minimum_required(VERSION 3.21)
project(c_solution C)
set(CMAKE_C_FLAGS	" -m64 -Wno-write-strings -fgnu89-inline -fexceptions  -fno-inline -rdynamic -fsanitize=address -fsanitize-recover=all")

set(CMAKE_C_STANDARD 99)

add_executable(c_solution main.c c_solution.c c_solution.h)
