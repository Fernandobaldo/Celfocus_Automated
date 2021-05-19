package webServiceTesting.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import webServiceTesting.UserRegistration;

public class CreateUserTest {

  UserRegistration userRegistration = new UserRegistration();
  String jsonWithUserAndJob = "{\n" +
          "    \"name\": \"testName\",\n" +
          "    \"job\": \"testJob\"\n" +
          "}";

  String jsonWithUserNameSurnameAndJob = "{\n" +
          "    \"name\": \"testName autoSurname\",\n" +
          "    \"job\": \"testJob\"\n" +
          "}";

  @Before
  public void setup() {
    userRegistration.setName("testName");
    userRegistration.setJob("testJob");
  }

  @Test
  public void buildBody_validUserAndJob_shouldReturnJsonWithUserAndJob() {
    Assert.assertEquals(jsonWithUserAndJob, userRegistration.buildBody());
  }

  @Test
  public void buildBodyWithSurname_validUserAndJob_shouldReturnJsonWithUserNameSurnameAndJob() {
    Assert.assertEquals(jsonWithUserNameSurnameAndJob, userRegistration.buildBodyWithSurname());
  }

}
