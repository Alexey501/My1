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
        public static void Main(string[] args)
        {
            new Program().RealMain();
            Console.ReadKey();
        }

        private void RealMain()
        {
            var arr = new int[100000];
            var random = new Random();
            Console.Write("Введите количество потоков: ");
            String str = Console.ReadLine();
            int n = Convert.ToInt32(str);
            for (int i = 0; i < arr.Length; i++)
            {
                arr[i] = random.Next(-100000,100000);
            }

            for(int i = 0; i < n; i++)
            {
                FindMain(arr, n);
            }
        }
        private void FindMain(int[] arr, int threadsNum)
        {
           
            var startTime = DateTime.Now;

            var threads = new Thread[threadsNum];

            var min = int.MaxValue;
            object _lock = new object();

            for (int threadIdx = 0; threadIdx < threads.Length; threadIdx++)
            {
                var threadIdxLocal = threadIdx;
                threads[threadIdx] = new Thread(() =>
                {
                    for (int i = arr.Length * threadIdxLocal / threadsNum; i < arr.Length * (threadIdxLocal + 1) / threadsNum; i++)
                    {
                        if (arr[i] < min)
                        {
                            lock (_lock)
                            {
                                if (arr[i] < min)
                                {
                                    min = arr[i];
                                }
                            }
                        }
                    }
                });

                threads[threadIdx].Start();
            }

            foreach (var item in threads)
            {
                item.Join();
            }

            var endTime = DateTime.Now;

           
            Console.WriteLine($"Поток:{threadsNum}  Минимум: {min}  Время: {(endTime - startTime).TotalMilliseconds}ms");
        }
    }
}
