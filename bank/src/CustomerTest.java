import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    Customer dummy;
    double testAmount;
    double startBalance;
    String testAccount;
    String CHECKING = "Checking";
    String SAVING = "Saving";

    // Initialize some starting variables that can be changed to ones liking
    @Before
    public void before() {
        startBalance = 100;
        testAmount = 2048;
        testAccount = CHECKING;
        dummy = new Customer("Bob Jenkins", 1, startBalance, startBalance);
    }

    @Test
    public void deposit() {
        dummy.deposit(testAmount, testAccount);
        assertEquals((testAmount + startBalance), dummy.returnBalance(testAccount), 0.01);
    }

    @Test
    public void withdraw() {
        dummy.deposit(testAmount, testAccount); // avoid triggering overdraft
        dummy.withdraw(testAmount, testAccount);
        assertEquals(startBalance, dummy.returnBalance(testAccount), 0.01);
    }

    @Test
    public void checkOverdraft() {
        dummy.withdraw(testAmount, testAccount);
        double expected = ((double)dummy.getOverdraftFee() + testAmount) * -1;
        assertEquals((expected + startBalance), dummy.returnBalance(testAccount), 0.01);
    }

    @Test
    public void printDeposit(){
        Withdraw transaction = new Withdraw(100, null, null);
        String expected = "Withdrawal of: $100.0 Date: null From account: null ";
        assertEquals(expected, transaction.toString());
    }

    @Test
    public void printWithdraw(){
        Deposit transaction = new Deposit(100, null, null);
        String expected = "Deposit of: $100.0 Date: null Into account: null ";
        assertEquals(expected, transaction.toString());
    }

    @Test
    public void checkBalance(){
        dummy.deposit(testAmount, CHECKING);
        dummy.deposit(testAmount, SAVING);

        assertEquals((startBalance + testAmount), dummy.returnBalance(CHECKING), 0.01);
        assertEquals((startBalance + testAmount), dummy.returnBalance(SAVING), 0.01);

        double expected = (startBalance * 2) + (testAmount * 2);
        assertEquals(expected, dummy.returnBalance(), 0.01);
    }

}