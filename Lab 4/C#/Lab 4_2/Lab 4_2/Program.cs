using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace Lab_4_2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("enter the number of philosophers and forks");
            string str = Console.ReadLine();
            int n = Convert.ToInt32(str);
            Semaphore[] fork = new Semaphore[2];
            for (int i = 0; i < 2; i++)
            {
                fork[i] = new Semaphore(1, 1);
                fork[i].WaitOne();
            }
            for (int i = 0; i < n; i++)
            {
                new Thread(() => waiter(fork)).Start();
                new Thread(() => Philosopher(i, n, fork)).Start();
                Thread.Sleep(1000);
                new Thread(() => waiter_took(fork)).Start();
            }
            Console.ReadKey();
        }
        static void Philosopher(int id, int n, Semaphore[] fork)
        {
                Console.WriteLine("philosopher {0} thinking", id);
                Thread.Sleep(100);
                Console.WriteLine("philosopher {0} await fork", id);
                fork[0].WaitOne();
                fork[1].WaitOne();
                Console.WriteLine("philosopher {0} took fork", id);
                Console.WriteLine("philosopher {0} put down the fork", id);
                fork[0].Release();
                fork[1].Release();
        }
        static void waiter( Semaphore[] fork)
        {
            fork[0].Release();
            fork[1].Release();
        }
        static void waiter_took(Semaphore[] fork)
        {
            fork[0].WaitOne();
            fork[1].WaitOne();
        }
    }
}

