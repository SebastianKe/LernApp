package com.example.lernapp;

import android.os.AsyncTask;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Philipp on 09.06.2017.
 */

public class Client extends AsyncTask<Integer, Integer, int[]> {
    // Port der Serveranwendung
    public static final int SERVER_PORT = 10001;
    // Rechnername des Servers
    public static final String SERVER_HOSTNAME = "10.0.2.2";

    // Serverkommunikation - wird durch Funktionsaufruf execute aufgerufen
    @Override
    protected int[] doInBackground(Integer... params) {
        int[]erg=new int[15];
        try
        {
            // Erzeugen des Socket und Aufbau der Verbindung
            Socket socket = new Socket (
                    SERVER_HOSTNAME, SERVER_PORT);
            System.out.println ("Verbunden mit Server: " +
                    socket.getRemoteSocketAddress());
            String nachricht = "Mult";
            System.out.println ("Sende Nachricht: " +nachricht);
            // Senden der Nachricht über einen Stream
            ObjectOutputStream streamOut = new ObjectOutputStream(socket.getOutputStream());
            streamOut.writeObject(nachricht);
            ObjectInputStream streamIn = new ObjectInputStream(socket.getInputStream());
            erg=(int[]) streamIn.readObject();
            // Beenden der Kommunikationsverbindung
            socket.close();
        }
        catch (UnknownHostException e)
        {
            // Wenn Rechnername nicht bekannt ist ...
            System.out.println ("Rechnername unbekannt:\n" +
                    e.getMessage());
        }
        catch (IOException e)
        {
            // Wenn die Kommunikation fehlschlägt
            System.out.println ("Fehler während der Kommunikation:\n" +
                    e.getMessage());
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return erg;
    }
}
