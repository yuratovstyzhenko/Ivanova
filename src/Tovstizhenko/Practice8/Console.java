package Tovstizhenko.Practice8;

import java.util.*;

public class Console {
    private static List<Integer> list1=new ArrayList<>();
    private static List<Integer> list2=new ArrayList<>();


    public static void main(String[] args) {
        populate();
        System.out.println("First list");
        System.out.println(list1);
        System.out.println();
        System.out.println("Second List");
        System.out.println(list2);
        System.out.println();
        System.out.println("Result");
        list1.retainAll(list2);

        System.out.println(list1);

    }



    private static void populate(){
        Random random=new Random();
        for(int i=0;i<20;i++){
            list1.add(random.nextInt(20));
            list2.add(random.nextInt(20));
        }
    }
}
