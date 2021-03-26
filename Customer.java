/*
BANKEOMETER BILLIONATOR BEIGHT BHOUSAND
By [redacted since its on the *web*]

note: some liberties have been taken in the backend
(in other words: some things were thrown out in the bathwater, hope they weren't mandatory lol)

 */

// import javax.security.sasl.SaslClient; oh no o.o
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private String name;
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    // private double savingRate; // not used?...

    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = 100;

    Customer(){
        this.name = null;
        this.accountNumber++;
        this.deposits = new ArrayList<>();
        this.withdraws = new ArrayList<>();
    }

    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.name = name;
        this.accountNumber = accountNumber; // project requirements aren't very clear so I just put it as a parameter
        this.deposits = new ArrayList<>();
        this.withdraws = new ArrayList<>();

        deposit(checkDeposit, CHECKING);
        deposit(savingDeposit, SAVING);
    }

    public void deposit(double amt, String account) {
        /*
        Requires : amount and account
        Modifies : this.deposits
        Effects  : adds an entry to the deposits array with amount, date & account
         */
        deposits.add(new Deposit(amt, currentTime(), account));
    }

    public void withdraw(double amt, String account) {
        /*
        Requires : amount and account
        Modifies : this.withdraws
        Effects  : adds an entry to the withdraws array with amount, date & account then calls an overdraft check
         */
        withdraws.add(new Withdraw(amt, currentTime(), account));
        checkOverdraft(account);
    }

    private void checkOverdraft(String account){
        /*
        Requires : account
        Modifies : this.withdraws
        Effects  : if account is negative after a withdrawal, MAKE EM PAY MORE MONEY YEA
                   (by adding an overdraft withdrawal)
         */
        if (returnBalance(account) < 0){
            withdraws.add(new Withdraw(OVERDRAFT, currentTime(), account));
        }
    }

    public double returnBalance(String account) {
        /*
        Requires : account
        Modifies : none
        Effects  : helper function as keeping track of a separately named variable is spaghetti inducing. :c
         */
        double pos = 0;
        double neg = 0;

        for (Deposit i : deposits) {
            if (i.getAccount().equals(account)) {
                pos = pos + i.getAmount();
            }
        }

        for (Withdraw i : withdraws) {
            if ( i.getAccount().equals(account) ) {
                neg = neg + i.getAmount();
            }
        }
        return pos - neg;
    }

    public double returnBalance() {
        // 50 points to gryffindor for function overloading
        return returnBalance(CHECKING) + returnBalance(SAVING);
    }

    private Date currentTime (){
        // helper function
        return new java.util.Date();
    }

    public int getOverdraftFee(){
        // helper function
        return OVERDRAFT;
    }

    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
