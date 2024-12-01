///////////////////////////////////////////////////////////////////////////////
//                   
// Title:              Item
// Files:              Assignment6 starter code: Assignment6.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;

import javax.swing.text.MaskFormatter;

/**
 * The main class for this assignment, implement and test all other classes
 *
 * Bugs: none
 *
 * @author Tom Tang
 */
public class Assignment6 {

    /**
     * This helper method is given to help debug!
     * It is OPTIONAL to use.
     * Prints out a array of items
     *
     * @param (Item[] itemArr) (the array to print)
     * 
     * @return void
     */
    public static void printItemArray(Item[] itemArr) {
        System.out.println('[');
        for (int i = 0; i < itemArr.length; i++) {
            System.out.print("  " + itemArr[i]);
            System.out.println(',');
        }
        System.out.println(']');
    }

    /**
     * This is a helper method to test generateAndApplyDiscount!
     *
     * @param (ArrayList<Item> items) (the item list for applying discount)
     * @param (double discountRate) (the amount of discount)
     * @return (all possible sums of prices from applying discount on one item)
     */
    // It is OPTIONAL to use.
    public static double[] testDiscountHelper(ArrayList<Item> items, 
                                              double discountRate) {
        double[] possiblePriceSums = new double[items.size()];

        // Below loop calculates the sum of all prices (without a discount)
        double priceSum = 0.0;
        for (int i = 0; i < items.size(); i++) {
            priceSum += items.get(i).getPrice();
        }

        // Calculates every possible sum of prices with a discounted item
        for (int i = 0; i < items.size(); i++) {
            double priceSumRandDiscount = priceSum;
            double itemPrice = items.get(i).getPrice();

            // Subtract price of current item to sum
            priceSumRandDiscount -= itemPrice;
            // Add price of current item DISCOUNTED to sum
            priceSumRandDiscount += itemPrice * discountRate;
            possiblePriceSums[i] = priceSumRandDiscount;
        }

        // Returns all possible sums of prices from 
        // applying discount on one item
        return possiblePriceSums;
    }

