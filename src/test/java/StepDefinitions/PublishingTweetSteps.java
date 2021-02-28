package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.TweetPage;


public class PublishingTweetSteps {

	WebDriver driver;
	HomePage homePageObject;
	LandingPage landingPageObject;
	ProfilePage profilePageObject;
	LoginPage loginPageObject;
	TweetPage tweetPageObject;

	@Before
	public void MainSetupForBrowserAndTwitter() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver1.exe");
		driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//Navigate to Twitter LandingPage
		driver.navigate().to("https://twitter.com/");

	}



	@Given("user is loggedin Twitter with his credentials {string} ,{string}")
	public void user_is_loggedin_twitter_with_his_credentials(String phone, String password) {

		landingPageObject=new LandingPage(driver);
		loginPageObject=new LoginPage(driver);
		landingPageObject.pressOnLoginOption();
		loginPageObject.userCanLogIn(phone, password);		
	}



	@When("user send plain text {string}")
	public void user_send_plain_text(String Tweet) throws InterruptedException {

		homePageObject=new HomePage(driver);
		profilePageObject=new ProfilePage(driver,Tweet);

		homePageObject.TaponProfile();
		profilePageObject.tapOnTweetButton();
		profilePageObject.publishTweet(Tweet);

	}

	@Then("{string} is published successfully")
	public void is_published_successfully(String Tweet) {

		profilePageObject=new ProfilePage(driver,Tweet);

		Assert.assertEquals(profilePageObject.getTextOfPublishedTweet(),Tweet);	
	}




	@When("user reply to his {string} with {string}")
	public void user_reply_to_his_with(String Tweet, String AnotherTweet)  {

		profilePageObject=new ProfilePage(driver,Tweet);
		tweetPageObject=new TweetPage(driver,AnotherTweet);

		tweetPageObject.pressOnReplyButton();
		tweetPageObject.writeAnotherTweet(AnotherTweet);
		tweetPageObject.pressOnTweetToAddAnotherTweet();

	}

	@Then("{string} reply is published successfully")
	public void reply_is_published_successfully(String AnotherTweet) throws InterruptedException {

		tweetPageObject=new TweetPage(driver,AnotherTweet);

		Thread.sleep(1000);
		Assert.assertEquals(tweetPageObject.getTextOfReplyTweet(),AnotherTweet);

	}



	@When("Try to send same {string} again")
	public void try_to_send_same_again(String Tweet) throws InterruptedException {

		profilePageObject=new ProfilePage(driver,Tweet);
		Thread.sleep(1000);
		profilePageObject.tapOnTweetButton();
		profilePageObject.publishTweet(Tweet);


	}

	@Then("{string} isn't sent and user get error message")
	public void isn_t_sent_and_user_get_error_message(String Tweet) {
		tweetPageObject=new TweetPage(driver,Tweet);

		Assert.assertEquals(tweetPageObject.getTextOfTwiceTweetError(),"Something went wrong, but don’t fret — let’s give it another shot.");
		System.out.println("Amiraaaaahaaaha"+tweetPageObject.getTextOfTwiceTweetError());
	}




	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}



}
