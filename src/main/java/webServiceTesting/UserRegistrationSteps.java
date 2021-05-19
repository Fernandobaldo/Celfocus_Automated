package webServiceTesting;

import cucumber.api.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class UserRegistrationSteps {

    UserRegistration userRegistration;
    String email;

    @Given("^I use the Register User service$")
    public void useUserCreationWebService() {
        userRegistration = new UserRegistration();
    }

    @When("^I define the user Email \"([^\"]*)\"$")
    public void setName(String email) {
        userRegistration.setEmail(email);
        this.email = email;
    }

    @Then("^The user should not be created$")
    public void validateMyResponseIsCorrect() {
        RequestSpecification request = userRegistration.getRequestSpecification();
        request.basePath("/register");
        request.body(userRegistration.buildBodyWithEmail());
        Response response = request.post();
        Assert.assertEquals(400, response.getStatusCode());
    }

}

