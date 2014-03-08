package servermthread;

/**
 *
 * @author Luca
 */

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyThread extends Thread {
     private Socket s;

    public MyThread(Socket s) {
        this.s = s;
    }

    public void run() {    
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
           
            boolean maiusc = false;
                while(true) {
                    String str = in.readLine();
                    switch(str){
                        case "fine":                            
                            out.println("Connessione chiusa");
                            break;
                        case "on" :
                            maiusc = true;
                            out.println("Maiuscole attive");
                            break;
                        case "off":
                            maiusc = false;  
                            out.println("Maiuscole disattive");
                            break;
                        default :
                             if(maiusc==true){                      
                                out.println(str.toUpperCase());
                            }else
                                out.println(str);
                            
                            break;
                    }
                    /* if(str.equals("fine")){
                         out.println("Connessione chiusa");
                     }else if(str.equals("on")){
                         maiusc = true;
                         out.println("Maiuscole attive");
                     }else if(str.equals("off")){
                         maiusc = false;
                         
                         out.println("Maiuscole disattive");
                     }else{
                         if(maiusc==true){
                            
                             out.println(str.toUpperCase());
                         }else{
                             out.println(in.readLine());
                         }
                    }*/
                }
        } catch (IOException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
}


