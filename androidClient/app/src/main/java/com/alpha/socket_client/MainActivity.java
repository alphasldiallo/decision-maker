package com.alpha.socket_client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    private Button b1;
    private Button b2;
    private Button b3;
    private Button shuffle;
    private Switch red;
    private Switch green;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Dirty code
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new ClientThread()).start();


    }

    class ClientThread implements Runnable {

        @Override
        public void run() {
                b1 = (Button) findViewById(R.id.b1);
                b2 = (Button) findViewById(R.id.b2);
                b3 = (Button) findViewById(R.id.b3);
                shuffle = (Button) findViewById(R.id.random);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        InetAddress serverAddr = InetAddress.getByName("192.168.0.224");
                        Socket socket = new Socket(serverAddr, 1223);
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        out.print("0");
                        out.flush();
                        out.close();
                        socket.close();
                    } catch (UnknownHostException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        InetAddress serverAddr = InetAddress.getByName("192.168.0.224");
                        Socket socket = new Socket(serverAddr, 1223);
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        out.print("90");
                        out.flush();
                        out.close();
                        socket.close();
                    } catch (UnknownHostException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        InetAddress serverAddr = InetAddress.getByName("192.168.0.224");
                        Socket socket = new Socket(serverAddr, 1223);
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        out.print("180");
                        out.flush();
                        out.close();
                        socket.close();
                    } catch (UnknownHostException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            shuffle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        InetAddress serverAddr = InetAddress.getByName("192.168.0.224");
                        Socket socket = new Socket(serverAddr, 1223);
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        out.print("Shuffle");
                        out.flush();
                        out.close();
                        socket.close();
                    } catch (UnknownHostException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
