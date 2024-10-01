package game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
    public class ClientThread extends Thread{
        BufferedReader bufferedReader;
        public ClientThread(BufferedReader bufferedReader) {
            this.bufferedReader = bufferedReader;
        }
        public void run(){
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(System.in));

            try {
                System.out.println(inFromServer.readLine());
            }
            catch (Exception e){
                e.printStackTrace();

            }
        }
    }
