//Credit Card Account class
public class CreditCardAccount extends Account {
    private double apr; 
    private double creditLimit;
    private double mp;  
    //Empty credit card account, sets all the variables to 0
    public CreditCardAccount(){
        super();
        this.apr = 0.0; 
        this.creditLimit = 0; 
    }
    //Populates our data
    public CreditCardAccount(long number, double balance, double apr, double creditLimit){
        super(number, balance);
        this.apr = apr; 
        this.creditLimit = creditLimit; 
    }
    public double getApr() {
        return apr;
    }
    public void setApr(double apr) {
        this.apr = apr;
    }
    public double getCreditLimit() {
        return creditLimit;
    }
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
    //changes withdraw to handle amounts less than 0 based on credit limits
    public boolean withdraw(double amount){
        if ((getBalance() + creditLimit) >= amount){
            setBalance(getBalance() - amount);
            return true; 
        }
        else {
            return false; 
        }
    }
    //Calculates a monthly credit card payment
    public double calculatePayment(){ 
        if (getBalance() > 0){
            mp = 0.0; 
        }
        else{
            mp = (((apr/100)/12) * (-getBalance()));
        }
        return mp; 
    }
    //edits thbe tostring function for new data
    public String toString(){
        return super.toString() + "\nInterest Rate: " + apr + "%\nCredit Limit: $" + 
            creditLimit; 
    }

}