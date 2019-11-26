import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("127.0.0.1", 8020);

            OutputStream outStream = clientSocket.getOutputStream();
            ObjectOutput oOutputStream = new ObjectOutputStream(outStream);

            Scanner kb = new Scanner(System.in);
            for (int i = 0; i < 5; i++) {
                String ins = kb.nextLine();
                oOutputStream.writeObject(ins);
            }
            oOutputStream.flush();
            oOutputStream.close();
        } catch (Exception e) {
        }
    }
}