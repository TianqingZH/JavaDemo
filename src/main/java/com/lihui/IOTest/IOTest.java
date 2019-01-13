package com.lihui.IOTest;

import java.util.Scanner;

public class IOTest {
    public static  void sayHello(){
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        System.out.println(next);
    }
    public static void main(String[] args) {
        sayHello();
    }
}


