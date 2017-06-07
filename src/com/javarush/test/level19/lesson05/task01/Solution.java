package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        FileReader filereader = new FileReader(filename1);
        FileWriter writer = new FileWriter(filename2);

        int count = 0;
        while (filereader.ready())
        {
            count++;
            int data = filereader.read();
            if (count % 2 == 0)
            {
                writer.write(data);
            }
        }
        filereader.close();
        writer.close();
    }
}
