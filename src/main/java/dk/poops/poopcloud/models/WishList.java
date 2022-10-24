package dk.poops.poopcloud.models;

public class WishList {

  private int id;
  private String name;

  public WishList() {
  }

  public WishList(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return id + " " + name;
  }
}
