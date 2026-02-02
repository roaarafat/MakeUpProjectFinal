package modules;

public class Item {
    private int id;
    private String name;
    private  int rating;
    private float price;
    private int pricerr;
    private int image;

    public Item() {
    }

    public Item(int id, String name, int rating, float price,int pricerr,int image) {
        this.pricerr = pricerr;
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.price = price;
        this.image= image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPricerr() {
        return pricerr;
    }

    public void setPricerr(int pricerr) {
        this.pricerr = pricerr;
    }
}
