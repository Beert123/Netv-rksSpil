package game;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ClientThread extends Thread{
        BufferedReader bufferedReader;
        String line;
        public ClientThread(BufferedReader bufferedReader) {
            this.bufferedReader = bufferedReader;
        }
        public void run() {
            try {
                while(true) {
                    for (Player player : modtagPlayer()) {
                        Pair tempPair = new Pair(player.getXpos(),player.getYpos());
                        Gui.placePlayerOnScreen(tempPair,player.direction);
                        Pair oldPair = tempPair;
                    }
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        public ArrayList<Player> modtagPlayer() throws IOException {
            ArrayList<Player> players = new ArrayList<>();
            line = bufferedReader.readLine();
            String[] playerss = line.split(":");
            for (String s : playerss) {
                String[] temp = s.split(",");
                Player player = new Player(temp[3],new Pair(Integer.parseInt(temp[1]),Integer.parseInt(temp[2])),temp[0]);
                players.add(player);
                player = null;
            }
            return players;
        }
    }
