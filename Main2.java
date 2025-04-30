/*
Cで書くと
#include<stdio.h>

void main(char* args[]){
    printf("Hello C");
}
*/
public class Main2 {
    public static void main(String[] args) {
        System.out.println("Hello world");
        System.out.println("こんにちは");
        System.out.print("2 + 3 = ");
        System.out.println(2+3);
        /*
        PHPの時は
        $age=20; 変数$ageに整数値20を代入
        echo $age;
        */
        int age=20;
        double pi=3.14;
        System.out.println(age);
        System.out.println(pi);
    }
}
