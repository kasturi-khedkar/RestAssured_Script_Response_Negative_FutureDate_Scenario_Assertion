package StepsDefinition;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NegativeResponseAssert {

	Response response;
	@Test
	@Given("API for foreign Exchange")
	public void api_for_foreign_Exchange() {
		RestAssured.baseURI="https://api.ratesapi.io/";
	}

	@Test
	@When("posted with future date information")
	public void posted_with_future_date_information() {
		response=RestAssured.get("/api/2000-013-06");
	}

	@Test
	@Then("validate positive response code received")
	public void validate_positive_response_code_received() {
		int code=response.getStatusCode();
		Assert.assertEquals(code,400);
		System.out.println(code);

		String txt=response.getStatusLine();
		Assert.assertTrue(txt.contains("Bad Request"));
		System.out.println(txt);
	}

}
