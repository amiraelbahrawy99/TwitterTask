package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TweetPage {

	WebDriver driver;
	WebDriverWait wait ;

	//Constructor

	public TweetPage(WebDriver driver,String AnotherTweet){

		this.driver=driver;
	}



	//Elements

	private By reply_btn=By.xpath("//div[@data-testid='reply']");
	private By another_tweet_txt=By.xpath("//*[@id='layers']/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div");
	private By tweet_another_tweet_btn=By.xpath("//*[@id='layers']/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[4]/div/span/span");
	private By twiceTweetErrorMsg=By.xpath("//*[contains(text(),'fret')]");
	private By reply_displaying_link=By.xpath("//*[@id='react-root']/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div/div[2]/section/div/div/div[1]/div/div/article/div/div/div/div[2]/div[2]/div[2]/div[1]/div");



	//Methods


	public void replyToTweet(String AnotherTweet) throws InterruptedException{


		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(reply_btn));
		pressOnReplyButton();
		Thread.sleep(1000);
		writeAnotherTweet(AnotherTweet);
		pressOnTweetToAddAnotherTweet();

	}


	public void pressOnReplyButton(){

		driver.findElement(reply_btn).click();
	}


	public void writeAnotherTweet(String AnotherTweet){
		driver.findElement(another_tweet_txt).sendKeys(AnotherTweet);

	}



	public void pressOnTweetToAddAnotherTweet(){

		driver.findElement(tweet_another_tweet_btn).click();;

	}


	public String getTextOfReplyTweet() throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(reply_displaying_link));
		return driver.findElement(reply_displaying_link).getText();
	}
	
	public String getTextOfTwiceTweetError()
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(twiceTweetErrorMsg));
		return driver.findElement(twiceTweetErrorMsg).getText();
		
	}



}
