package pagesteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.Commonlib;

public class MyStepdefs extends Commonlib {

    @Given("^User open the homepage$")
    public void userOpenTheHomepage() {
        openHome();
    }

    @When("^Search \"([^\"]*)\"$")
    public void search(String term) {
        kelimeAra(term);
    }

    @Then("^Open the \"([^\"]*)\" product$")
    public void openTheProduct(Integer productNo) throws InterruptedException {
       productTik(productNo);
    }

    @Then("^Add to selected product$")
    public void addToSelectedProduct() throws InterruptedException {
        addToCart();
    }

    @And("^Close driver$")
    public void closeDriver() {
        driverQuit();
    }
}
