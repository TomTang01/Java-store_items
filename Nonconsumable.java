///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment6.java
// Files:              Assignment6 starter code: Nonconsumable.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////

/**
 * A subclass for the Item class
 * contains data fields and methods for general nonconsumable items
 *
 * Bugs: none
 *
 * @author Tom Tang
 */
public class Nonconsumable extends Item {
    private int maxNumUsages;

    /**
     * no arg constructor
     */
    public Nonconsumable() {
        super("Unnamed Nonconsumable", 0.0, 
            "Untyped Item", "Nonconsumable");
        maxNumUsages = 0;
    }

    /**
     * custom constructor
     *
     * @param (String name) (name of the nonconsumable item)
     * @param (double price) (price of the nonconsumable item)
     * @param (String type) (type of the nonconsumable item)
     * @param (int maxNumUsages) (the maximum times for using 
     * the nonconsumable item)
     */
    public Nonconsumable(String name, double price, String type, 
                        int maxNumUsages) {
            super(name, price, type, "Nonconsumable");
            this.maxNumUsages = maxNumUsages;
    }

    /**
     * overrides the getMaxNumUsages method in the Item class
     *
     * @return (the int of maxNumUsages)
     */
    @Override
    public int getMaxNumUsages() {
        return maxNumUsages;
    }

     /**
     * Overrides the equals method in the Item class
     *
     * @return (whether all the datas of the nonconsumable item
     *  and the input item are equal)
     */
    @Override
    public boolean equals(Item item) {
        if(super.equals(item) &&
            maxNumUsages == item.getMaxNumUsages())
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
     * @return (a String containing the neccessary datas of a nonconsumable item)
     */
    @Override
	public String toString() {
		return "Nonconsumable (" + getName() + 
            ") maxNumUsages: " + getMaxNumUsages();
	}
}


