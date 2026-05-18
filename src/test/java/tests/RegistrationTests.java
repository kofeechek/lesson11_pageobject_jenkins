package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.components.ResultFormComponent;

import static tests.testdata.TestData.*;

public class RegistrationTests extends TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "128.0";
//        Configuration.browserVersion = "130.0";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    ResultFormComponent resultFormComponent = new ResultFormComponent();

    @Test
    void successfulFillFormAllInputsTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .setGender(userGender)
                .typeUserNumber(userNumber)
                .setDateOfBirth(calendarDay, calendarMonth, calendarYear)
                .setHobby(userHobby)
                .uploadImage(userImage)
                .typeUserCurrentAddress(currentAddress)
                .setStateAndCity(userState, userCity)

                .submitRegistrationForm()

                .successMessageCheck(successMessage);
        resultFormComponent.checkFormResults("Student Name", firstName + " " + lastName)
                .checkFormResults("Student Email", userEmail)
                .checkFormResults("Gender", userGender)
                .checkFormResults("Mobile", userNumber)
                .checkFormResults("Date of Birth", calendarDay + " " + calendarMonth + "," + calendarYear)
                .checkFormResults("Hobbies", userHobby)
                .checkFormResults("Picture", userImage)
                .checkFormResults("Address", currentAddress)
                .checkFormResults("State and City", userState + " " + userCity);
    }

    @Test
    void successfulFillFormRequiredInputsTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(userGender)
                .typeUserNumber(userNumber)

                .submitRegistrationForm()

                .successMessageCheck(successMessage);
        resultFormComponent.checkFormResults("Student Name", firstName + " " + lastName)
                .checkFormResults("Gender", userGender)
                .checkFormResults("Mobile", userNumber);


    }

    @Test
    void failedFillFormFirstNameIsEmptyTest() {
        registrationPage.openPage()
                .typeLastName(lastName)
                .setGender(userGender)
                .typeUserNumber(userNumber)

                .submitRegistrationForm()

                .emptyFirstNameCheck(errorCssKey, errorCssValue);
    }


    @Test
    void failedFillFormGenderIsEmptyTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserNumber(userNumber)

                .submitRegistrationForm()

                .emptyUserGenderCheck(errorCssKey, errorCssValue);

    }

    @Test
    void failedFillFormUserNumberFilledByLettersTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(userGender)
                .typeUserNumber(failedUserNumber)

                .submitRegistrationForm()

                .failedUserNumberCheck(errorCssKey, errorCssValue);
    }

}

