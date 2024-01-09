package random_generator;

import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try (var serverSocket = new ServerSocket(8081);
        var socket = serverSocket.accept();
        var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        var writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        PrintWriter out = new PrintWriter(writer)
        ) {

            String request = null;//запрос от клиента, то что он пишет

            String randomPhrase = null;//фраза, которую генерирует метод.

            while (!reader.readLine().isEmpty()) {

                    randomPhrase = Generator.getRandomPhrase();//присваиваем фразу
                    out.println(randomPhrase);//отправляем сообщением данную фразу
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
