// Дана json строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсить json и, используя StringBuilder, создаст строки вида: 
// Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

package hw2_java;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class task_3 {
    public static void main(String[] args) {

        StringBuilder allTxt = new StringBuilder();

        try {

            JSONParser parser = new JSONParser();
            JSONArray a = (JSONArray) parser.parse(new FileReader("text.json", StandardCharsets.UTF_8));

            for (Object o : a) {
                JSONObject object = (JSONObject) o;

                String surname = (String) object.get("фамилия");
                String mark = (String) object.get("оценка");
                String discipline = (String) object.get("предмет");

                allTxt.setLength(0);
                allTxt.append("Студент ").append(surname).append(" получил ").append(mark);
                allTxt.append(" по предмету ").append(discipline).append(".");

                System.out.println(allTxt);
            }
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }

    }
}