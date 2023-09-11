package stepDefinations;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PracticeSD {
	@Given("User login to {string} with {string} and {string}")
	public void dataAsString(String url, String email, String password) {
	    System.out.println(url);
	    System.out.println(email);
	    System.out.println(password);
	}
	@When("User handles datatable with header")
	public void user_handles_datatable_with_header(DataTable data) {
		List<List<String>> d = data.asLists();
		System.out.println(d.get(3).get(1));
	    
	}
	@When("User handles datatable without header")
	public void user_handles_datatable_without_header(DataTable data) {
	    List<String> d = data.asList();
	    System.out.println(d.get(2));
	    System.out.println(d.get(8));
	}
	@Given("User handles exmaple table")
	public void user_handles_exmaple_table() {
	 System.out.println("Running scenario outline");
	}
	@Then("User enter {string} and {string}")
	public void user_enter_and(String email, String password) {
	    System.out.println(email);
	    System.out.println(password);
	}
}
