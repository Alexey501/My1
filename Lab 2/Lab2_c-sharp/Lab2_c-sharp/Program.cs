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
        public static void Main(string[] args)
        {
            var arr = new int[1000000];
            var random = new Random();
            Console.Write("Введите количество потоков: ");
            String str = Console.ReadLine();
            int n = Convert.ToInt32(str);
            border = arr.Length / n;
            object locker = new object();
            for (int i = 0; i < arr.Length; i++)
            {
                arr[i] = random.Next(-100001, 100000);
            }

            for (int i = 0; i < n; i++)
            {
                new Thread(() => ThreadMain(n,arr,border*i,i,locker)).Start();
                Thread.Sleep(100);
            }
            Console.WriteLine("Минимальный елемент масива: "+all_min);
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
                Console.WriteLine(index + " " + min);
                Min();
                min = 0;
            }
            finally
            {
                if (acquiredLock) Monitor.Exit(locker);
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


    
 

