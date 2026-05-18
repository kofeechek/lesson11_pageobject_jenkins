package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


public class CalendarComponent {
    //     Elements
    private SelenideElement monthSelect = $(".react-datepicker__month-select");
    private SelenideElement yearSelect = $(".react-datepicker__year-select");
    private String daySelectorTemplate = ".react-datepicker__day--%03d:not(.react-datepicker__day--outside-month)";

    // Actions
    public void setDate(String day, String month, String year) {
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        int dayNumber = Integer.parseInt(day);
        String selector = String.format(daySelectorTemplate, dayNumber);
        $(selector).click();
    }
}
