import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import java.io.*;  
import java.net.*;  

public class Listener implements NativeKeyListener {

    

    public void nativeKeyPressed(NativeKeyEvent e) {
        
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        String pressed = NativeKeyEvent.getKeyText(e.getKeyCode());
        
        try{      

            Socket s=new Socket("localhost",6666);  
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
            dout.writeUTF(pressed);  
            dout.flush();  
            dout.close();  
            s.close();  
            }catch(Exception a){
           System.out.println(a);
           } 

        if (pressed.contains("C")){
            System.out.println("\n===========\n As char.. C"  + " \n\n ==========\n");
        }



        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException nativeHookException) {
                nativeHookException.printStackTrace();
            }
        }
    }
    
    
    public void nativeKeyReleased(NativeKeyEvent e) {
        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        String pressed = NativeKeyEvent.getKeyText(e.getKeyCode());
        // System.out.println("\n===========\n You pressed " + pressed + " \n\n ==========\n");
        char presc = pressed.charAt(0);
        // System.out.println("\n===========\n As char.. " + presc + " \n\n ==========\n");
        if (pressed.contains("C")){
            System.out.println("\n===========\n As char.. I TWAS SEEEE"  + " \n\n ==========\n");
        }
        System.out.println("\n===========\n As char.. " + presc + " \n\n ==========\n");

    }
    
    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }
}
