package stepDefination;

import io.cucumber.java.en.Then;

public class CloseStep extends BaseClass{

    @Then("User close the browser")
    public void user_close_the_browser() {

        driver.close();
    }

}
