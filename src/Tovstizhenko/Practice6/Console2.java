package Tovstizhenko.Practice6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IgorPc on 11/11/2018.
 */
public class Console2 {
    private static List<String> strings=new ArrayList<>();
    private static List<Double> doubleDigits=new ArrayList<>();
    private static List<Integer> integers=new ArrayList<>();
    public static void main(String[] args)  {
        Scanner scanner=new Scanner(System.in);
        while (true) {
            try {


                System.out.println("Please path to file");
                String path = scanner.nextLine();
                System.out.println();

                String text = readText(path);

                System.out.println("Please choose type: 1 - String; 2 - Integer; 3 - Double");
                String type = scanner.nextLine();
                System.out.println();

                switch (type){
                    case "1":{
                        findStrings(text);
                        for (String string : strings) {
                            System.out.println(string);
                        }
                        break;
                    }
                    case "2":{
                        findIntegers(text);
                        for (Integer integer : integers) {
                            System.out.println(integer);
                        }
                        break;
                    }
                    case "3":{
                        findDoubleDigits(text);
                        for (Double doubleDigit : doubleDigits) {
                            System.out.println(doubleDigit);
                        }

                    }

                }

              break;
            } catch (FileNotFoundException e) {
                System.out.println("No file. Please try another path");
            } catch (IOException e) {
                System.out.println("No file. Please try another path");
            }

        }
    }


    private static String readText(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        StringBuilder sb = new StringBuilder();

        String temp = null;
        while ((temp = bufferedReader.readLine()) != null) {
            sb.append(temp).append("\n");
        }
        return sb.toString();
    }

    private static void findStrings(String text){
        Pattern p = Pattern.compile("[a-zA-Z]{1,}");

        Matcher m1 = p.matcher(text);


        while (m1.find()) {
            String word = m1.group();
          strings.add(word);
        }
    }

    private static String findDoubleDigits(String text){
        Pattern p = Pattern.compile("[0-9]+[.][0-9]+");

        Matcher m1 = p.matcher(text);


        while (m1.find()) {
            String word = m1.group();
            doubleDigits.add(Double.valueOf(word));
            text=text.replace(word,"");
        }
        return text;
    }
    private static void findIntegers(String text){
        Pattern p = Pattern.compile("[0-9]+");
        text=findDoubleDigits(text);
        Matcher m1 = p.matcher(text);



        while (m1.find()) {
            String word = m1.group();
            integers.add(Integer.valueOf(word));
        }
    }
}
