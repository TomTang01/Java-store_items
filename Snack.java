///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment6.java
// Files:              Assignment6 starter code: Snack.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////

/**
 * a subclass of the Nonconsumable class
 * contains the data fields and methods for gerenal snacks
 *
 * Bugs: none
 *
 * @author Tom Tang
 */
public class Snack extends Consumable {

    // static variables
    private static final String TEXTURE = "texture";

    private String texture; 

    /**
     * no arg constructor
     */
    public Snack() {
        super("Unnamed Snack", 0.0, "Snack", 0, 0);
        texture = TEXTURE; 
    }

    /**
     * custom constructor
     *
     * @param (String name) (name of the snack)
     * @param (double price) (price of the snack)
     * @param (int calories) (amount of calories in the snack)
     * @param (int daysLeft) (the amount of days left before the snack goes bad)
     * @param (String texture) (the texture of the snack)
     */
    public Snack(String name, double price, int calories, 
                int daysLeft, String texture) {
        super(name, price, "Snack", calories, daysLeft);
        this.texture = texture;
    }

    /**
     * overrides the getTexture method in the Item class
     *
     * @return (the String of the texture)
     */
    @Override
    public String getTexture() {
        return texture;
    }

    /**
     * Overrides the equals method in the Consumable class
     *
     * @return (whether all the datas of the snack
     *  and the input item are equal)
     */
    @Override
    public boolean equals(Item item) {
        if(super.equals(item) &&
            texture == item.getTexture())
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
     * @return (a String containing the neccessary datas of a snack)
     */
    @Override
	public String toString() {
		return "Snack (" + getName() + ") texture: " + 
            getTexture() + "; price: " + getPrice();
	}
}