package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
        String name = "";
        String birthDay = "";
        while (reader.ready()) {
            String[] s = reader.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                birthDay = s[s.length - 3] + " " + s[s.length - 2] + " " + s[s.length - 1];
                if (s.length == 4) {
                    name = s[0];
                } else if (s.length == 5) {
                    name = s[0] + " " + s[1];
                } else if (s.length == 6) {
                    name = s[0] + " " + s[1] + " " + s[2];
                }

            }
            PEOPLE.add(new Person(name, simpleDateFormat.parse(birthDay)));
        }
        reader.close();
    }

}
