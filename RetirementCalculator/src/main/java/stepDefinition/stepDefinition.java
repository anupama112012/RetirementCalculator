package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import pages.RetirementPageClass;
import util.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition extends TestBase {
	RetirementPageClass retpage=new RetirementPageClass();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	@Given("^Iam on Pre-retirement calculator page$")
	public void iam_on_Pre_retirement_calculator_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//retpage=new RetirementPageClass();
		TestBase.initialize();
		String title=retpage.validateTitle();
		Assert.assertEquals("How Much to Save for Retirement | Securian Financial",title);
		//throw new PendingException();
	}

	@When("^I fill mandatory fields$")
	public void i_fill_mandatory_fields() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		retpage=new RetirementPageClass();
		retpage.enterDetails("25","50","5000","2000","5","5");
		//throw new PendingException();
	}
	@When("^I calculate$")
	public void i_calculate() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		retpage=new RetirementPageClass();
		retpage.mandatoryfieldcheck();
		retpage.calculate();
		//throw new PendingException();
	}
	@And("^I calculate without filling mandatory fields$")
	public void i_calculate_without_filling_mandatory_fields() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		retpage=new RetirementPageClass();
		retpage.scrollToLastField();
		//retpage.mandatoryfieldcheck();
		retpage.calculate();
		//retpage.enterDetails("25","50","5000","2000","5","5");
		//retpage.calculate();
		//throw new PendingException();
	}
	@Then("^It shows my retirement$")
	public void it_shows_my_retirement() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//retpage=new RetirementPageClass();
		String title=retpage.ResultTitleCheck();
		Assert.assertEquals("Results",title);
		//throw new PendingException();
	}
	@Then("^It shows mandatory fields validation$")
	public void it_shows_mandatory_fields_validation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//retpage=new RetirementPageClass();
		retpage.mandatoryfieldcheck(); //throw new PendingException();
	}
	
	@When("^I click on default values link$")
	public void i_click_on_default_values_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		retpage.clickDefaultValuesLink();
		retpage.DefaultValuesTitleCheck();
		//throw new PendingException();
	}
	
	@When("^I fill values for default calculator$")
	public void i_fill_values_for_default_calculator() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		retpage.enterdefaultCalcValues("2500","5","50","5","5");
		retpage.selectInflationYes("5000");
		retpage.selectInflationNo();
		//throw new PendingException();
	}

	@When("^I save default calculator values$")
	public void i_save_default_calculator_values() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    retpage.Save();
	    //throw new PendingException();
	}
	
	@When("^I select Social Security field as Yes$")
	public void i_select_Social_Security_field_as_Yes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		retpage=new RetirementPageClass();
		retpage.selectSocialSecurityYes();
		//throw new PendingException();
	}

	@Then("^It shows additional fields$")
	public void it_shows_additional_fields() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		retpage.enterSocialSecurityDetails("Married","7000");
		retpage.enterSocialSecurityDetails("Single","6000");
		//throw new PendingException();
	}

	@When("^I select Social Security field as No$")
	public void i_select_Social_Security_field_as_No() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		retpage=new RetirementPageClass();
		retpage.selectSocialSecurityYes();
		retpage.selectSocialSecurityNo();
		//throw new PendingException();
	}

	@Then("^It does not show additional fields$")
	public void it_does_not_show_additional_fields() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		retpage.socialSecurityFieldsNotVisible();
		//throw new PendingException();
	}
	
	@After
	public void tearDown(){
	//driver.close();
	}

}
