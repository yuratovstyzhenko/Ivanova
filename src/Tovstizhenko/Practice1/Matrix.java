package Tovstizhenko.Practice1;

import java.util.Scanner;

public class Matrix {

    private long[] [] array;
    private int str;
    private int SizeI;
    private int SizeJ;

    public void input(){
        Scanner in = new Scanner(System.in);
        SizeI = in.nextInt();
        SizeJ = SizeI;
        array = new long[SizeI][SizeJ];
        for(int i = 0; i < SizeI; i++) {
            for (int j = 0; j < SizeJ; j++) {
                array[i][j] = (long)(Math.random() * 100);
            }
        }
    }
    public void output(){
        for(int i = 0; i < SizeI; i++) {
            if(array[i] != null) {

                for (int j = 0; j < SizeJ; j++) {

                    System.out.printf("%3d ", array[i][j]);
                }
                System.out.println();
            }
        }
    }
    public void searchMin() {
        long Min;
        str = 0;
        Min = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                if (array[i][j] < Min) {
                    Min = array[i][j];
                    str = i;
                } else {
                    continue;
                }
            }
        }
        System.out.println("Min : " + Min);
    }
    public void deleting(){
        for (int i = str; i < SizeI - 1; i++){
            for(int j = 0; j < SizeJ; j++){
                array[i][j] = array[i + 1][j];
            }
        }
            array[SizeI - 1] = null ;
        // SizeI--;
    }
}