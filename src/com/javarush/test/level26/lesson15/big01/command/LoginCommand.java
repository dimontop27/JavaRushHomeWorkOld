package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {

    private ResourceBundle validCreditCards = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".info");

  @Override
    public void execute() throws InterruptOperationException {
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String s1 = ConsoleHelper.readString();
            String s2 = ConsoleHelper.readString();
            try {
                if (s1.length() != 12 || s2.length() != 4) {
                    ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                    continue;
                }
                if (validCreditCards.containsKey(s1) && validCreditCards.getString(s1).equals(s2)) {
                    break;

                } else
                    ConsoleHelper.writeMessage(String.format(res.getString("Credit card [%s] is not verified"), s1));
                continue;
            } catch (Exception e) {
            }
            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
        }
    }
}

//  String newCardNumber;
//    String newPinCode;
//
//
//
//    public void execute() throws InterruptOperationException{
//
//        while(true){
//            ConsoleHelper.writeMessage(res.getString("specify.data"));
//
//
//            newCardNumber = ConsoleHelper.readString();
//            newPinCode = ConsoleHelper.readString();
//            try
//            {
//                if(newCardNumber.length() != 12 || newPinCode.length() != 4){
//                    ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
//                    continue;
//                }
//
//                if ( validCreditCards.containsKey(newCardNumber) &&  validCreditCards.getString(newCardNumber).equals(newPinCode) )
//                {
//                    break;
//
//                } else ConsoleHelper.writeMessage(String.format(res.getString("Credit card [%s] is not verified"), newCardNumber));
//                continue;
//            }
//            catch (Exception e)
//            {
//            }
//            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
//        }
//        ConsoleHelper.writeMessage(String.format(res.getString("success.format"),newCardNumber ));
//    }
//
//}
