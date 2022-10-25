package dk.poops.poopcloud.models;

import javax.persistence.*;
import java.awt.*;

@Entity
public class Wish {

  @Id
  private int id;
  private String name;
  private double price;
  private String link;
  private String description;
  private int list_id;

  public Wish(){
  }

  public Wish(int id, String name, double price, String link, String description, int list_id) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.link = link;
    this.description = description;
    this.list_id = list_id;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public String getLink() {
    return link;
  }

  public String getDescription() {
    return description;
  }
  public int getList_id() {
    return list_id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setList_id(int list_id) {
    this.list_id = list_id;
  }

  public String toString(){
    return id + " | " + name + " | " + price + "dkk | " + link + " | " + description + " | " + list_id;
  }
}
