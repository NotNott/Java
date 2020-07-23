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
public class TestInventory {
    public static void main(String[] args) {
        //create inventory items starting with a default one 
        InventoryItem emptyItem = new InventoryItem();
        //Stapler doesnt have the 4th argument so it defaults amount to 0
        InventoryItem staplers = new InventoryItem("Stapler,Red", 91745, 7.89);
        InventoryItem pencils = new InventoryItem("Pencil,#2", 73105, 0.35, 210);
        InventoryItem notebooks = new InventoryItem("Notebook,Spiral", 68332, 2.57, 38);
        //print all the items
        System.out.println("Number of inventory items: " + InventoryItem.nItems);
        //display function adds in text around premade data
        emptyItem.display();
        System.out.printf("Total value: $%.2f", emptyItem.getTotalValue());
        System.out.println("");
        staplers.display();
        System.out.printf("Total value: $%.2f", staplers.getTotalValue());
        System.out.println("");
        pencils.display();
        System.out.printf("Total value: $%.2f", pencils.getTotalValue());
        System.out.println("");
        notebooks.display();
        System.out.printf("Total value: $%.2f", notebooks.getTotalValue());
        System.out.println("");

        //check value of pencils againts notebooks
        if(InventoryItem.compare(pencils, notebooks) < 0){
            System.out.println(pencils.getItemName() + " is less value than " + notebooks.getItemName());
        }
        else if(InventoryItem.compare(pencils, notebooks) > 0){
            System.out.println(pencils.getItemName() + " is greater value than " + notebooks.getItemName());
        }
        else{
            System.out.println(pencils.getItemName() + " is equal as " + notebooks.getItemName());
        }
    }
}
