package com.fatihex;

import java.util.ArrayList;
import java.util.List;

public class First100PrimeNumbers {
    public static void main(String[] args) {
        int num = 0;
        int isPrime = 0;
        List<Integer> primeNumber = new ArrayList<>();

        if(num == 0 || num == 1 || num < 0)
        {
            System.out.println("Sayı asal sayı değildir.");
        } else if (num == 2) {
            System.out.println("En küçük asal sayı");
        }
        else
        {
            isPrime =0;
            for (int i = 2; i < num ; i++) {
                if (num % i ==0) {
                    System.out.println("Asal sayı değildir.");
                    isPrime++;
                    break;
                }
            }
            if(isPrime==0)
            {
                primeNumber.add(num);
            }
        }
    }
}
