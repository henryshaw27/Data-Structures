public class Item{
   //Creating name and price variables then running get functions
    String Name;
    double Price;

    public Item(String Name, double Price){
        this.Name = Name;
        this.Price = Price;
    }
    public String getName() {return Name; }
    public double getPrice() {return Price; }

}