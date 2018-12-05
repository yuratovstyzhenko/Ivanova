package Tovstizhenko.Practice4;

import Tovstizhenko.Util;

import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        Administrator administrator = new Administrator("login", "secret");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1 - login as administrator\n2 - login as reader\n3 - create reader");


            String temp = sc.nextLine();
            temp = Util.checkInput(temp, sc);

            System.out.println("Please login( Name )");
            String login = sc.nextLine();
            login = Util.checkInput(login, sc);


            System.out.println("Please password");
            String pass = sc.nextLine();
            pass = Util.checkInput(pass, sc);


            switch (temp) {
                case "1": {

                    boolean check = true;
                    while (check) {
                        if (!login.equals(administrator.getLogin()) && !pass.equals(administrator.getPassword())) {
                            System.out.println("Wrong login or password.");
                            break;
                        }
                        System.out.println("1 - View all Readers\n2 - Add Edition\n3 - View all payments\n4 - logout");
                        temp = sc.nextLine();
                        temp = Util.checkInput(temp, sc);
                        switch (temp) {
                            case "1": {
                                if(administrator.getReaders().size()==0){
                                    System.out.println("No Readers");
                                    break;
                                }
                                administrator.getReaders().forEach(System.out::println);
                                System.out.println();
                                break;
                            }
                            case "2": {
                                System.out.println("Please name");
                                String name = sc.nextLine();
                                name = Util.checkInput(name, sc);

                                System.out.println("Please editor");
                                String editor = sc.nextLine();
                                editor = Util.checkInput(editor, sc);


                                System.out.println("Please price");
                                String price = sc.nextLine();
                                price = Util.checkInput(price, sc);

                                administrator.addEdition(new Edition(name, editor, Double.valueOf(price)));
                                break;
                            }
                            case "3": {
                                if(administrator.getPayments().size()==0){
                                    System.out.println("No payments");
                                }
                                administrator.getPayments().forEach(System.out::println);
                                System.out.println();
                                break;
                            }

                            case "4": {
                                check = false;
                                break;
                            }
                        }

                    }
                    break;
                }
                case "2": {
                    Reader reader = administrator.verifyReader(login, pass);
                    if (reader == null) {
                        System.out.println("Wrong login or password");
                        break;
                    }
                    boolean check = true;
                    while (check) {
                        System.out.println("1 - View all my subscriptions\n2 - Create new subscription\n3 - logout");
                        temp = sc.nextLine();
                        temp = Util.checkInput(temp, sc);
                        switch (temp) {
                            case "1": {
                                if(reader.getSubs().size()==0){
                                    System.out.println("No subscriptions");
                                }
                                reader.getSubs().forEach(System.out::println);
                                break;
                            }
                            case "2": {
                                administrator.createSubscription(sc, reader);
                                break;
                            }
                            case "3": {
                                check = false;
                                break;
                            }
                        }
                    }

                    break;
                }
                case "3":{
                    administrator.addReader(new Reader(login,pass));
                    System.out.println("Congratulations! Reader created. Log in");
                    System.out.println();
                    break;
                }
            }
        }


    }

}
