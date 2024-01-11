package random_generator;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    final static String IP = "localhost";
    final static int PORT = 8080;

    public static void main(String[] args) {
        try (var socket = new Socket(IP, PORT);
             var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             var writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             PrintWriter out = new PrintWriter(writer,true);
             var keyboardReader = new BufferedReader(new InputStreamReader(System.in))) {


            while (true) {
                String message = reader.readLine();//принимаем сообщение от сервера
                System.out.println(message);//выводим себе на экран сообщение
                String response = keyboardReader.readLine();
                out.println(response);
                if(response.equalsIgnoreCase("stop")){
                    break;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
