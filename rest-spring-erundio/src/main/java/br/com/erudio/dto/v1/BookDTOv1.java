package br.com.erudio.dto.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonPropertyOrder({"id", "author", "launch_date", "price", "title"})
public class BookDTOv1 extends RepresentationModel<BookDTOv1> implements Serializable {

    @JsonProperty("id")
    private Long key;

    private String author;
    @JsonProperty("launch_date")
    private Date launchDate;
    private Double price;
    private String title;

    public BookDTOv1() {
    }

    public BookDTOv1(Long key, String author, Date launchDate, Double price, String title) {
        this.key = key;
        this.author = author;
        this.launchDate = launchDate;
        this.price = price;
        this.title = title;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookDTOv1 bookDTOv1 = (BookDTOv1) o;
        return Objects.equals(key, bookDTOv1.key) && Objects.equals(author, bookDTOv1.author) && Objects.equals(launchDate, bookDTOv1.launchDate) && Objects.equals(price, bookDTOv1.price) && Objects.equals(title, bookDTOv1.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, author, launchDate, price, title);
    }

    @Override
    public String toString() {
        return "BookDTOv1{" +
                "key=" + key +
                ", author='" + author + '\'' +
                ", launchDate=" + launchDate +
                ", price=" + price +
                ", title='" + title + '\'' +
                "} " + super.toString();
    }
}
