package game;

import javafx.application.Application;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class TCPClient {
    public static DataOutputStream outToServer;
    public static BufferedReader inFromServer;

    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("127.0.0.1", 6789);
        outToServer = new DataOutputStream(clientSocket.getOutputStream());
        inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));


        /*
        ArrayList<Player> players = new ArrayList<>();
        String[] test = playersString.split(":");
        System.out.println(test[0]);

        System.out.println(playersString + "This is playerString");
        System.out.println(test[0] + test[1] + test[2] + test[3] + "");

 */

      //  Player newPlayer = new Player(test[0],new pair(),test[2]);
        System.out.println("Indtast spillernavn");
        String modifiedSentence = "";
        String navn = inFromUser.readLine();
        outToServer.writeBytes(navn + '\n');
        modifiedSentence = inFromServer.readLine();
            GameLogic.makePlayers(navn);

        if (modifiedSentence.equals("OK")) {
            System.out.println("Server accepterede, start med at chatte");

            Application.launch(Gui.class);
        }

    }
}
