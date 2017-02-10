/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task4;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yousinho
 */
public class FibCalThread implements Runnable {

    final BlockingQueue<Integer> S1;
    final BlockingQueue<Integer> S2;

    public FibCalThread(BlockingQueue<Integer> S1, BlockingQueue<Integer> S2) {
        this.S1 = S1;
        this.S2 = S2;
    }

    private int fib(int n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {

            return fib(n - 1) + fib(n - 2);
        }

    }

    @Override
    public void run() {

        Integer nextInt = S1.poll();
        while (nextInt != null) {

            try {
                S2.put(fib(nextInt));
            } catch (InterruptedException ex) {
                Logger.getLogger(FibCalThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            nextInt = S1.poll();

        }
    }

}
