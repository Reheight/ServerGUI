package me.reheight.servergui.events;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class retrieveServerStatus {
    public static boolean online(String server) {
        if (server.equalsIgnoreCase("Factions")) {
            try {
                Socket socket = new Socket("127.0.0.1", 19582);
                socket.close();
                return true;
            } catch (UnknownHostException e) {
                return false;
            } catch (IOException e) {
                return false;
            }
        }

        if (server.equalsIgnoreCase("Lobby")) {
            try {
                Socket socket = new Socket("127.0.0.1", 38928);
                socket.close();
                return true;
            } catch (UnknownHostException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        if (server.equalsIgnoreCase("Cannon")) {
            try {
                Socket socket = new Socket("127.0.0.1", 27489);
                socket.close();
                return true;
            } catch (UnknownHostException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        if (server.equalsIgnoreCase("KitPvP")) {
            try {
                Socket socket = new Socket("127.0.0.1", 28573);
                socket.close();
                return true;
            } catch (UnknownHostException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

}
