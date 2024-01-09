package random_generator;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    final static String IP = "localhost";
    final static int PORT = 8081;

    public static void main(String[] args) {
        try (var socket = new Socket(IP, PORT);
             var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             var writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             PrintWriter out = new PrintWriter(writer);
             var scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String message = reader.readLine();//принимаем сообщение от сервера
                System.out.println(message);//выводим себе на экран сообщение
            out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
