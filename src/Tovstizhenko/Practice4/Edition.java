package Tovstizhenko.Practice4;

import java.util.ArrayList;
import java.util.List;

public class Edition {
    private String name;
    private String editor;
    private double price;
    private List<Subscription> subscriptions=new ArrayList<>();

    public Edition(String name, String editor, double price) {
        this.name = name;
        this.editor = editor;
        this.price = price;
    }

    public Edition() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void addSubscription(Subscription subscription) {
        this.subscriptions.add(subscription);
    }

    @Override
    public String toString() {
        return name+" - "+editor+" . Price is "+price;
    }
}
