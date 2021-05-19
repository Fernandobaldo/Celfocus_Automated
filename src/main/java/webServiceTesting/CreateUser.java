package webServiceTesting;


import cucumber.api.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.assertEquals;

public class CreateUser {

  UserRegistration userRegistration;
  String name, job;

  @Given("^I use user creation service$")
  public void useUserCreationWebService() {
    userRegistration = new UserRegistration();
  }

  @When("^I set name \"([^\"]*)\"$")
  public void setName(String name) {
    userRegistration.setName(name);
    this.name = name;
  }

  @When("^I set job \"([^\"]*)\"$")
  public void setJob(String job) {
    userRegistration.setJob(job);
    this.job = job;
  }

  @Then("^I validate my response is correct$")
  public void validateMyResponseIsCorrect() {
    RequestSpecification request = userRegistration.getRequestSpecification();
    request.header("Content-Type", "application/json");
    request.body(userRegistration.buildBody());
    Response response = request.post();
    assertEquals(201, response.getStatusCode());
  }

}
