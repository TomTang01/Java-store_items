///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment6.java
// Files:              Assignment6 starter code: Drink.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////

/**
 * a subclass of the Consumable class
 * contains the data fields and methods for gerenal drinks
 *
 * Bugs: none
 *
 * @author Tom Tang
 */
public class Drink extends Consumable {
    private double liters;

    /**
     * no arg constructor
     */
    public Drink() {
        super("Unnamed Drink", 0.0, "Drink", 0, 0);
        liters = 0; 
    }

    /**
     * custom constructor
     *
     * @param (String name) (name of the drink)
     * @param (double price) (price of the drink)
     * @param (int calories) (amount of calories in the drink)
     * @param (int daysLeft) (the amount of days left before the drink goes bad)
     * @param (double liters) (how many liters does the drink contain)
     */
    public Drink(String name, double price, int calories, 
            int daysLeft, double liters) {
                super(name, price, "Drink", calories, daysLeft);
                this.liters = liters;
    }

    /**
     * overrides the getLiters method in the Item class
     *
     * @return (the int of liters)
     */
    @Override
    public double getLiters() {
        return liters;
    }

    /**
     * Overrides the equals method in the Consumable class
     *
     * @return (whether all the datas of the drink
     *  and the input item are equal)
     */
    @Override
    public boolean equals(Item item) {
        if(super.equals(item) &&
            liters == item.getLiters())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Overrides the toString method in the Consumable class
     *
     * @return (a String containing the neccessary datas of a drink)
     */
    @Override
	public String toString() {
		return "Drink (" + getName() + ") liters: " + 
            getLiters() + "; price: " + getPrice();
	}
}