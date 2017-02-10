/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task4;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Yousinho
 */
public class MultiThreadFib {

    final BlockingQueue<Integer> s1 = new ArrayBlockingQueue<Integer>(11);
    final BlockingQueue<Integer> s2 = new ArrayBlockingQueue<Integer>(11);

    public MultiThreadFib() {
        s1.add(4);
        s1.add(5);
        s1.add(8);
        s1.add(12);
        s1.add(21);
        s1.add(22);
        s1.add(34);
        s1.add(35);
        s1.add(36);
        s1.add(37);
        s1.add(42);

        System.out.println("s1 size: " + s1.size());
        System.out.println("s2 size: " + s2.size());

        System.out.println("s2 size: " + s2.size());

        System.out.println("- --- - -- - - -- - -");
    }

    private void numberOfThreads(int nThreads) throws InterruptedException {
        ArrayList<Thread> threadArray = new ArrayList();

     

        for (int i = 0; i < nThreads; i++) {
             Thread newThread = new Thread(new FibCalThread(s1, s2));
            threadArray.add(newThread);
            newThread.start();
            System.out.println("threadArray size: " + threadArray.size() + "\n acive threads: " + Thread.activeCount());

        }
      
 Thread newThread = new Thread(new C1(s1, s2));
 newThread.start();
        for (Thread thread : threadArray) {
            thread.join();
        }

        //calc sum and print
        int sum = 0;

        for (Integer integer : s2) {
            sum += integer;
        }
        System.out.println("Calculation finished. sum: " + sum);

    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadFib fibCalc = new MultiThreadFib();

        fibCalc.numberOfThreads(3);

    }

}
/*
  Thread calc1 = new Thread(new FibCalThread(fibCalc.s1,fibCalc.s2) );
    Thread calc2 = new Thread(new FibCalThread(fibCalc.s1,fibCalc.s2) );
    Thread calc3 = new Thread(new FibCalThread(fibCalc.s1,fibCalc.s2) );
     Thread calc4 = new Thread(new FibCalThread(fibCalc.s1,fibCalc.s2) );
  
    calc1.start();
     calc2.start();
    calc3.start();
    calc4.start();
    
    calc1.join();
    calc4.join();
    calc2.join();
    calc3.join();

*/
