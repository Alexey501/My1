using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Lab4_csharp
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("enter the number of philosophers and forks");
            string str = Console.ReadLine();
            int n = Convert.ToInt32(str);
            Semaphore[] fork=new Semaphore[n];
            for (int i = 0; i < n; i++)
            {
               fork[i] = new Semaphore(1, 1);
            }
            for (int i = 0; i < n; i++)
            {
                new Thread(() => Philosopher(i, n, fork)).Start();
                Thread.Sleep(1000);
            }
            Console.ReadKey();
        }


        static void Philosopher(int id, int n, Semaphore[] fork)
        {
            int diner = n - 1;
            if (id < diner)
            {
                Console.WriteLine("philosopher {0} thinking", id);
                Thread.Sleep(100);
                Console.WriteLine("philosopher {0} await fork", id);
                fork[id].WaitOne();
                fork[id+1].WaitOne();
                Console.WriteLine("philosopher {0} took fork", id);
                fork[id].Release();
                fork[id+1].Release();
                Console.WriteLine("philosopher {0} put down the fork", id);
            }
            else
            {
                Console.WriteLine("philosopher {0} thinking", id);
                Thread.Sleep(100);
                Console.WriteLine("philosopher {0} await fork", id);
                fork[id-1].WaitOne();
                fork[id].WaitOne();
                Console.WriteLine("philosopher {0} took fork", id);
                fork[id-1].Release();
                fork[id].Release();
                Console.WriteLine("philosopher {0} put down the fork", id);
            }

        }
    }
}
