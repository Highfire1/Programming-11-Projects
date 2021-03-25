/*
BANKEOMETER BILLIONATOR BEIGHT BHOUSAND
By [redacted since its on the *web*]

note: some liberties have been taken in the backend
(in other words: some things were thrown out in the bathwater, hope they weren't mandatory lol)

 */

class Main {
    public static void main(String[] args) {
        Customer bob = new Customer("Bob Jenkins", 1, 50, 100);
        bob.displayWithdraws();
        bob.displayDeposits();

        System.out.println("----------------");

        bob.withdraw(200, Customer.CHECKING);
        bob.displayWithdraws();

        System.out.println("----------------");


        System.out.println("----------------");

        Customer aah = new Customer();

    }
}