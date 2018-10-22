import static org.junit.Assert.*;

import org.junit.Test;

public class Person {

  @Test
  public void usernameValid_ReturnsFalseIfLongerThan15() {
    assertFalse(Mufasa.usernameValid("asdkjaslkdjaslkdjasdklja"));
  }

  @Test
  public void usernameValid_ReturnsFalseIfNonAlphaChars() {
    assertFalse(Mufasa.usernameValid("123"));
    assertFalse(Mufasa.usernameValid("%#@"));
  }

  @Test
  public void usernameValid_ReturnsFalseIfMoreThanOneUnderscore() {
    assertFalse(Mufasa.usernameValid("in_valid_name"));
  }

  @Test
  public void usernameValid_ReturnsTrueForAValidUsername() {
    assertTrue(Mufasa.usernameValid("Valid_name"));
  }

  @Test
  public void nameValid_ReturnsFalseIfNonAlphaChars() {
    assertFalse(Mufasa.nameValid("123"));
    assertFalse(Mufasa.nameValid("@*#"));
  }

  @Test
  public void nameValid_ReturnsTrueForAValidName() {
    assertTrue(Mufasa.nameValid("Test"));
  }

  @Test
  public void passwordValid_ReturnsFalseIfSmallerThan8() {
    assertFalse(Mufasa.passwordValid("short"));
  }

  @Test
  public void passwordValid_ReturnsTrueForAValidPassword() {
    assertTrue(Mufasa.passwordValid("longer password"));
  }

  @Test
  public void oldEnough_ReturnsFalseForInvalidDates() {
    assertFalse(Mufasa.oldEnough("test date"));
  }

  @Test
  public void oldEnough_ReturnsFalseForDatesYoungerThan18() {
    assertFalse(Mufasa.oldEnough("01/01/2018"));
  }

  @Test
  public void oldEnough_ReturnsTrueForDatesOlderThan18() {
    assertTrue(Mufasa.oldEnough("01/01/1999"));
  }

  @Test
  public void phoneValid_ReturnsFalseForNonNumericChars() {
    assertFalse(Mufasa.phoneValid("test"));
  }

  @Test
  public void phoneValid_ReturnsTrueForAValidPhoneNumber() {
    assertTrue(Mufasa.phoneValid("1234567890"));
  }

  @Test
  public void streetAddressValid_ReturnsFalseForNonAlphaChars() {
    assertFalse(Mufasa.streetAddressValid("@#&*#"));
  }

  @Test
  public void streetAddressValid_ReturnsTrueForAValidAddress() {
    assertTrue(Mufasa.streetAddressValid("123 Test Street"));
  }

  @Test
  public void cityValid_ReturnsFalseForNumbers() {
    assertFalse(Mufasa.cityValid("City 123"));
  }

  @Test
  public void cityValid_ReturnsFalseForNonAlphaChars() {
    assertFalse(Mufasa.cityValid("City @*&#^$"));
  }

  @Test
  public void cityValid_ReturnsTrueForAValidCity() {
    assertTrue(Mufasa.cityValid("Valid City"));
  }

  @Test
  public void postalCodeValid_ReturnsFalseForAlphaChars() {
    assertFalse(Mufasa.postalCodeValid("postal-code"));
  }

  @Test
  public void postalCodeValid_ReturnsFalseNonNumberChars() {
    assertFalse(Mufasa.postalCodeValid("@#(*$"));
  }

  @Test
  public void postalCodeValid_ReturnsTrueForNumbers() {
    assertTrue(Mufasa.postalCodeValid("1234"));
  }

  @Test
  public void postalCodeValid_ReturnsTrueForDashes() {
    assertTrue(Mufasa.postalCodeValid("12-34-56"));
  }

  @Test
  public void countryValid_ReturnsFalseForNumbers() {
    assertFalse(Mufasa.countryValid("Country 123"));
  }

  @Test
  public void countryValid_ReturnsFalseForNonAlphaChars() {
    assertFalse(Mufasa.countryValid("Country @*&#^$"));
  }

  @Test
  public void countryValid_ReturnsTrueForAValidCountry() {
    assertTrue(Mufasa.countryValid("Valid Country"));
  }

  @Test
  public void testBankAccount_ReturnsTrueIfSuccessful() {
    BankProvider provider = new BankProviderDouble();
    assertTrue(Mufasa.testBankAccount(provider, BankProviderDouble.CORRECT_CVC));
    assertEquals(BankProviderDouble.STARTING_BALANCE, provider.getBalance(), 0.000001);
  }

  @Test
  public void testBankAccount_ReturnsFalseIfIncorrectCVC() {
    BankProvider provider = new BankProviderDouble();
    assertFalse(Mufasa.testBankAccount(provider, BankProviderDouble.CORRECT_CVC - 10));
  }

  @Test
  public void testBankAccount_ReturnsFalseIfDepositFails() {
    BankProviderDouble provider = new BankProviderDouble();
    provider.setFailNextDeposit(true);
    assertFalse(Mufasa.testBankAccount(provider, BankProviderDouble.CORRECT_CVC));
    assertEquals(BankProviderDouble.STARTING_BALANCE - 0.01, provider.getBalance(), 0.000001);
  }
}
