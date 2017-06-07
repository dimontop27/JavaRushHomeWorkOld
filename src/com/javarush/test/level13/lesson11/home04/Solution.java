package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        OutputStream outStream = new FileOutputStream(filename);
        while (true)
        {
            String string = reader.readLine();
            if (string.equals("exit"))
            {
                outStream.write(string.getBytes());
                break;
            }
            else
            {
                outStream.write((string + "\r\n").getBytes());
            }
        }
        outStream.close();
        reader.close();


    }
}
