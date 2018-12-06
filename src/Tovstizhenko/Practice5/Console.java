package Tovstizhenko.Practice5;

import Tovstizhenko.Practice5.Exceptions.MyPriceException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please quantity of movies");
        String temp=null;
        int q =0;
        while (true) {
            try {
                temp=sc.nextLine();
                temp=checkInput(temp,sc);

                q = Integer.valueOf(temp);
                break;
            }catch (NumberFormatException ex){
                System.out.println("Please input numbers");
            }
        }
        Movie[] movies=new Movie[q];

        for(int i=0;i<q;i++){
            Movie movie=new Movie();

            System.out.println("Please Name");
           String  name=sc.nextLine();
            name=checkInput(name,sc);
            movie.setName(name);

            System.out.println("Please Genre");
            String genre=sc.nextLine();
            genre=checkInput(genre,sc);
            movie.setGenre(genre);

            System.out.println("Please Director");
            String director=sc.nextLine();
            director=checkInput(director,sc);
            movie.setDirector(director);

            System.out.println("Please cinemas(write \"end\" for break)");
            while (true) {
                temp = sc.nextLine();
                temp = checkInput(temp, sc);
                if(temp.equalsIgnoreCase("end")){
                    break;
                }
                movie.addCinema(temp);
            }

             while(true) {
                try {
                    System.out.println("Start Date (format 31.05.1999)");
                    DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                    String s = sc.nextLine();
                    s = checkInput(s, sc);
                    Date date = df.parse(s);
                    GregorianCalendar cal = new GregorianCalendar();
                    cal.setTime(date);
                    movie.setDate(cal.getTime());
                    break;
                }catch (ParseException ex){
                    System.out.println("Please input correct format.");
                }
             }
             while (true) {
                try {


                    System.out.println("Please average price (format 57.11)");
                    double v = sc.nextDouble();
                    if(v<0){
                        throw new MyPriceException();
                    }
                    movie.setAveragePrice(v);

                    System.out.println("Please quantity of actors");
                    movie.setQuantity(sc.nextInt());
                    movies[i] = movie;
                    break;
                }catch (InputMismatchException in)
                {
                    System.out.println("Please numbers. Try again");
                    sc.nextLine();
                } catch (MyPriceException e) {
                    System.out.println("Please input positive number");
                }
             }
        }




        System.out.println("Please name of movie");
        temp=sc.nextLine();
        temp=checkInput(temp,sc);
        listOfCinemasforMovie(temp,movies);


        System.out.println("Please name of director");
        temp=sc.nextLine();
        temp=checkInput(temp,sc);
        listOfMoviesByDirector(temp,movies);

        Date date=null;

        while(true) {
            try {
                System.out.println("Please start Date (format 31.05.1999)");
                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                String s=sc.nextLine();
                s=checkInput(s,sc);
                date = df.parse(s);
                break;
            }catch (ParseException ex){
                System.out.println("Please input correct format.");
            }
        }


        System.out.println("Please name of cinema");
        temp=sc.nextLine();
        temp=checkInput(temp,sc);

        listOfMoviesAfterDateAndCinema(temp,movies,date);




    }

    private static void listOfCinemasforMovie(String name,Movie[] movies){
        boolean check=true;

        for (Movie movie : movies) {
            if(movie.getName().equalsIgnoreCase(name)){
                System.out.println(movie.getCinemas());
                check=false;
                break;
            }
        }
        if(check){
            System.out.println("No film with name "+name);
        }


    }

    private static void listOfMoviesByDirector(String name,Movie[] movies){
        boolean check=true;

        for (Movie movie : movies) {
            if(movie.getDirector().equalsIgnoreCase(name)){
                System.out.println(movie);
                check=false;
            }
        }
        if(check){
            System.out.println("No films by  "+name);
        }


    }



    private static void listOfMoviesAfterDateAndCinema(String cinema,Movie[] movies,Date date){
        boolean check=true;

        for (Movie movie : movies) {
            if(movie.getCinemas().contains(cinema)&&movie.getDate().after(date)){
                System.out.println(movie);
                check=false;
            }
        }
        if(check){
            System.out.println("No films ");
        }


    }

    private static String checkInput(String text, Scanner sc){
        if(text.equalsIgnoreCase("")){
            text=sc.nextLine();
            return checkInput(text,sc);

        }
        return text;
    }
}
