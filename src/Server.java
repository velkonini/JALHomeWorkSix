import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        DataInputStream in;
        DataOutputStream out;

        final int PORT = 2539;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");

            socket = server.accept();
            System.out.println("Клиет подключился");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            while (true){
                String str = in.readUTF();
                if(str.equals("/end")){
                    break;
                }

                System.out.println("Клиент: " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
