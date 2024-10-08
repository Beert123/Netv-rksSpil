package game;

import javafx.util.Pair;

import java.io.BufferedReader;
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
                    line = bufferedReader.readLine();
                    System.out.println(line);
                    String[] players = line.split(":");
                    for (String player : players) {
                        String[] pos = player.split(",");

                        pair pair = new pair(Integer.parseInt(pos[1]),Integer.parseInt(pos[2]));

                        Gui.placePlayerOnScreen(pair,pos[0]);
                        pair oldPair = pair;
                        Gui.removePlayerOnScreen(oldPair);
                    }
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        public static ArrayList<Player> modtagPlayer(){
            ArrayList<Player> players = new ArrayList<>();


            return players;
        }
    }
