package Tovstizhenko.Practice3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie {
    private String name;
    private String genre;
    private String director;
    private List<String> cinemas=new ArrayList<>();
    private Date date;
    private double averagePrice;
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getCinemas() {
        return cinemas;
    }

    public void addCinema(String cinema) {
        this.cinemas.add(cinema);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Cinema - ").append(name).append(". Genre - ").append(genre).append(". Director - ")
                .append(director).append(". Cinemas - ").append(cinemas).append(". Start time - ")
                .append(date).append(". Average price - ").append(averagePrice).append(". Actors - ")
                .append(quantity);
        return sb.toString();
    }
}

