using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace Lab2_c_sharp
{
    class Program
    {
        public static int min = int.MaxValue;
        public static int all_min = int.MaxValue;
        public static int n_min;
        public static int border;
        public static int[] arr =new int[1000000];
        public static void Main(string[] args)
        {
           
            var random = new Random();
            Console.Write("Введите количество потоков: ");
            String str = Console.ReadLine();
            int n = Convert.ToInt32(str);
            border = arr.Length / n;
            object locker = new object();
            int num= random.Next(0,1000000);
            for (int i = 0; i < arr.Length; i++)
            {
                arr[i] = random.Next(0, 100000);
            }
            arr[num] = -1;
            for (int i = 0; i < n; i++)
            {
                new Thread(() => ThreadMain(n,arr,border*i,i,locker)).Start();
                Thread.Sleep(100);
            }
            Console.WriteLine("Минимальный елемент масива: "+n_min+" його значення: "+all_min);
            Console.ReadLine();
        }
        public static void ThreadMain(int n, int[] arr, int border,int index,object locker)
        {
            bool acquiredLock = false;
            try
            {
                for (int i = border; i < border + arr.Length / n; i++)
                {
                    if (i >= arr.Length) { break; }
                    if (min > arr[i])
                    {
                        min = arr[i];
                        n_min = i;
                    }
                }
                Console.WriteLine("Поток: "+index+" "+min);
                Min();
                min = 0;
            }
            finally
            {
                if (acquiredLock) Monitor.Exit(locker);
            }
        }
        public static void n_Min()
        {
            int min = int.MinValue;
            for (int i = 0; i < arr.Length; i++)
            {
                if (min > arr[i])
                {
                    min = arr[i];
                    n_min = i;
                }
            }
        }
        public static void Min()
        {
            if (all_min > min)
            {
                all_min = min;
            }
        }
        
    }
}


    
 

