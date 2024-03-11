public class ItemOrder{
   //Creating item and quantity variables then running get functions
    Item item;
    int quantity;

    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    public Item getItem() {return item; }
    public int getQuantity() {return quantity; }
    //using price and quantity to calculate total price of an item
    public double totalPrice() { return item.getPrice() * quantity; }
}
