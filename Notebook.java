///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment6.java
// Files:              Assignment6 starter code: Notebook.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////

/**
 * A subclass for the Nonconsumable class
 * contains data fields and methods for general notebooks
 *
 * Bugs: none
 *
 * @author Tom Tang
 */
public class Notebook extends Nonconsumable {

    // static variables
    private static final String COLOR = "color";

    private String color;
    private boolean isCollegeRuled;
    private int subject;    // 1, 3, or 5

    /**
     * no arg constructor
     */
    public Notebook() {
        super("Unnamed Notebook", 0.0, "Notebook", 0);
        color = COLOR; 
        isCollegeRuled = false;
        subject = 0;
    }

    /**
     * custom constructor
     *
     * @param (String name) (name of the notebook)
     * @param (double price) (price of the notebook)
     * @param (int maxNumUsages) (the maximum times for using 
     * the notebook)
     * @param (String color) (the color of the notebook)
     * @param (boolean isCollegeRuled) (a boolean denoting whether 
     * the notebook is college ruled (true) or wide ruled (false))
     * @param (int subject) (the number of subjects the notebook 
     * can hold (sections))
     */
    public Notebook(String name, double price, int maxNumUsages,
                    String color, boolean isCollegeRuled, int subject) {
        super(name, price, "Notebook", maxNumUsages);
        this.color = color;
        this.isCollegeRuled = isCollegeRuled;
        this.subject = subject;
    }

     /**
     * overrides the getColor method in the Item class
     *
     * @return (the String for color)
     */
    @Override
    public String getColor() {
        return color;
    }

    /**
     * overrides the getColor method in the Item class
     *
     * @return (notebook is college ruled (true) or wide ruled (false))
     */
    @Override
    public boolean getIsCollegeRuled() {
        return isCollegeRuled;
    }

    /**
     * overrides the getSubject method in the Item class
     *
     * @return (int for the number of sections in the notebook)
     */
    @Override
    public int getSubject() {
        return subject;
    }

    /**
     * Overrides the equals method in the Nonconsumable class
     *
     * @return (whether all the datas of the notebook
     *  and the input item are equal)
     */
    @Override
    public boolean equals(Item item) {
        if(super.equals(item) &&
            color.equals(item.getColor()) &&
            isCollegeRuled == item.getIsCollegeRuled() &&
            subject == item.getSubject())
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
     * @return (a String containing the neccessary datas of a notebook)
     */
    @Override
	public String toString() {
		return "Notebook (" + getName() + ") maxNumUsages: " 
            + getMaxNumUsages() + "; color: " + getColor()
            + "; isCollegeRuled: " + getIsCollegeRuled()
            + "; subject: " + getSubject();
	}
}

