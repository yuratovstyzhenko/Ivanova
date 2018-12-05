package Tovstizhenko.Practice4;

import java.util.Date;

public class Subscription {
    private Edition edition;
    private Reader reader;
    private Date endData;

    public Subscription(Edition edition, Reader reader) {
        this.edition = edition;
        this.reader = reader;
        endData=new Date();

    }

    public Subscription(){
        endData=new Date();
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getEndData() {
        return endData;
    }

    public void setEndData(Date endData) {
        this.endData = endData;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Reader ").append(reader.getName()).append(" signed on ").append(edition.getName())
                .append(" . End date is ").append(endData);
        return sb.toString();
    }
}
