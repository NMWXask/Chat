package random_generator;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {

        try (var serverSocket = new ServerSocket(8080);
        var socket = serverSocket.accept();
        var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        var writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        PrintWriter out = new PrintWriter(writer,true)
        ) {



            String request = null;//запрос от клиента, то что он пишет

            String randomPhrase = null;//фраза, которую генерирует метод.

            while (true) {
                    randomPhrase = Generator.getRandomPhrase();//присваиваем фразу
                    out.println(randomPhrase);//отправляем сообщением данную фразу
                    request = reader.readLine();
                    if(request.equalsIgnoreCase("stop")){
                        break;
                    }
                System.out.println(request);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
