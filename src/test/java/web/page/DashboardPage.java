package web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
  private SelenideElement heading = $("[data-test-id=dashboard]");
  private SelenideElement card1AddButton = $("#root > div > ul > li:nth-child(1) > div > button");
  private SelenideElement card2AddButton = $("#root > div > ul > li:nth-child(2) > div > button");
  private SelenideElement amount = $("[data-test-id=amount] input");
  private SelenideElement from = $("[data-test-id=from] input");
  private SelenideElement transferButton = $("#root > div > form > button.button.button_view_extra.button_size_s.button_theme_alfa-on-white");
  private SelenideElement refresh = $("#root > div > button");
  private ElementsCollection cards = $$(".list__item div");
  private final String balanceStart = "баланс: ";
  private final String balanceFinish = " р.";

  public DashboardPage() {
    heading.shouldBe(visible);
  }

  public DashboardPage addMoneyToCard1(DataHelper.TransferInfo data) {
    card1AddButton.click();
    amount.setValue(data.getAmount());
    from.setValue(data.getNumber2());
    transferButton.click();
    return new DashboardPage();
  }

  public DashboardPage addMoneyToCard2(DataHelper.TransferInfo data) {
    card2AddButton.click();
    amount.setValue(data.getAmount());
    from.setValue(data.getNumber1());
    transferButton.click();
    return new DashboardPage();
  }

  public int getCardBalance(String id) {
    refresh.click();
    for (SelenideElement card : cards) {
      if (card.getAttribute("data-test-id").equals(id)) {
        return extractBalance(card.text());
      }
    }
    return 0;
  }

  private int extractBalance(String text) {
    val start = text.indexOf(balanceStart);
    val finish = text.indexOf(balanceFinish);
    val value = text.substring(start + balanceStart.length(), finish);
    return Integer.parseInt(value);
  }
}
