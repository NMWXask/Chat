package random_generator;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread{

    private static Socket socket;
    public ClientThread(Socket socket) {
        ClientThread.socket = socket;
    }
    public void run(){

        try (
             var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             var writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             PrintWriter out = new PrintWriter(writer, true);
             var keyboardReader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                String name = keyboardReader.readLine();
                String password = keyboardReader.readLine();
                out.println(name);
                out.println(password);
                String serverResponse = reader.readLine();
                if(serverResponse.equals("ok")){
                    break;
                }
                else {
                    System.out.println("Не правильно введены логин или пароль.");
                }
            }


            while (true) {
                String message = reader.readLine();//принимаем сообщение от сервера
                System.out.println(message);//выводим себе на экран сообщение
                String response = keyboardReader.readLine();
                out.println(response);
                if (response.equalsIgnoreCase("stop")) {
                    break;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
