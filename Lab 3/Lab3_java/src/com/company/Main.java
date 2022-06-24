package com.company;

import java.lang.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ведите розмер хранилища: ");
        int storageSize = sc.nextInt();
        System.out.println("Введите количество товаров: ");
        int itemNumbers = sc.nextInt();
        sc.close();
        int producers = 2;
        int consumers = 5;
        Manager manager = new Manager(storageSize);
        for (int i = 0; i < producers; i++) {
            new Producer(i * itemNumbers / producers, (i + 1) * itemNumbers / producers, manager);
        }
        for (int i = 0; i < consumers; i++) {
            new Consumer((i + 1) * itemNumbers / consumers - i * itemNumbers / consumers, manager);
        }

    }
}


