public class BankProviderDouble implements BankProvider {

  static final int CORRECT_CVC = 123;
  static final double STARTING_BALANCE = 100.0;

  private double balance;
  private boolean failNextDeposit;

  public BankProviderDouble() {
    failNextDeposit = false;
    balance = STARTING_BALANCE;
  }

  @Override
  public boolean Withdraw(double amount, int cvc) {
    if (cvc == CORRECT_CVC) {
      if (balance - amount >= 0.0) {
        balance -= amount;
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  @Override
  public boolean Deposit(double amount) {
    if (failNextDeposit) {
      return false;
    } else {
      if (amount < 0.0) {
        return false;
      } else {
        balance += amount;
        return true;
      }
    }
  }

  public double getBalance() {
    return balance;
  }

  public void setFailNextDeposit(boolean value) {
    failNextDeposit = value;
  }
}