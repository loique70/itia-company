package com.itia.sitevitrine.bdd_integration_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.itia.sitevitrine.sitevitrineApplication;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest(classes = sitevitrineApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@CucumberContextConfiguration
@DirtiesContext
public class JustToSayHelloWorld {
    private String message;

    @LocalServerPort
    private int port;

    @When("One clicks the open button")
    public void oneClicksTheOpenButton() {
        this.message = "Hello world !!!";
    }

    @Then("The message {string} is shown on its screen")
    public void theMessageInParamIsShownOnItsScreen(String mess) {
        assertEquals(message, mess);
    }
}
