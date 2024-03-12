public class DeliveryPizza extends Pizza {
    private double deliveryFee;
    private String deliveryAddress;

    // Constructor
    public DeliveryPizza(String[] toppings, String deliveryAddress, int numberOfToppings) {
        super(toppings, numberOfToppings);

        this.deliveryAddress = deliveryAddress;

        // Calculates delivery fee based on cost of pizza and toppings
        if (getPrice() > 18) {
            this.deliveryFee = 3;
        } else {
            this.deliveryFee = 5;
        }
    }

    // toString method to include delivery information
    @Override
    public String toString() {
        return super.toString() + "\nDelivery Address: " + deliveryAddress + "\nDelivery Fee: $" + deliveryFee;
    }
}


