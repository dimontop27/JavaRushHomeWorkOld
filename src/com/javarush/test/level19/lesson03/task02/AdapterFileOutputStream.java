package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream OutputStream;
    AdapterFileOutputStream(FileOutputStream OutputStream){
        this.OutputStream = OutputStream;
    }

    @Override
    public void flush() throws IOException
    {
        OutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {
        OutputStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException
    {
        OutputStream.close();
    }
}

