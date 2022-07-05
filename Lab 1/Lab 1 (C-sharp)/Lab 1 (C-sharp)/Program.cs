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
        static private Random random = new Random();

        static void Main(string[] args)
        {
            Console.Write("Введите количество потоков: ");
            String str = Console.ReadLine();
            int n = Convert.ToInt32(str);
            for (int i = 0; i < n; i++)
            {
                new Thread(() => calculation(i, random.Next(0, 999), random.Next(1, 5))).Start();
            }
        }  

        static void calculation(int id, int end, int step)
        {
            int sum = 0;
            int count = 0;
            for (int i = 0; i < end; i += step)
            {
                sum += i;
                count++;
            }
            Console.WriteLine("id: {0};сумма : {1}; Количество операций: {2}", id, sum, count);
            Console.ReadKey();
        }
    }
}
