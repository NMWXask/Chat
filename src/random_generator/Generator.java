package random_generator;

import java.util.Random;
/*
Создайте серверное приложение «Генератор цитат» и клиента для получения данных.
 При запросе (любом или стандартизованном) клиента серверное приложение должно вернуть случайную цитату.
 Процесс должен продолжаться до тех пор, пока клиент не захочет отсоединиться. К одному серверу в один
  момент времени может быть подключено большое количество клиентов.
Добавьте ограничение по максимальному количеству цитат для пользователя.
 Когда количество достигнуто, сервер сообщает клиенту об этом и разрывает соединение.
Добавьте пароль и имя пользователя для подключения. Если пароль и имя пользователя неизвестны,
 клиент подключиться не может.
Сервер ведет лог соединений:
■ Кто подключился;
■ Когда подключился;
■ Выдачу цитат;
■ Время отключения.
Клиентское приложение отображает пользователю полученные цитаты (в консоли).
 Архитектура вашего приложения должна быть построена без привязки сетевой части к UI.
  Это означает, что сетевой блок кода может быть легко перемещен в любой вид приложения: консольное, оконное.

 */

public final class Generator {
    public static String getRandomPhrase(){
        Random random = new Random();

        StringBuilder builder = new StringBuilder();

            String [] words = {"улица", "фонарь", "аптека", "шар", "огонь", "хромой","отвага",
                    "слабоумие","котики","нарцисс","тридцать восемь","кирпич","деревянный","стекло",
                    "свитшот","зачем","джексон","деловой","вагон","кровать","смартфон","дятел"};

            for (int i = 0; i < (words.length); i++) {
                builder.append(words[random.nextInt(0, words.length-1)]).append(", ");
            }


            return builder.toString();
    }
}
