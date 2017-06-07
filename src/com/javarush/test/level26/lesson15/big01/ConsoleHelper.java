package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.common_en");

    public static void writeMessage(String message) {
        System.out.println(message);

    }

    public static String readString() throws InterruptOperationException {
        String result = null;
        try {
            result = reader.readLine();
            if (result.toLowerCase().equals("exit"))
                throw new InterruptOperationException();
        } catch (IOException e) {

        }
        return result;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String currencyCode;
        writeMessage(res.getString("choose.currency.code"));
        while (true) {
            currencyCode = readString();
            if (currencyCode.length() != 3) {
                writeMessage(res.getString("invalid.data"));
            } else return currencyCode.toUpperCase();
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String[] result;
        writeMessage(res.getString("choose.denomination.and.count.format"));
        while (true) {
            result = readString().split(" ");
            if (result.length != 2)
                writeMessage(res.getString("invalid.data"));
            else if (Integer.parseInt(result[0]) <= 0 || Integer.parseInt(result[1]) <= 0)
                writeMessage(res.getString("invalid.data"));
            else break;
        }
        return result;

    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            writeMessage("choose.operation");
            String string = readString();
            try {
                return Operation.getAllowableOperationByOrdinal(Integer.valueOf(string));
            } catch (IllegalArgumentException e) {

            }
        }

    }

}
//private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//    public static void writeMessage(String message)
//    {
//        System.out.println(message);
//    }
//    public static void printExitMessage()
//    {
//        writeMessage(res.getString("the.end"));
//    }
//
//    public static String askCurrencyCode() throws InterruptOperationException
//    {
//        String s = "";
//        writeMessage(res.getString("choose.currency.code"));
//        s = readString();
//        while (s.length() != 3)
//        {
//            writeMessage(res.getString("invalid.data"));
//            s = readString();
//        }
//        s = s.toUpperCase();
//        return s;
//    }
//
//    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
//    {
//        String[] array;
//        int denomination;
//        int quantity;
//        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
//        while (true)
//        {
//            String s = readString();
//            array = s.split(" ");
//            try
//            {
//                denomination = Integer.parseInt(array[0]);
//                quantity = Integer.parseInt(array[1]);
//                if (denomination <= 0 || quantity <= 0 || array.length > 2)
//                {
//                    writeMessage(res.getString("invalid.data"));
//                    continue;
//                } else break;
//            }
//            catch (Exception e)
//            {
//            }
//            writeMessage(res.getString("invalid.data"));
//        }
//        return array;
//    }
//
//
//    public static String readString() throws InterruptOperationException
//    {
//
//        String line = "";
//        try
//        {
//            line = reader.readLine();
//            if ("EXIT".equalsIgnoreCase(line)){
//                throw new InterruptOperationException();
//            }
//        }
//        catch (IOException ioex)
//        {
//
//        }
//
//        return line;
//    }
//
//    public static Operation askOperation() throws InterruptOperationException
//    {
//        int i = 0;
//        writeMessage("choose.operation");
//        try
//        {
//            i = Integer.parseInt(readString());
//            return Operation.getAllowableOperationByOrdinal(i);
//        }
//
//        catch (IllegalArgumentException aex)
//        {
//            writeMessage(res.getString("invalid.data"));
//            try
//            {
//                i = Integer.parseInt(reader.readLine());
//
//            }
//            catch (IOException ex)
//            {
//            }
//            return Operation.getAllowableOperationByOrdinal(i);
//        }
//    }
//}