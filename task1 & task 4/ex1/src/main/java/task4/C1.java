/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task4;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Yousinho
 */
public class C1 implements Runnable{
    final BlockingQueue<Integer> S1;
    final BlockingQueue<Integer> S2;

    public C1(BlockingQueue<Integer> S1, BlockingQueue<Integer> S2) {
        this.S1 = S1;
        this.S2 = S2;
    }

    @Override
    public void run() {
       
        int s2Size=0;
        
        while(S1.size()>0){
        
        if(s2Size!=S2.size()){
       
        }
        
        }
    
    
    }

    
    
}
