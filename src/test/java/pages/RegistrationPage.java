package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
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
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderContainer.$(byText(value)).click();

        return this;
    }

    public RegistrationPage typeUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbyContainer.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadImage(String value) {
        imageUploadButton.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage typeUserCurrentAddress(String value) {
        userCurrentAddress.setValue(value);

        return this;
    }


    public void setState(String value) {
        stateContainer.setValue(value).pressEnter();

    }

    public void setCity(String value) {
        cityContainer.setValue(value).pressEnter();

    }

    public RegistrationPage setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);

        return this;
    }

    public RegistrationPage submitRegistrationForm() {
        submitButton.click(ClickOptions.usingJavaScript());
        return this;
    }

    public RegistrationPage successMessageCheck(String value) {
        successMessageContainer.shouldHave(text(value));

        return this;
    }


    public void emptyFirstNameCheck(String key, String value ) {
        firstNameInput.shouldHave(cssValue(key, value));

    }

    public void emptyUserGenderCheck(String key, String value ) {
        userGenderRadiobutton.shouldHave(cssValue(key, value));

    }

    public void failedUserNumberCheck(String key, String value ) {
        userNumberInput.shouldHave(cssValue(key, value));

    }

}
