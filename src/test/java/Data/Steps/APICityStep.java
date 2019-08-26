package Data.Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class APICityStep {

    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    private String GET_META = "https://www.metaweather.com/api/location/search";
    private String GET_METAwoeid = "https://www.metaweather.com/api/location/";

    @Given("^a user retrieves the details by \"([^\"]*)\"$")
    public void aUserRetrievesTheDetailsBy(String city) {
        request = given().param("query", ""+ city +"");
        response = request.when().get(GET_META);
        response.prettyPrint();
    }

    @Then("^the status code is \"([^\"]*)\"$")
    public void theStatusCodeIs(int code) {
        response.then().assertThat().statusCode(code);
    }

    @And("^response content type is JSON$")
    public void responseIncludesTheFollowing() {
        response.then().assertThat().contentType(ContentType.JSON);
    }

    @Given("^a user retrieves the details by entering woeid \"([^\"]*)\"$")
    public void aUserRetrievesTheDetailsByEnteringWoeid(String id) throws Throwable {
        response =
                given().
                        get(GET_METAwoeid+id);
        response.prettyPrint();
    }
}
