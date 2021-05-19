package webServiceTesting;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class UserRegistration {

    private String name = "autoName";
    private String job = "autoJob";
    private String surname = "autoSurname";
    private String email = "autoEmail";
    private final RequestSpecification requestSpecification;

    public UserRegistration() {
        this.requestSpecification = RestAssured.given()
                .baseUri("https://reqres.in/api")
                .basePath("/users");
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String buildBody() {
        return  "{\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"job\": \"" + job + "\"\n" +
                "}";
    }

    public String buildBodyWithSurname() {
        return  "{\n" +
                "    \"name\": \"" + name + " " + surname + "\",\n" +
                "    \"job\": \"" + job + "\"\n" +
                "}";
    }

    public String buildBodyWithEmail() {
        return  "{\n" +
                "    \"email\": \"" + email + "\",\n" +
                "}";
    }

}
