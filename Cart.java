public class Cart {
    String Name;
    float price;
    int quantity ;
    int id;
    int cid;
    int oldq;

    public Cart(String name, float price, int quantity) {
        this.Name=name;
        this.price=price;
        this.quantity=quantity;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public Cart(String name, float price, int quantity ,int id, int cid,    int oldq) {
        Name = name;
        this.price = price;
        this.quantity = quantity;
        this.id=id;
        this.cid=cid;
        this.oldq=oldq;
    }




}
