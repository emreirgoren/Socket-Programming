import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    public Client(String address, int port) throws IOException, UnknownHostException {
        //baglantı kurmak

        socket = new Socket(address,port);
        System.out.println("Client sunucuya baglandı");

        input = new DataInputStream(System.in);
        output = new DataOutputStream(socket.getOutputStream());

        String metin = "";
        while (!metin.equals("Bitti")){
            try {
                metin = input.readLine();
                output.writeUTF(metin);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        input.close();
        output.close();
        socket.close();

    }

    public static void main(String[] args) throws IOException{

        Client client = new Client("127.0.0.1",5000);

    }
}
