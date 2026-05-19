package tests;

import org.junit.jupiter.api.Test;
import pages.components.ResultFormComponent;

import static io.qameta.allure.Allure.step;
import static tests.testdata.TestData.*;

public class RegistrationTests extends TestBase {

    ResultFormComponent resultFormComponent = new ResultFormComponent();

    @Test
    void successfulFillFormAllInputsTest() {
        step("Open form", () -> {
            registrationPage.openPage();
        });
        step("Fill form", () -> {
            registrationPage.typeFirstName(firstName)
                    .typeLastName(lastName)
                    .typeUserEmail(userEmail)
                    .setGender(userGender)
                    .typeUserNumber(userNumber)
                    .setDateOfBirth(calendarDay, calendarMonth, calendarYear)
                    .setHobby(userHobby)
                    .uploadImage(userImage)
                    .typeUserCurrentAddress(currentAddress)
                    .setStateAndCity(userState, userCity);
        });
        step("Submit form", () -> {
            registrationPage.submitRegistrationForm();
        });
        step("Verify results", () -> {
            registrationPage.successMessageCheck(successMessage);
            resultFormComponent.checkFormResults("Student Name", firstName + " " + lastName)
                    .checkFormResults("Student Email", userEmail)
                    .checkFormResults("Gender", userGender)
                    .checkFormResults("Mobile", userNumber)
                    .checkFormResults("Date of Birth", calendarDay + " " + calendarMonth + "," + calendarYear)
                    .checkFormResults("Hobbies", userHobby)
                    .checkFormResults("Picture", userImage)
                    .checkFormResults("Address", currentAddress)
                    .checkFormResults("State and City", userState + " " + userCity);
        });
    }

    @Test
    void successfulFillFormRequiredInputsTest() {
        step("Open form", () -> {
            registrationPage.openPage();
        });
        step("Fill form", () -> {
            registrationPage.typeFirstName(firstName)
                    .typeLastName(lastName)
                    .setGender(userGender)
                    .typeUserNumber(userNumber);
        });
        step("Submit form", () -> {
            registrationPage.submitRegistrationForm();
        });
        step("Verify results", () -> {
            registrationPage.successMessageCheck(successMessage);
            resultFormComponent.checkFormResults("Student Name", firstName + " " + lastName)
                    .checkFormResults("Gender", userGender)
                    .checkFormResults("Mobile", userNumber);
        });
    }

    @Test
    void failedFillFormFirstNameIsEmptyTest() {
        step("Open form", () -> {
            registrationPage.openPage();
        });
        step("Fill form", () -> {
            registrationPage.typeLastName(lastName)
                    .setGender(userGender)
                    .typeUserNumber(userNumber);
        });
        step("Submit form", () -> {
            registrationPage.submitRegistrationForm();
        });
        step("Verify results", () -> {
            registrationPage.emptyFirstNameCheck(errorCssKey, errorCssValue);
        });
    }


    @Test
    void failedFillFormGenderIsEmptyTest() {
        step("Open form", () -> {
            registrationPage.openPage();
        });
        step("Fill form", () -> {
            registrationPage.typeFirstName(firstName)
                    .typeLastName(lastName)
                    .typeUserNumber(userNumber);
        });
        step("Submit form", () -> {
            registrationPage.submitRegistrationForm();
        });
        step("Verify results", () -> {
            registrationPage.emptyUserGenderCheck(errorCssKey, errorCssValue);
        });
    }

    @Test
    void failedFillFormUserNumberFilledByLettersTest() {
        step("Open form", () -> {
            registrationPage.openPage();
        });
        step("Fill form", () -> {
            registrationPage.typeFirstName(firstName)
                    .typeLastName(lastName)
                    .setGender(userGender)
                    .typeUserNumber(failedUserNumber);
        });
        step("Submit form", () -> {
            registrationPage.submitRegistrationForm();
        });
        step("Verify results", () -> {
            registrationPage.failedUserNumberCheck(errorCssKey, errorCssValue);

        });

    }
}

