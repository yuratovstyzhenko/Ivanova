package Tovstizhenko.Practice2;

import java.util.Scanner;

public class Text {
    private String str;
    private char array[] = {'0','1','2','3','4','5','6','7','8','9'};
    private int check[];
    private char charStr[];
    private String number = "";
    private int answer;

    public void input(){
        Scanner in = new Scanner(System.in);
        str = in.nextLine();
        check = new int[str.length()];
        charStr = str.toCharArray();
    }
    public void search(){
        for(int i = 0; i < str.length();i++){
            for(int j = 0; j < array.length; j++){
                if(charStr[i] == array[j]){
                    check[i] = 1;
                    break;
                }
                else{
                    check[i] = 0;
                }
            }
        }
    }
    public void calculate(){
        for(int i = 0; i < check.length; i++){
            if(check[i] == 1 && i + 1 == check.length || check[i] == 1 && check[i + 1] != 1){
                number = number + charStr[i];
                answer = answer + Integer.parseInt(number);
                number = "";
            }
            else if(check[i] == 1 && check[i + 1] == 1){
                number = number + charStr[i];
            }
        }
        System.out.print("Answer is : " + answer);
    }
}
