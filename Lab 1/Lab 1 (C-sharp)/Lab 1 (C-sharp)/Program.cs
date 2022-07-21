using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace Lab_1__C_sharp_
{
    internal class Program
    {
        private static bool canStop;
        static void Main(string[] args)
        {
            Console.Write("Введите количество потоков: ");
            String str = Console.ReadLine();
            int n = Convert.ToInt32(str);
            for (int i = 0; i < n; i++)
            {
               (new Thread(calculation)).Start();
            }
            (new Thread(Stoper)).Start();
            Console.ReadKey();
        }  

        static void calculation()
        {
            long sum = 0;
            do
            {
                sum++;
            } while (!canStop);
            Console.WriteLine(sum);
        }
        static void Stoper()
        {
            Thread.Sleep(3*1000);
            canStop = true;
        }
    }
}
