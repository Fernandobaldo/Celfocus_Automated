package webServiceTesting;

import cucumber.api.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class DeleteUserSteps {

    UserRegistration userRegistration;
    String userID;

    @Given("^I use the User Delete service$")
    public void useUserCreationWebService() {
        userRegistration = new UserRegistration();
    }

    @When("^I define the userId \"([^\"]*)\"$")
    public void setName(String userID) {
        this.userID = userID;
    }

    @Then("^The user should be deleted$")
    public void validateMyResponseIsCorrect() {
        RequestSpecification request = userRegistration.getRequestSpecification();
        request.basePath("/users/" + userID);
        Response response = request.delete();
        Assert.assertEquals(204, response.getStatusCode());
    }

}
