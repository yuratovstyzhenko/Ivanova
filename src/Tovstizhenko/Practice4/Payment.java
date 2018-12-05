package Tovstizhenko.Practice4;

import java.util.Date;

public class Payment {
    private Date date;
    private Subscription subs;

    public Payment(Date date, Subscription subs) {
        this.date = date;
        this.subs = subs;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Subscription getSubs() {
        return subs;
    }

    public void setSubs(Subscription subs) {
        this.subs = subs;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Payment was created at ").append(date).append(" . Subscription - [ ").append(subs)
                .append(" ] ");
        return stringBuilder.toString();
    }
}
