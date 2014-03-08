package servermthread;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerMThread {

    public static void main(String[] args) throws IOException {
        
        ServerSocket ss = new ServerSocket(6666);    
        
        while (true) {
            new MyThread(ss.accept()).start();
            System.out.println("Connesso");
        }
    }
}