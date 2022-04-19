package web.test;

import com.codeborne.selenide.Configuration;
import net.jodah.failsafe.internal.util.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import web.data.DataHelper;
import web.page.DashboardPage;
import web.page.LoginPageV1;
import web.page.LoginPageV2;
import web.page.LoginPageV3;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class MoneyTransferTest {

  @BeforeEach
  void setup() {
    Configuration.headless = true;
    Configuration.holdBrowserOpen = true;
  }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
      open("http://localhost:9999");
      var loginPage = new LoginPageV1();
//      var loginPage = open("http://localhost:9999", LoginPageV1.class);
      var authInfo = DataHelper.getAuthInfo();
      var verificationPage = loginPage.validLogin(authInfo);
      var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
      verificationPage.validVerify(verificationCode);
      var transferFrame = new DashboardPage();
      var transferInfo = DataHelper.getCardTransferInfo("1000");
      transferFrame.addMoneyToCard1(transferInfo);
      $("#root > div > ul > li:nth-child(2) > div > button").click();
      $("[data-test-id=amount] input").doubleClick();
      $("[data-test-id=amount] input").sendKeys(Keys.DELETE);
      $("[data-test-id=amount] input").doubleClick();
      $("[data-test-id=amount] input").sendKeys(Keys.DELETE);
      $("[data-test-id=from] input").doubleClick();
      $("[data-test-id=from] input").sendKeys(Keys.DELETE);
      $("[data-test-id=from] input").doubleClick();
      $("[data-test-id=from] input").sendKeys(Keys.DELETE);
      $("[data-test-id=from] input").doubleClick();
      $("[data-test-id=from] input").sendKeys(Keys.DELETE);
      $("[data-test-id=from] input").doubleClick();
      $("[data-test-id=from] input").sendKeys(Keys.DELETE);
      $("#root > div > form > button:nth-child(3)").click();
      transferFrame.addMoneyToCard2(transferInfo);
      var actual = transferFrame.getCardBalance(transferInfo.getId1());
      var expected = 10000;
      Assert.isTrue(actual == expected, "Ошибка");
    }

  @Test
  void shouldTransferMoneyBetweenOwnCardsV2() {
    open("http://localhost:9999");
    var loginPage = new LoginPageV2();
//    var loginPage = open("http://localhost:9999", LoginPageV2.class);
    var authInfo = DataHelper.getAuthInfo();
    var verificationPage = loginPage.validLogin(authInfo);
    var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    verificationPage.validVerify(verificationCode);
    var transferFrame = new DashboardPage();
    var transferInfo = DataHelper.getCardTransferInfo("1000");
    transferFrame.addMoneyToCard1(transferInfo);
    $("#root > div > ul > li:nth-child(2) > div > button").click();
    $("[data-test-id=amount] input").doubleClick();
    $("[data-test-id=amount] input").sendKeys(Keys.DELETE);
    $("[data-test-id=amount] input").doubleClick();
    $("[data-test-id=amount] input").sendKeys(Keys.DELETE);
    $("[data-test-id=from] input").doubleClick();
    $("[data-test-id=from] input").sendKeys(Keys.DELETE);
    $("[data-test-id=from] input").doubleClick();
    $("[data-test-id=from] input").sendKeys(Keys.DELETE);
    $("[data-test-id=from] input").doubleClick();
    $("[data-test-id=from] input").sendKeys(Keys.DELETE);
    $("[data-test-id=from] input").doubleClick();
    $("[data-test-id=from] input").sendKeys(Keys.DELETE);
    $("#root > div > form > button:nth-child(3)").click();
    transferFrame.addMoneyToCard2(transferInfo);
    var actual = transferFrame.getCardBalance(transferInfo.getId1());
    var expected = 10000;
    Assert.isTrue(actual == expected, "Ошибка");
  }

  @Test
  void shouldTransferMoneyBetweenOwnCardsV3() {
    var loginPage = open("http://localhost:9999", LoginPageV3.class);
    var authInfo = DataHelper.getAuthInfo();
    var verificationPage = loginPage.validLogin(authInfo);
    var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    verificationPage.validVerify(verificationCode);
    var transferFrame = new DashboardPage();
    var transferInfo = DataHelper.getCardTransferInfo("1000");
    transferFrame.addMoneyToCard1(transferInfo);
    $("#root > div > ul > li:nth-child(2) > div > button").click();
    $("[data-test-id=amount] input").doubleClick();
    $("[data-test-id=amount] input").sendKeys(Keys.DELETE);
    $("[data-test-id=amount] input").doubleClick();
    $("[data-test-id=amount] input").sendKeys(Keys.DELETE);
    $("[data-test-id=from] input").doubleClick();
    $("[data-test-id=from] input").sendKeys(Keys.DELETE);
    $("[data-test-id=from] input").doubleClick();
    $("[data-test-id=from] input").sendKeys(Keys.DELETE);
    $("[data-test-id=from] input").doubleClick();
    $("[data-test-id=from] input").sendKeys(Keys.DELETE);
    $("[data-test-id=from] input").doubleClick();
    $("[data-test-id=from] input").sendKeys(Keys.DELETE);
    $("#root > div > form > button:nth-child(3)").click();
    transferFrame.addMoneyToCard2(transferInfo);
    var actual = transferFrame.getCardBalance(transferInfo.getId1());
    var expected = 10000;
    Assert.isTrue(actual == expected, "Ошибка");
  }
}

