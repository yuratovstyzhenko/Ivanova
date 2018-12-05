package Tovstizhenko.Practice4;

import java.util.ArrayList;
import java.util.List;

public class Reader {
    private String name;
    private List<Subscription> subs=new ArrayList<>();
    private String pass;

    public Reader(String name,String pass) {
        this.pass = pass;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subscription> getSubs() {
        return subs;
    }

    public void addSubs(Subscription subs) {
        this.subs.add(subs);
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {

        return name ;
    }
}
