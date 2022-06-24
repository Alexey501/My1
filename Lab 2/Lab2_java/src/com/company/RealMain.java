package com.company;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class RealMain extends FindMain{
    public void RealMain() throws java.lang.Exception
    {
        int[] arr = new int[10000000];
        Random random = new Random();
        String str= JOptionPane.showInputDialog(null,"Введите количество потоков");
        int n=Integer.parseInt(str);
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = random.nextInt();
        }

        for(int i=1;i<=n;i++){
            FindMain(arr, i);
        }

    }
}
