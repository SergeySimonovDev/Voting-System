package ru.internship.ballot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractTitleEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    @NotNull
    private Restaurant restaurant;

    @Column(name = "price", nullable = false)
    @Range(min = 10, max = 2000)
    private int price;

    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDate date;

    @Column(name = "is_menu", nullable = false)
    private boolean menu;

    public Dish() {

    }

    public Dish(String title, int price, LocalDate date, boolean menu) {
        this(null, title, price, date, menu);
    }

    public Dish(Integer id, String title, int price, LocalDate date, boolean menu) {
        super(id, title);
        this.price = price;
        this.date = date;
        this.menu = menu;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isMenu() {
        return menu;
    }

    public void setMenu(boolean menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", title='" + title +
                ", price=" + price +
                ", date=" + date +
                ", menu=" + menu +
                '}';
    }
}
