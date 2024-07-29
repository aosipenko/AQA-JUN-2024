package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.prog.page.GooglePage;
import org.prog.util.CucumberStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WebSteps {

    @Autowired
    private GooglePage googlePage;

    @Given("I load google page")
    public void loadGooglePage() {
        googlePage.loadPage();
        googlePage.acceptCookieIfPresent();
    }

    @Given("I take value from {string} and send it to google search")
    public void setSearchValueToRandomUsersName(String alias) {
        googlePage.setSearchValue((String) CucumberStorage.HOLDER.get(alias));
    }

    @When("I perform search")
    public void executeSearch() {
        googlePage.executeSearch();
    }

    @Then("I see at a {int} search results for {string}")
    public void validateSearchCount(int amount, String alias) {
        int count = 0;
        for (WebElement searchHeader : googlePage.getSearchHeaders()) {
            if (searchHeader.getText().toUpperCase().contains(
                    ((String) CucumberStorage.HOLDER.get(alias)).toUpperCase())) {
                count++;
            }
        }
//        List<String> slinst = new ArrayList<>();
//        Optional<String> opt = Optional.of("asd");
//        // java lambda functions
//
//        slinst.stream().forEach(System.out::println);
//
//        for (String s : slinst) {
//            System.out.println(s);
//        }

        Assert.assertTrue(count >= amount, "expected at least " + amount
                + " but was only " + count + " results for " + CucumberStorage.HOLDER.get(alias));
    }
}
