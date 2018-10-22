import java.time.LocalDate;
import java.util.regex.Pattern;

public class Mufasa {
  // #region F1
  static boolean usernameValid(String username) {
    if (username.length() > 15) {
      return false;
    }
    if (find("[^A-Za-z_]", username)) {
      return false;
    }
    int underscoreCount = 0;
    for (char ch : username.toCharArray()) {
      if (ch == '_') {
        underscoreCount++;
      }
    }
    if (underscoreCount > 1) {
      return false;
    }
    return true;
  }

  static boolean nameValid(String name) {
    if (find("[^A-Za-z]", name)) {
      return false;
    }
    return true;
  }

  static boolean passwordValid(String password) {
    return password.length() >= 8;
  }

  static boolean oldEnough(String birthday) {
    if (!find("^\\d{2}\\/\\d{2}\\/\\d{4}", birthday)) {
      return false;
    }
    String[] parts = birthday.split("\\/");
    LocalDate localDate = LocalDate.of(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]),
        Integer.parseInt(parts[0]));
    return localDate.isBefore(LocalDate.now().minusYears(18));
  }

  static boolean phoneValid(String phone) {
    return !find("[^0-9]", phone);
  }
  // #endregion

  // #region F3
  // Street Address (digits and alphabets only), City (only alphabetical
  // characters), Postal
  // code (only digits and ‘-‘), Country – alphabetical characters only. The a
  // 
  //
  // phabets
  // should come from the set of standard English alphabets.

  // 2. A password that should be different from the password asked earlier for
  // basic
  // information collection. And again, the minimum length is 8 and is
  // case-sensitive.

  // 3. In order to attach the bank-account, the user has to provide the following
  // details: card
  // holder name, type of the card - selection from the already provided list
  // (Mastercard,
  // VISA, Discover), credit/debit card number and expiry date of the card.
  static boolean streetAddressValid(String address) {
    return !find("[^0-9A-Za-z ]", address);
  }

  static boolean cityValid(String city) {
    return !find("[^A-Za-z ]", city);
  }

  static boolean postalCodeValid(String code) {
    return !find("[^0-9-]", code);
  }

  static boolean countryValid(String country) {
    return !find("[^A-Za-z ]", country);
  }

  static boolean testBankAccount(BankProvider provider, int cvc) {
    if (!provider.Withdraw(0.01, cvc)) {
      return false;
    }
    if (!provider.Deposit(0.01)) {
      return false;
    }
    return true;
  }

  // password already covered in F1

  // #endregion

  private static boolean find(String regex, String source) {
    return Pattern.compile(regex).matcher(source).find();
  }
}
