package pl.mgorecki.student.mcalculator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * Created by emigore on 2017-03-16.
 */
public class StringToListConverter {

    public static ArrayList<String> convertStringToList(String input){
        ArrayList<String> outputList = new ArrayList<String>();
        input = input.replaceAll("\\+"," + ")
                .replaceAll("\\-"," - ")
                .replaceAll("\\*"," * ")
                .replaceAll("\\/"," / ")
                .replaceAll("\\("," ( ")
                .replaceAll("\\)"," ) ")
                .replaceAll("\\^"," ^ ")
                .replaceAll("cos"," cos ")
                .replaceAll("sin"," sin ")
                .replaceAll("ln"," ln ")
                .replaceAll("sqrt"," sqrt ")
                .replaceAll("log"," log ");
        StringTokenizer tokenizer = new StringTokenizer(input);
        while(tokenizer.hasMoreTokens()){
            outputList.add(tokenizer.nextToken());
        }
        return outputList;
    }

}
