import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket socket = null;

    private ServerSocket server = null;
    private DataInputStream input = null;

    public Server (int port) throws IOException {
        server = new ServerSocket(port);//Server Acma
        System.out.println("Sunucu Baslatıldı");
        System.out.println("Bir client bekleniyor...");

        socket = server.accept();

        System.out.println("Client kabul edildi");

        //Client soketinden girdi alınıyor
        input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        String metin = "";
        while (!metin.equals("Bitti")){
            try {
                metin = input.readUTF();
                System.out.println(metin);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Baglantı sonlandırılıyor...");
        input.close();
        socket.close();
        System.out.println("Baglantı sonlandırıldı");



    }

    public static void main(String[] args) throws IOException{

        Server server =new Server(5000);

    }
}
