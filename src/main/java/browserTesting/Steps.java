package browserTesting;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Steps {

    WebDriver driver;

    @Given("^I open Chrome and launch the application$")
    public void openChromeAndLaunchApplication() throws InterruptedException {
        System.out.println("Starting - browser is open");
        String projectPath = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver");
        //System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/windowsChrome.exe"); Windows

        driver = new ChromeDriver();
        driver.navigate().to("https://qa-automation-challenge.github.io/sandbox/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies(); // Clear Browser Cookies

        sleep(1000);
        System.out.print("Inside Step - user is on board page");
    }


    @When("^I select type \"(.*)\"$")
    public void selectType(String type)
    {
        Select select = new Select(driver.findElement(By.id("type")));
        select.selectByVisibleText(type);
    }

    @When("^I select support plan \"(.*)\"$")
    public void selectSupportPlan(String plan)
    {
        Select select = new Select(driver.findElement(By.id("support")));
        select.selectByVisibleText(plan);
    }

    @When("^I write monthly duration of \"(.*)\"$")
    public void writeMonthlyDuration (String duration)
    {
        driver.findElement(By.id("duration")).sendKeys(duration);
    }

    @When("^I click in calculate price button")
    public void clickCalculatePriceButton()
    {
        driver.findElement(By.id("calculate")).click();
    }

    @Then("^I validate price is \"(.*)\"$")
    public void	validatePrice(String price) throws InterruptedException {
        Thread.sleep(5*1000);
        Assert.assertEquals(price, driver.findElement(By.id("price")).getText());
    }

/*
    @Then("^I attach file \"(.*)\"$")
    public void	attachFile(String file) throws  {
        WebElement uploadElement = driver.findElement(By.id("attachment"));
        uploadElement.sendKeys(file);
    }
*/
}
