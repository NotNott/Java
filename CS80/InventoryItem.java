/*Program to print out a series of items
* Brendan Geranio 7/16/2020
* 1) Start in inventoryItem class
* 2) Create local variables
* 3) Create functions to edit these variables form other classes 
*   For this program 3 different ones based on number of passed values
* 4) Create access funnctions for individual variables
* 5) Create functions to do some creation of new values
* 6) Create display function to show all the values called for an item
* 7) Compare total value function to simplify processing in original class
*/


/* This is a separate class for Testinventory.java
*/
public class InventoryItem {
    //create variables
    private String itemName;
    private int sku;
    private double price;
    private int quantity;
    static int nItems = 0;
    //function for no passed values
    public InventoryItem(){
        this.itemName = "TBD";
        this.sku = 0;
        this.price = 0.0;
        this.quantity = 0;
        nItems++;
    }
    //function for no given quantity
    public InventoryItem(String itemName, int sku, double price) {
        this.itemName = itemName;
        this.sku = sku;
        this.setPrice(price);
        this.quantity = 0;
        nItems++;
    }
    //function for all 4 values passed
    public InventoryItem(String itemName, int sku, double price,int quantity) {
        this.itemName = itemName;
        this.sku = sku;
        this.setPrice(price);
        this.setQuantity(quantity);
        nItems++;
    }
    //getter and setter functions
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = Math.abs(price);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = Math.abs(quantity);
    }

    public static int getnItems() {
        return nItems;
    }
    //calculate total value from # of item and individual price
    public double getTotalValue(){
        return this.quantity * this.price;
    }
    //display function
    public void display(){
        System.out.println(this.itemName + "[SKU " + this.sku + "]: "+ this.quantity 
            + " at $" + this.price + " each ");
    }
    //comparison function
    public static int compare(InventoryItem itemA, InventoryItem itemB){
        if(itemA.getTotalValue() < itemB.getTotalValue()){
            return -1;
        }
        else if(itemA.getTotalValue() > itemB.getTotalValue()){
            return 1;
        }
        else{
            return 0;
        }
    }
}