    /**
     * method to test the three methods in the store class
     *
     * @return (whether the methods gave expected results or not)
     */
    public static boolean unitTests() {
        // TEST CASE 1
        // We provide a test case for generateAndApplyDiscount
        Store store = new Store();
        
        // Add items to a Store object
        Drink newDrink = new Drink("milk", 3.10, 50, 5, 1.2);
        store.addToItemList(newDrink); 
        Item[] itemsToAdd = { 
            new Drink("water", 2.0, 50, 90, 1.2), 
            new Snack("popcorn", 6.1, 200, 40, "crunchy")
       	};
	    store.addToItemList(itemsToAdd);
      
        // Save all the original prices of the items
        double[] originalPrices = new double[store.getItemList().size()];
        for (int i = 0; i < store.getItemList().size(); i++) {
            originalPrices[i] = store.getItemList().get(i).getPrice();
        }
        
        // Apply discount
        double discountRate = 0.5;
	    int discountIndex = store.generateAndApplyDiscount(discountRate);

        boolean foundReceivedSum = false;
        double receivedSum = 0.0;
        
        for (int i = 0; i < store.getItemList().size(); i++) {
            Item item = store.getItemList().get(i);
            if (i != discountIndex) {
                // Check that the Item as this index is still the same
                if (item.getPrice() != originalPrices[i]) {
                    // Item has changed unexpectedly
                    System.out.println("generateAndApplyDiscount 1" +
                        " - nondiscounted Item unexpectedly changed " +
                        "at index: " + i);
                    System.out.println(store.getItemList());
                    return false;
                }
                
            } else {
                // Check that the Item has the expected discount price
                double actualPrice = originalPrices[i] * discountRate;
                if (item.getPrice() != actualPrice) {
                    System.out.println("generateAndApplyDiscount 1" +
                        " - Item does not have expected discount price");
                    System.out.println(item.getPrice());
                    System.out.println(actualPrice);
                    System.out.println(store.getItemList());
                    return false;
                }
            }
        }


        // Feel free to write more cases for generateAndApplyDiscount!!
        // Change the discountRate like so:
        //      discountRate = 0.7;



        // TEST CASE 2
        Store store2 = new Store();
        
        // Add items to a Store object
        Drink soda1 = new Drink("Coke", 2.0, 300, 365, 2);
        store2.addToItemList(soda1); 
        Item[] itemsToAdd2 = { 
            new Drink("water", 1.5, 50, 90, 1.2), 
            new Snack("popcorn", 6.1, 200, 40, "crunchy"),
            new Notebook("pocketbook", 3.5, 300, "black", true, 1),
            new Nonconsumable("thinkpad", 299,"Laptop", 1500000),
       	};
	    store2.addToItemList(itemsToAdd2);
        Item UnknownItem = new Item();
        store2.addToItemList(UnknownItem);
      
        // Save all the original prices of the items
        double[] originalPrices2 = new double[store2.getItemList().size()];
        for (int i = 0; i < store2.getItemList().size(); i++) {
            originalPrices2[i] = store2.getItemList().get(i).getPrice();
        }
        
        // Apply discount
        double discountRate2 = 0.75;
	    int discountIndex2 = store2.generateAndApplyDiscount(discountRate2);

        boolean foundReceivedSum2 = false;
        double receivedSum2 = 0.0;
        
        for (int i = 0; i < store2.getItemList().size(); i++) {
            Item item = store2.getItemList().get(i);
            if (i != discountIndex2) {
                // Check that the Item as this index is still the same
                if (item.getPrice() != originalPrices2[i]) {
                    // Item has changed unexpectedly
                    System.out.println("generateAndApplyDiscount 2" +
                        " - nondiscounted Item unexpectedly changed " +
                        "at index: " + i);
                    System.out.println(store2.getItemList());
                    return false;
                }
                
            } else {
                // Check that the Item has the expected discount price
                double actualPrice = originalPrices2[i] * discountRate2;
                if (item.getPrice() != actualPrice) {
                    System.out.println("generateAndApplyDiscount 2" +
                        " - Item does not have expected discount price");
                    System.out.println(item.getPrice());
                    System.out.println(actualPrice);
                    System.out.println(store2.getItemList());
                    return false;
                }
            }
        }

        // TEST CASE 3
        Store store3 = new Store();
        
        // Add items to a Store object
        store3.addToItemList(soda1); 
        store3.addToItemList(newDrink);
	    store3.addToItemList(itemsToAdd2);
        Item[] itemsToAdd3 = { 
            new Toiletry("paper rolls", 5.99, 150, 450, true), 
            new Consumable("Joe's Marshmallow", 3, "Sweet", 40, 92),
            new Notebook("NotePal", 4, 400, "blue", false, 3),
            new Nonconsumable("Permanent Marker", 2.99,"Utencil", 10000),
            new Nonconsumable("Plubber", 8.66,"Toiletry", 100000)
       	};
        store3.addToItemList(itemsToAdd3);
        store3.addToItemList(UnknownItem);
        Item[] OrganizedList = store3.getItemsByType();

        //check size
        if(OrganizedList.length != store3.getItemList().size())
        {
            System.out.println("getItemByType 1" +
                        " - OrganizedList does not have the correct length");
            System.out.println(OrganizedList.length);
            return false;
        }

        //check Drinks
        for(int i=0; i<3; ++i)
        {
            if(!(OrganizedList[i].getType().equals("Drink")))
            {
                System.out.println("getItemByType 1" +
                        " - Item has unexpected type at index: " +
                        i);
                System.out.println("Unexpected type: " + OrganizedList[i].getType());
                return false;
            }
        }

        //check Snacks
        if(!(OrganizedList[3].getType().equals("Snack")))
        {
            System.out.println("getItemByType 1" +
                    " - Item has unexpected type at index: " +
                    3);
            System.out.println("Unexpected type: " + OrganizedList[3].getType());
            return false;
        }

        //check Notebook
        for(int i=4; i<6; ++i)
        {
            if(!(OrganizedList[i].getType().equals("Notebook")))
            {
                System.out.println("getItemByType 1" +
                        " - Item has unexpected type at index: " +
                        i);
                System.out.println("Unexpected type: " + OrganizedList[i].getType());
                return false;
            }
        }

        //check Toiletry
        for(int i=6; i<8; ++i)
        {
            if(!(OrganizedList[i].getType().equals("Toiletry")))
            {
                System.out.println("getItemByType 1" +
                        " - Item has unexpected type at index: " +
                        i);
                System.out.println("Unexpected type: " + OrganizedList[i].getType());
                return false;
            }
        }

        // TEST CASE 4
        
        Drink coke = new Drink("Cola", 2.0, 200, 30, 2);
        Snack lollipop = new Snack("Lollipop", 0.25, 30, 30, "hard");
        Consumable marshmallow = new Consumable("Joe's Marshmallow", 3, "Sweet", 40, 20);
        Notebook notebook = new Notebook("pocketbook", 3.5, 150, "black", true, 1);
        Toiletry paperRoll = new Toiletry("paper rolls", 5.99, 50, 450, true);
        Nonconsumable laptop = new Nonconsumable("thinkpad", 299,"Laptop", 150);

        if(Store.compareFinalUsageDate(coke, lollipop, 2)!= 0)
        {
            System.out.println("compareFinalUsageDate 1" +
                        " - Wrong output: " +
                        Store.compareFinalUsageDate(coke, lollipop, 2));
            return false;
        }

        if(Store.compareFinalUsageDate(coke, marshmallow, 2)!= 1)
        {
            System.out.println("compareFinalUsageDate 2" +
                        " - Wrong output: " +
                        Store.compareFinalUsageDate(coke, marshmallow, 2));
            return false;
        }

        if(Store.compareFinalUsageDate(marshmallow, lollipop, 2)!= -1)
        {
            System.out.println("compareFinalUsageDate 3" +
                        " - Wrong output: " +
                        Store.compareFinalUsageDate(marshmallow, lollipop, 2));
            return false;
        }

        if(Store.compareFinalUsageDate(notebook, laptop, 7)!= 0)
        {
            System.out.println("compareFinalUsageDate 4" +
                        " - Wrong output: " +
                        Store.compareFinalUsageDate(notebook, laptop, 7));
            return false;
        }

        if(Store.compareFinalUsageDate(notebook, paperRoll, 5)!= 1)
        {
            System.out.println("compareFinalUsageDate 5" +
                        " - Wrong output: " +
                        Store.compareFinalUsageDate(notebook, paperRoll, 5));
            return false;
        }

        if(Store.compareFinalUsageDate(notebook, coke, 5)!= 0)
        {
            System.out.println("compareFinalUsageDate 6" +
                        " - Wrong output: " +
                        Store.compareFinalUsageDate(notebook, coke, 5));
            return false;
        }

        if(Store.compareFinalUsageDate(marshmallow, paperRoll, 7)!= 1)
        {
            System.out.println("compareFinalUsageDate 7" +
                        " - Wrong output: " +
                        Store.compareFinalUsageDate(marshmallow, paperRoll, 7));
            return false;
        }

        return true;
    }

    /**
     * main method for calling the unit test
     */
    public static void main(String[] args) {
        // Perform unitTests 
        if(unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("Failed test.\n");
            return;
        }

        // Don't need to write code in main!
    }


}
