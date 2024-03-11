import java.util.ArrayList;

public class ShoppingCart {
    //creating item order array
    ArrayList<ItemOrder> list;

    public ShoppingCart(){
        list = new ArrayList<>();
    }
    //adds items and quantities to array
    public void addItem(ItemOrder itemOrder) {
        list.add(itemOrder);
    }
    //Removes items and quantities from array
    public void removeItem(ItemOrder itemOrder){
        list.remove(itemOrder);
    }
    //iterates through array to search for a name match
    public ItemOrder searchItem(String Name) {
        for (ItemOrder itemOrder : list){
            if (itemOrder.getItem().getName().equals(Name)) {
                return itemOrder;
            }
        }return null;
    }
    //uses total price function to iterate through array and total the prices of all items
    public double calculateTotal() {
        double total = 0;
        for (ItemOrder itemOrder : list) {
            total += itemOrder.totalPrice();
        }
        return total;

    }


}
