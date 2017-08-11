
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MIR LUTFUR RAHMAN
 */
public class clientBox {

    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String stri,stro;
    public clientBox()
    {
        Scanner in=new Scanner(System.in);
        try {
            System.out.println("Waiting for connection......");
            socket=new Socket("localhost",4356);
            System.out.println("Connected!!");
            dis=new DataInputStream(socket.getInputStream());
            dos=new DataOutputStream(socket.getOutputStream());
            while(true)
            {
                stro=in.nextLine();
                if(stro.equalsIgnoreCase("close")) break;
                dos.writeUTF(stro);
                dos.flush();
            }
            dis.close();
            dos.close();
            
        } catch (Exception ex) {
            System.out.println("Error= "+ex.getMessage());
        }
        
    }
    
    public static void main(String args[])
    {
        new  clientBox();
    }
    
}
