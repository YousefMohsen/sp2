package task1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h2>Task 1</h2>
 * <p>
 *     Your first task is to write an UDP server instead of a TCP server. UDP splits your data into small data fragments
 *     and sends them off without any guarantee of order: you don't know which package comes first! (A bit like
 *     concurrency). Instead of the constantly open output- and input-streams from the TCP server, you receive and
 *     send things from/to byte arrays.
 * </p>
 * <p>
 *     So, each package receives a certain amount of bytes. In our (kinda artificial) case we only receive 10 bytes.
 *     Use the {@link #DATA_BUFFER} for storing and retrieving data in this exercise.
 * </p>
 * <p>
 *     Your job is to implement a UDP server that binds to a socket on your local machine and waits until a client
 *     sends some data. When the data arrives you print it out. That's it! When it's printed, notice how much data is
 *     sent (and how much isn't). That's the drawback of this approach. On the other hand it's fast!
 * </p>
 */
public class UdpServer implements Runnable {

   

    private static final byte[] DATA_BUFFER = new byte[10];

    @Override
    public void run() {
        
        DatagramSocket serverSocket;
        try {
            serverSocket = new DatagramSocket(8080);
            
            
               byte[] receiveData = new byte[10];
            byte[] sendData = new byte[10];
            while(true)
               {
                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  serverSocket.receive(receivePacket);
                  String sentence = new String( receivePacket.getData());
                  System.out.println("RECEIVED: " + sentence);
                  InetAddress IPAddress = receivePacket.getAddress();
                  int port = receivePacket.getPort();
                  sendData = sentence.getBytes();
                  DatagramPacket sendPacket =
                  new DatagramPacket(sendData, sendData.length, IPAddress, port);
                  serverSocket.send(sendPacket);
                  
               }
        
        } catch (SocketException ex) {
            Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    
               
 
    /*       
        try {
             DatagramSocket serversocket= new DatagramSocket();
             serversocket.bind(new InetSocketAddress("localhost", 8080));
                   byte[] sendData = new byte[1024];
            byte[] buffer = new byte[1024];
                     System.out.println("l 44");
     DatagramPacket rePacket = new  DatagramPacket(buffer,buffer.length);

     while (true) {
         System.out.println("l 48");
       
     
     
    serversocket.receive(rePacket);
     String line = new String( rePacket.getData());
    System.out.println("RECEIVED: " + line);
                  InetAddress IPAddress = rePacket.getAddress();
                  int port = rePacket.getPort();
                
                 sendData = line.getBytes();
                 System.out.println("sendData: "+sendData.length);
                  DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                  serversocket.send(sendPacket);
           
             
  }
        } catch (SocketException ex) {
            Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
           
 
           
            // 1. Create a UDP server that binds (listens) to a port
            // 2. Wait for some data to arrive
            // 3. Print the data!
     */   
    }
    void handleConnection(Socket connection){
    
    
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // Run the udp server in a thread here
        // Wait for the thread to finish before the program stops
        
         Thread udbServer = new Thread(new UdpServer() );
         udbServer.start();
         udbServer.join();
         System.out.println("UBD server closed");
         
         
    }

}
