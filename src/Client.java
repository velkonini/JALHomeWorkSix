import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final int PORT = 2539;
    private final String IP_ADDRES = "localHost";
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client() {
        try {
            socket = new Socket(IP_ADDRES, PORT);
            new ClientTwo(socket, "Клиент");
            while(true){
                if(socket.isClosed()){
                    break;
                }
            }
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new Client();
    }
}
