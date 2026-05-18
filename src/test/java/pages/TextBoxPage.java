package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    // Elements
    private SelenideElement userNameInput = $("#userName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement permanentAddressInput = $("#permanentAddress");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement outputResults = $("#output");

    // Actions
    public void openPage() {
        open("/text-box");

    }

    public void typeUserName(String value) {
        userNameInput.setValue(value);

    }

    public void typeUserEmail(String value) {
        userEmailInput.setValue(value);

    }

    public void typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);

    }

    public void typePermanentAddress(String value) {
        permanentAddressInput.setValue(value);

    }

    public void submitForm() {
        submitButton.click();

    }

    public void checkField(String key, String value) {
        outputResults.$(byId(key)).shouldHave(text(value));

    }

    public void checkFailedUserEmail() {
        userEmailInput.shouldHave(cssClass("field-error"));

    }
}
