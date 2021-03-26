import java.util.Date;

public class Deposit {
    private final double amount;
    private final Date date;
    private final String account;

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    @Override
    public String toString(){
        String text1 = "Deposit of: $" + amount + " ";
        String text2 = "Date: " + date + " ";
        String text3 = "Into account: " + account + " ";
        return text1 + text2 + text3;
    }

    public double getAmount() { return amount; }
    public Date getDate() { return date; }
    public String getAccount() { return account; }
}
