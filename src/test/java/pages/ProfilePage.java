package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

	WebDriver driver;
	WebDriverWait wait;

	//Constructor

	public ProfilePage(WebDriver driver,String Tweet){

		this.driver=driver;
	}


	//Elements

	
	private By tweet_Link=By.xpath("//div[@id='react-root']/div/div/div[2]/header/div/div/div/div/div[3]/a/div/span/div/div/span/span");
	private By tweet_displaying_link=By.xpath("//*[@id='react-root']/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div/div[2]/section/div/div/div[1]/div/div/article/div/div/div/div[2]/div[2]/div[2]/div[1]/div/span");
	//private By tweet_displaying_link=By.xpath("//*[contains(text(),Tweet)]");
	private By tweet_txt=By.xpath("//div[@id='layers']/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[3]/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div");
	private By tweet_btn=By.xpath("//div[@id='layers']/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[3]/div/div/div/div/div/div/div/div/div[2]/div[4]/div/div/div[2]/div[4]/div/span/span");




	//Methods


	public void tapOnTweetButton(){
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(tweet_Link));
		driver.findElement(tweet_Link).click();
	}



	public void publishTweet(String Tweet ) throws InterruptedException{

		Thread.sleep(1000);
		writeTweet(Tweet);
		pressOnTweetButton();

	}




	public void openPublishedTweet(){

		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(tweet_displaying_link));

		driver.findElement(tweet_displaying_link).click();
	}


	public String getTextOfPublishedTweet(){
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(tweet_displaying_link));

		return driver.findElement(tweet_displaying_link).getText();
	}

	public void writeTweet(String Tweet){

		driver.findElement(tweet_txt).sendKeys(Tweet);
	}


	public void pressOnTweetButton(){

		driver.findElement(tweet_btn).click();
	}



	




}
