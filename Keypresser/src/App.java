import java.io.*;  
import java.net.*;  
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int count = 0;
        Robot r = new Robot();

        while(count < 5){
            try{  
                ServerSocket ss=new ServerSocket(6666);  
                Socket s=ss.accept();//establishes connection   
                DataInputStream dis=new DataInputStream(s.getInputStream());  
                String  str=(String)dis.readUTF();  
                System.out.println("message= "+str);
                r.keyPress(KeyEvent.VK_A);
                r.keyRelease(KeyEvent.VK_A);  
                ss.close();  
                }catch(Exception e){System.out.println(e);}  
                
                
            
            
            }  
            count++;

        }
            


    }

