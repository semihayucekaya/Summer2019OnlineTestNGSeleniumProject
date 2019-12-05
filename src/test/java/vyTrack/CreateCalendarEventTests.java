package vyTrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.CreateCalendarEventPage;
import pages.LoginPage;
import tests.TestBase;

public class CreateCalendarEventTests extends TestBase {
    @Test(description = "Verify owners name is equals to Stephan Haley(it works on qa1 storemanager85")
    public void test1(){
        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        CreateCalendarEventPage createCalendarEventPage=new CreateCalendarEventPage();

        //login as stephan halley
        loginPage.login("storemanager85","UserUser123");

        //go to calendar events page
        loginPage.navigateTo("Activities","Calendar Events");

        //click on create calendar event button
        calendarEventsPage.clickCreateCalendarEvent();

        String expectedOwner="Stephan Haley";
        String actualOwner=createCalendarEventPage.owner.getText();
        Assert.assertEquals(expectedOwner,actualOwner);
    }
}
