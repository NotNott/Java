import java.text.Format;

//Basic Account Class
public class Account {
    private long number; 
    private double balance; 
    //Populates data with 0
    public Account(){
        this.number = 0; 
        this.balance = 0.0;
    }
    //Gives us soome real numbers in out variables 
    public Account(long number, double balance){
        this.number = number; 
        this.balance = balance; 
    }
    public long getNumber() {
        return number;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    //changes balance varaiable based on deposit amount
    public void deposit(double amount){
        balance += amount; 
    }
    //changes balance based on amount withdrawn, cant go below 0 
    public boolean withdraw(double amount){
        if (balance >= amount){
            balance -= amount; 
            return true; 
        }
        else {
            return false; 
        }
    }
    /*a function to make a string variable of all the data, it is printed 
    * in the main class but not here
    */
    public String toString(){
        return  "Account: " +  getNumber() + 
            "\nBalance: $" + getBalance();  
    }
}
