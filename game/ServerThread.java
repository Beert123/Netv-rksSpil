package game;
import java.net.*;
import java.io.*;
public class ServerThread extends Thread{
	Socket connSocket;

	
	public ServerThread(Socket connSocket) {
		this.connSocket = connSocket;
		// Til Web-server opgaven skal denne ikke anvendes
	}
	public void run() {
		try {
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connSocket.getOutputStream());
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			String clientSentence;
			String serverAnswer;
			clientSentence = inFromClient.readLine();
			System.out.println(clientSentence + " prøver at kontakte dig, vil du svare? skriv 'OK' eller 'NEJ'");
			serverAnswer = inFromUser.readLine();
			outToClient.writeBytes(serverAnswer + '\n');
			GameLogic.makePlayers(clientSentence);
			while(true){
				String[] playerLoc = inFromClient.readLine().split(",");
				int pos1 = Integer.parseInt(playerLoc[0]);
				int pos2 = Integer.parseInt(playerLoc[1]);
				String dir = playerLoc[2];
				GameLogic.updatePlayer(pos1,pos2,dir);
				System.out.println(playerLoc[0] + " " +  playerLoc[1] + " " + playerLoc[2]);

				String playersString = "";
				for (Player p : GameLogic.players) {
					playersString += p.direction + "," + p.getXpos() + "," + p.getYpos() + "," + p.name + "," + p.point;
					playersString += ":";
				}
				System.out.println(playersString);
				outToClient.writeBytes(playersString + '\n');
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
