package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();

    // Elements
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement genderContainer = $("#genterWrapper");
    private SelenideElement hobbyContainer = $("#hobbiesWrapper");
    private SelenideElement imageUploadButton = $("#uploadPicture");
    private SelenideElement userCurrentAddress = $("#currentAddress");
    private SelenideElement stateContainer = $("#react-select-3-input");
    private SelenideElement cityContainer = $("#react-select-4-input");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement successMessageContainer = $("#example-modal-sizes-title-lg");
    private SelenideElement userGenderRadiobutton = $("#gender-radio-1");

    // Actions
    @Step("Open registration page /automation-practice-form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    @Step("Type first name \"{value}\"")
    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Type last name \"{value}\"")
    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Type user email \"{value}\"")
    public RegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Set gender \"{value}\"")
    public RegistrationPage setGender(String value) {
        genderContainer.$(byText(value)).click();

        return this;
    }

    @Step("Type user number \"{value}\"")
    public RegistrationPage typeUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Set date of birth \"{day}\" \"{month}\" \"{year}\"")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }

    @Step("Set hobby \"{value}\"")
    public RegistrationPage setHobby(String value) {
        hobbyContainer.$(byText(value)).click();

        return this;
    }

    @Step("Upload image \"{value}\"")
    public RegistrationPage uploadImage(String value) {
        imageUploadButton.uploadFromClasspath(value);

        return this;
    }

    @Step("Type user current address \"{value}\"")
    public RegistrationPage typeUserCurrentAddress(String value) {
        userCurrentAddress.setValue(value);

        return this;
    }

    @Step("Set state \"{value}\"")
    public void setState(String value) {
        stateContainer.setValue(value).pressEnter();

    }

    @Step("Set City \"{value}\"")
    public void setCity(String value) {
        cityContainer.setValue(value).pressEnter();

    }

    @Step("Set state \"{state}\" and city \"{city}\"")
    public RegistrationPage setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);

        return this;
    }

    @Step("Submit form")
    public RegistrationPage submitRegistrationForm() {
        submitButton.click(ClickOptions.usingJavaScript());
        return this;
    }

    @Step("Check success message \"{value}\"")
    public RegistrationPage successMessageCheck(String value) {
        successMessageContainer.shouldHave(text(value));

        return this;
    }

    @Step("Check first name \"{key}\": \"{value}\"")
    public void emptyFirstNameCheck(String key, String value ) {
        firstNameInput.shouldHave(cssValue(key, value));

    }

    @Step("Check user gender \"{key}\": \"{value}\"")
    public void emptyUserGenderCheck(String key, String value ) {
        userGenderRadiobutton.shouldHave(cssValue(key, value));

    }

    @Step("Check user number \"{key}\": \"{value}\"")
    public void failedUserNumberCheck(String key, String value ) {
        userNumberInput.shouldHave(cssValue(key, value));

    }

}
