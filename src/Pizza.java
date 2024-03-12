public class Pizza {
    private String[] toppings;
    private double price;


    public Pizza(String[] toppings, int numberOfToppings) {
       //Exception to limit number of toppings to 10
        if (numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings cannot exceed 10");
        }
    //copies the elements from toppings
        this.toppings = new String[numberOfToppings];
        System.arraycopy(toppings, 0, this.toppings, 0, numberOfToppings);

        // Create description with comma-separated toppings
        StringBuilder descriptionBuilder = new StringBuilder();
        for (int i = 0; i < numberOfToppings; i++) {
            descriptionBuilder.append(toppings[i]);
            if (i < numberOfToppings - 1) {
                descriptionBuilder.append(", ");
            }
        }

        // Set price as $14 plus $2 for each topping
        this.price = 14 + (2 * numberOfToppings);
    }

    // Get function for the price
    public double getPrice() {
        return price;
    }

    // toString method to display Pizza description and price
    @Override
    public String toString() {
        return "Pizza with toppings: " + String.join(", ", toppings) + "\nPrice: $" + price;
    }
}
