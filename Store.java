///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment6.java
// Files:              Assignment6 starter code: Store.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

import javax.lang.model.util.ElementScanner6;

/**
 * Class for stores. Contains the list of item that the store contains and some
 * methods for the store.
 *
 * Bugs: none
 *
 * @author Tom Tang
 */
public class Store {
    private ArrayList<Item> itemList;

    /**
     * no arg constructor
     * sets the itemList to a empty list of Items
     */
    public Store() {
        itemList = new ArrayList<Item>();
    }

    /**
     * the getter method for the itemList
     *
     * @return (the itemList)
     */
    public ArrayList<Item> getItemList() {
        return itemList;
    }

    /**
     * add an item to the itemList
     *
     * @param (Item item) (the item to add to the list)
     */
    public void addToItemList(Item item) {
        itemList.add(item);
    }

    /**
     * add all the items in the input array to itemList
     *
     * @param (Item[] items) (the array of items to add)
     */
    public void addToItemList(Item[] items) {
        for(int index=0; index<items.length; ++index)
        {
            itemList.add(items[index]);
        }
    }

    /**
     * checks which of the 2 items will be used up or expired first
     * THE HIGHLEVEL TYPE OF THE 2 ITEMS CAN ONLY BE COMSUMABLE OR NONCONSUMABLE!!!!
     *
     * @param (Item item1) (the first input item)
     * @param (Item item2) (the second input item)
     * @param (double rateOfUsage) (the rate for using a nonconsumable item 
     * (amount per day))
     * 
     * @return (-1 if the first item will expire first, 0 if at the same time, 
     * and 1 if the second object will expire first)
     */
    public static int compareFinalUsageDate(Item item1, Item item2,
                                      double rateOfUsage) {
        if(item1 instanceof Consumable)
        {
            if(item2 instanceof Consumable)
            {
                if(((Consumable)item1).getDaysLeft()<
                    ((Consumable)item2).getDaysLeft())
                {
                    return -1;
                }
                else if(((Consumable)item1).getDaysLeft()==
                    ((Consumable)item2).getDaysLeft())
                {
                    return 0;
                }
                else
                {
                    return 1;
                }
            }
            else
            {
                if(((Consumable)item1).getDaysLeft()<
                    ((Nonconsumable)item2).getMaxNumUsages()/rateOfUsage)
                {
                    return -1;
                }
                else if(((Consumable)item1).getDaysLeft()==
                    ((Nonconsumable)item2).getMaxNumUsages()/rateOfUsage)
                {
                    return 0;
                }
                else
                {
                    return 1;
                }
            }
        }
        else
        {
            if(item2 instanceof Consumable)
            {
                if(((Nonconsumable)item1).getMaxNumUsages()/rateOfUsage<
                    ((Consumable)item2).getDaysLeft())
                {
                    return -1;
                }
                else if(((Nonconsumable)item1).getMaxNumUsages()/rateOfUsage>
                    ((Consumable)item2).getDaysLeft())
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
            else
            {
                if(((Nonconsumable)item1).getMaxNumUsages()/rateOfUsage<
                    ((Nonconsumable)item2).getMaxNumUsages()/rateOfUsage)
                {
                    return -1;
                }
                else if(((Nonconsumable)item1).getMaxNumUsages()/rateOfUsage>
                    ((Nonconsumable)item2).getMaxNumUsages()/rateOfUsage)
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
        }
    }

    /**
     * Select a random Item from this Store object’s itemList 
     * and apply a discount on it
     *
     * @param (double discountRate) (the amount of discount)
     *
     * @return (the index of the item discounted)
     */
    public int generateAndApplyDiscount(double discountRate) {
        int discountIndex = (int)(itemList.size() * Math.random());
        itemList.get(discountIndex).setPrice(itemList
                .get(discountIndex).getPrice() * discountRate);
        return discountIndex;
    }

    /**
     * Return an Array containing all items in this Store’s itemList 
     * with Item objects categorized by type in the following order: 
     * Drink, Snack, Notebook, Toiletry, and other types
     *
     * @return (Array containing all items in the list in type order)
     */
    public Item[] getItemsByType() {
        Item[] sortedItems = new Item[itemList.size()];
        int currentIndex = 0;
        //enter all Drinks first
        for(int index=0; index<itemList.size(); ++index)
        {
            if(itemList.get(index).getType().equals("Drink"))
            {
                sortedItems[currentIndex] = itemList.get(index);
                ++currentIndex;
            }
        }
        //next, enter all Snacks
        for(int index=0; index<itemList.size(); ++index)
        {
            if(itemList.get(index).getType().equals("Snack"))
            {
                sortedItems[currentIndex] = itemList.get(index);
                ++currentIndex;
            }
        }
        //enter all Notebooks
        for(int index=0; index<itemList.size(); ++index)
        {
            if(itemList.get(index).getType().equals("Notebook"))
            {
                sortedItems[currentIndex] = itemList.get(index);
                ++currentIndex;
            }
        }
        //enter all Toiletry
        for(int index=0; index<itemList.size(); ++index)
        {
            if(itemList.get(index).getType().equals("Toiletry"))
            {
                sortedItems[currentIndex] = itemList.get(index);
                ++currentIndex;
            }
        }
        //enter all other types
        for(int index=0; index<itemList.size(); ++index)
        {
            if(!(itemList.get(index).getType().equals("Drink") ||
                itemList.get(index).getType().equals("Snack") ||
                itemList.get(index).getType().equals("Notebook") ||
                itemList.get(index) .getType().equals("Toiletry")))
            {
                sortedItems[currentIndex] = itemList.get(index);
                ++currentIndex;
            }
        }
        return sortedItems;
    }

}