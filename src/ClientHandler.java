import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientUsername;

    public ClientHandler(Socket socket){
        this.socket = socket;
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.clientUsername = bufferedReader.readLine();
        clientHandlers.add(this);
        broadcastMessage("Server", clientUsername + " has joined the chat");
    }
    catch(IOException e){
        closeEverything(socket, bufferedReader, bufferedWriter);
    }


    @Override
    public void run(){

    }

}