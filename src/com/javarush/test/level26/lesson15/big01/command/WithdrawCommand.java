package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;


class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".withdraw");

    @Override
    public void execute() throws InterruptOperationException {
        String askCurrencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(askCurrencyCode);


        while (true) {
            ConsoleHelper.writeMessage(res.getString("before"));
            int sum = 0;
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            sum = Integer.parseInt(ConsoleHelper.readString());
            if (sum < 0) throw new NumberFormatException("Amount must be above zero");
            if (!currencyManipulator.isAmountAvailable(sum)) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
        }
    }
}

//    public void execute() throws InterruptOperationException
//    {
//
//        String code = ConsoleHelper.askCurrencyCode();
//        CurrencyManipulator withdrawManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
//        ConsoleHelper.writeMessage("Please input ammount: ");
//
//
//        int ammount;
//
//        while(true)
//        {
//
//            ConsoleHelper.writeMessage(res.getString("before"));
//            String s = ConsoleHelper.readString();
//            try
//            {
//                ammount = Integer.parseInt(s);
//            } catch (NumberFormatException e)
//            {
//                ConsoleHelper.writeMessage(res.getString("specify.amount"));
//                continue;
//            }
//            if (ammount <= 0)
//            {
//                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
//                continue;
//            }
//            if (!withdrawManipulator.isAmountAvailable(ammount))
//            {
//                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
//                continue;
//            }
//            try
//            {
//                withdrawManipulator.withdrawAmount(ammount);
//            } catch (NotEnoughMoneyException e)
//            {
//                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
//                continue;
//            }
//            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), ammount, code));
//            break;
//        }
//
//    }
//}
