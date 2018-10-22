public interface BankProvider {
    public boolean Withdraw(double amount, int cvc);

    public boolean Deposit(double amount);

    public double getBalance();
}