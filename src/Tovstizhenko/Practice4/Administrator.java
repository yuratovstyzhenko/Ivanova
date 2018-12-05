package Tovstizhenko.Practice4;

import Tovstizhenko.Util;

import java.util.*;

public class Administrator {
    private List<Edition> editions=new ArrayList<>();
    private List<Reader> readers=new ArrayList<>();
    private List<Payment> payments=new ArrayList<>();
    private String login;
    private String password;

    public Administrator(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public void createSubscription(Scanner scanner,Reader reader){
        if(editions.size()==0){
            System.out.println("No edetions at the moment");
            return;
        }
        System.out.println("Choose edition");
        for(int i=0;i<editions.size();i++){
            System.out.println((i+1)+"."+editions.get(i));
        }
        String pos=scanner.nextLine();
        pos= Util.checkInput(pos,scanner);
        Edition edition=editions.get(Integer.valueOf(pos)-1);
        Subscription subscription=new Subscription();
        subscription.setEdition(edition);
        subscription.setReader(reader);


        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, 1);
        subscription.setEndData( c.getTime());
        edition.addSubscription(subscription);
        payments.add(new Payment(new Date(),subscription));
        reader.addSubs(subscription);
        System.out.println("Congratulations. You bought subscription");
    }

    public Reader verifyReader(String login,String password){
        for (Reader reader : readers) {
            if(reader.getName().equals(login)&&reader.getPass().equals(password)){
                return reader;
            }
        }
        return null;

    }





    public List<Edition> getEditions() {
        return editions;
    }

    public void addEdition(Edition edition) {
        this.editions.add( edition);
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void addReader(Reader reader) {
        this.readers.add(reader);
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void addPayment(Payment payment) {
        this.payments.add(payment);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
