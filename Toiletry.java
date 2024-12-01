///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment6.java
// Files:              Assignment6 starter code: Toiletry.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////

/**
 * A subclass for the Nonconsumable class
 * contains data fields and methods for general toiletry
 *
 * Bugs: none
 *
 * @author Tom Tang
 */
public class Toiletry extends Nonconsumable {
    private int packSize;
    private boolean isBrandName; 

    /**
     * no arg constructor
     */
    public Toiletry() {
        super("Unnamed Toiletry", 0.0, "Toiletry", 0);
        packSize = 0;
        isBrandName = false; 
    }

    /**
     * custom constructor
     *
     * @param (String name) (name of the toiletry)
     * @param (double price) (price of the toiletry)
     * @param (int maxNumUsages) (the maximum times for using 
     * the toiletry)
     * @param (int packSize) (the number of items in a pack)
     * @param (boolean isBrandName) (a boolean denoting whether 
     * the toiletry has a brand or not)
     */
    public Toiletry(String name, double price, int maxNumUsages,
                    int packSize, boolean isBrandName) {
        super(name, price, "Toiletry", maxNumUsages);
        this.packSize = packSize;
        this.isBrandName = isBrandName;
    }

    /**
     * overrides the getPackSize method in the Item class
     *
     * @return (the number of items in a pack)
     */
    @Override
    public int getPackSize() {
        return packSize;
    }

    /**
     * overrides the getIsBrandName method in the Item class
     *
     * @return (whether the toiletry has a brand or not)
     */
    @Override
    public boolean getIsBrandName() {
        return isBrandName;
    }

    /**
     * Overrides the equals method in the Nonconsumable class
     *
     * @return (whether all the datas of the toiletry
     *  and the input item are equal)
     */
    @Override
    public boolean equals(Item item) {
        if(super.equals(item) &&
            packSize == item.getPackSize() &&
            isBrandName == item.getIsBrandName())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Overrides the toString method in the Nonconsumable class
     *
     * @return (a String containing the neccessary datas of a toiletry)
     */
    @Override
	public String toString() {
		return "Toiletry (" + getName() + ") maxNumUsages: " 
            + getMaxNumUsages() + "; packSize: " + getPackSize() 
            + "; isBrandName: " + getIsBrandName(); 
	}
}

