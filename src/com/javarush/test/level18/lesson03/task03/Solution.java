package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/


public class Solution{
    public static void main(String[] args) throws Exception    {
        BufferedReader filereader = new BufferedReader(new InputStreamReader(System.in));
        String filename = filereader.readLine();
        Map<Byte, Integer> bytesort = new HashMap<>();
        filereader.close();
        FileInputStream inputStream = new FileInputStream(filename);
        byte[] buffer = new byte[inputStream.available()];
        if (inputStream.available() > 0)        {
            inputStream.read(buffer);
        }
        inputStream.close();
        for (byte c : buffer)
        {
            int count = 0;
            for (byte c1 : buffer)
            {
                if (c == c1)
                    count++;
            }
            bytesort.put(c, count);
        }
        int Maxbyte = 0;
        for (Map.Entry<Byte, Integer> pair : bytesort.entrySet())
        {
            if (pair.getValue() > Maxbyte)
                Maxbyte = pair.getValue();
        }
        for (Map.Entry<Byte, Integer> pair : bytesort.entrySet())
        {
            if (pair.getValue().equals(Maxbyte))
                System.out.print(pair.getKey() + " ");
        }
    }
}
