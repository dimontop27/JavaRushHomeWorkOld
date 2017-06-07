package com.javarush.test.level22.lesson09.task02;

import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder result = new StringBuilder("");
        for (Map.Entry<String, String> pair : params.entrySet()) {
            try {
                if (!pair.getValue().equals(null)) {
                    if (result.toString().length() > 1) {
                        result.append(" and ");
                    }
                    result.append(pair.getKey() + " = \'")
                            .append(pair.getValue() + "\'");
                }
            } catch (NullPointerException e) {
            }

        }
        return result;
    }
}
