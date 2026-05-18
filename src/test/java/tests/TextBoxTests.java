package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static tests.testdata.TestData.*;

public class TextBoxTests extends TestBase {

    @Disabled
    @Test
    void successfulFillFormTest() {
        textBoxPage.openPage();
        textBoxPage.typeUserName(userName);
        textBoxPage.typeUserEmail(userEmail);
        textBoxPage.typeCurrentAddress(currentAddress);
        textBoxPage.typePermanentAddress(permanentAddress);

        textBoxPage.submitForm();

        textBoxPage.checkField("name", userName);
        textBoxPage.checkField("email", userEmail);
        textBoxPage.checkField("currentAddress", currentAddress);
        textBoxPage.checkField("permanentAddress", permanentAddress);
    }

    @Disabled
    @Test
    void failedFillFormTest() {
        textBoxPage.openPage();
        textBoxPage.typeUserName(userName);
        textBoxPage.typeUserEmail(failedUserEmail);
        textBoxPage.typeCurrentAddress(currentAddress);
        textBoxPage.typePermanentAddress(permanentAddress);

        textBoxPage.submitForm();

        textBoxPage.checkFailedUserEmail();
    }
}


