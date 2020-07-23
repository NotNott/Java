//SavingsAccount class 
public class SavingsAccount extends Account {
    private double apr;
    //populates data with 0
    public SavingsAccount(){
        super();
        this.apr = 0.0; 
    }
    //Properly inputs data
    public SavingsAccount(long number, double balance, double apr){
        super(number, balance);
        this.apr = apr; 
    }
    public double getApr() {
        return apr;
    }
    public void setApr(double apr) {
        this.apr = apr;
    }
    //Calculates annual interest
    public double annualInt(){
        return getBalance() * (apr / 100);
    }
    //changes toString function to include Interest Rate
    public String toString() {
        return super.toString() + "\nInterest Rate: " + apr + "%";
    }

}