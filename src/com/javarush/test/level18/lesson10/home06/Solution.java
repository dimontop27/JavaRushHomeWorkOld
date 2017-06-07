package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> result = new TreeMap<>();
        String fileName = args[0];
        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0) {
            int ansiChar = fileInputStream.read();
            if (result.containsKey(ansiChar)) {
                result.put(ansiChar, result.get(ansiChar) + 1);
            } else
                result.put(ansiChar, 1);
        }
        for (Map.Entry<Integer, Integer> pair : result.entrySet()) {
            int key = pair.getKey();
            int value = pair.getValue();
            System.out.println((char) key + " " + value);
        }
        fileInputStream.close();

        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        InputStreamReader in = new InputStreamReader(new FileInputStream(filename));
        int ch = in.read();
        while (ch != -1){
            if (result.containsKey(ch)){
                int count = result.get(ch)+ 1;
                result.put(ch, count);
            } else
                result.put(ch, 1);
            ch = in.read();
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : result.entrySet()){
            System.out.println(Character.toChars(integerIntegerEntry.getKey()) + " " + integerIntegerEntry.getValue());
            reader.close();
            in.close();
        }*/
    }
}
