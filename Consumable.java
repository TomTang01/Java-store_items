///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment6.java
// Files:              Assignment6 starter code: Consumable.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////

import javax.swing.text.Highlighter.Highlight;

/**
 * A subclass for items.
 * contains data fields and methods for general consumable items
 *
 * Bugs: none
 *
 * @author Tom Tang
 */
public class Consumable extends Item {
    private int calories;
    private int daysLeft;   // Days until expiration 

    /**
     * no arg constructor
     */
    public Consumable() {
        super("Unnamed Consumable", 0.0, "Untyped Item", "Consumable");
        calories = 0;
        daysLeft = 0;
    }

    /**
     * custom constructor
     *
     * @param (String name) (name of the consumable item)
     * @param (double price) (price of the consumable item)
     * @param (String type) (type of the consumable item)
     * @param (int calories) (amount of calories in the consumable item)
     * @param (int daysLeft) (remaining days of the consumable item before turning)
     */
    public Consumable(String name, double price, String type, 
            int calories, int daysLeft) {
        super(name, price, type, "Consumable");
        this.calories = calories;
        this.daysLeft = daysLeft;
    }

    /**
     * Overrides the getter method for calories in the Item class
     *
     * @return (the int for calories)
     */
    @Override
    public int getCalories() {
        return calories;
    }

    /**
     * Overrides the getter method for daysLeft in the Item class
     *
     * @return (the int for dasLeft)
     */
    @Override
    public int getDaysLeft() {
        return daysLeft;
    }

    /**
     * Overrides the equals method in the Item class
     *
     * @return (whether all the datas of the consumable item 
     * and the input item are equal)
     */
    @Override
    public boolean equals(Item item) {
        if(super.equals(item) &&
            calories == item.getCalories() &&
            daysLeft == item.getDaysLeft())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Overrides the toString method in the Item class
     *
     * @return (a String containing the neccessary datas of a consumable item)
     */
    @Override
	public String toString() {
		return "Consumable (" + getName() + ") calories: " + 
            getCalories() + "; daysLeft: " + getDaysLeft();
	}
}


