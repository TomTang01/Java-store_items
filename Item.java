///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment6.java
// Files:              Assignment6 starter code: Item.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////

/**
 * The super class for most of the other classes in this assignment. Contains 
 * the data fields and methods for general items
 *
 * Bugs: none
 *
 * @author Tom Tang
 */
public class Item {
    private String name;
    private double price;
    private String type;
    private String highLevelType;

    /**
     * no arg constructor
     */
    public Item() {
        name = "Unnamed Item";
        price = 0.0;
        type = "Untyped Item";
		highLevelType = "Item";
    }

    /**
     * custom constructor that can set the name, price, type, 
     * and highLevelType of the item
     *
     * @param (String name) (name of the item)
     * @param (double price) (price of the item)
     * @param (String type) (type of the item)
     * @param (String highLevelType) ("Consumable", "Nonconsumable",
     * or "Untyped Item")
     */
    public Item(String name, double price, String type, String highLevelType) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.highLevelType = highLevelType;
    }

    /**
     * getter method for the variable name
     *
     * @return (the String for name)
     */
    public String getName() {
        return name;
    }

    /**
     * getter method for the variable price
     *
     * @return (the double for price)
     */
    public double getPrice() {
        return price;
    }

	/**
     * getter method for the variable type
     *
     * @return (the String for type)
     */
	public String getType() {
        return type;
	}

	/**
     * getter method for the variable highLevelType
     *
     * @return (the String for highLevelType)
     */
	public String getHighLevelType() {
        return highLevelType;
	}

    /**
     * setter method for the variable price
     * @param (double price) (the new price to be set)
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * checks if the item and the input item has the same name, price,
     * type, and highLevelType
     *
     * @param (Item item) (the item to compare to)
     * 
     * @return (wether the items are equal or not)
     */
    public boolean equals(Item item) {
        if(name.equals(item.getName()) &&
            price == item.getPrice() &&
            type.equals(item.getType()) &&
            highLevelType.equals(item.getHighLevelType()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * getter method for maxNumUsages. For Override
     *
     * @return (0 becuase a general item does not have such an variable)
     */
    public int getMaxNumUsages() {
        return 0;
    }

    /**
     * getter method for color. For Override
     *
     * @return (an empty String becuase a general item 
     * does not have such an variable)
     */
    public String getColor() {
        return "";
    }

    /**
     * getter method for isCollegeRuled. For Override
     *
     * @return (false becuase a general item does not have such an variable)
     */
    public boolean getIsCollegeRuled() {
        return false;
    }

    /**
     * getter method for subject. For Override
     *
     * @return (0 becuase a general item does not have such an variable)
     */
    public int getSubject() {
        return 0;
    }

    /**
     * getter method for packSize. For Override
     *
     * @return (0 becuase a general item does not have such an variable)
     */
    public int getPackSize() {
        return 0;
    }

    /**
     * getter method for isBrandName. For Override
     *
     * @return (false becuase a general item does not have such an variable)
     */
    public boolean getIsBrandName() {
        return false; 
    }

    /**
     * getter method for calories. For Override
     *
     * @return (0 becuase a general item does not have such an variable)
     */
    public int getCalories() {
        return 0; 
    }

    /**
     * getter method for daysLeft. For Override
     *
     * @return (0 becuase a general item does not have such an variable)
     */
    public int getDaysLeft() {
        return 0;
    }

    /**
     * getter method for liters. For Override
     *
     * @return (0.0 becuase a general item does not have such an variable)
     */
    public double getLiters() {
        return 0.0;
    }

    /**
     * getter method for texture. For Override
     *
     * @return (an empty String becuase a general item does not have such an variable)
     */
    public String getTexture() {
        return "";
    }

    /**
     * overrides the toString method in the Object class
     *
     * @return (the item's name, type, and price)
     */
    @Override
	public String toString() {
		return "Item (" + getName() + ") type: " + 
            getType() + "; price: " + getPrice();
	}

}