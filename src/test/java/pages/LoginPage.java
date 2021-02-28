package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	protected WebDriver driver;

	//Constructor
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}


	//Elements

	private By phone_txt= By.name("session[username_or_email]");
	private By password_txt= By.name("session[password]");
	private By Login_btn= By.xpath("//*[@id='react-root']/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div/div/span/span");

	

	//Methods
	
	public void userCanLogIn(String phone,String password){

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(phone_txt));
		enterPhone(phone);
		enterPassword(password);
		clickOnLogInButton();
	}
	


	public void enterPhone(String phone){

		driver.findElement(phone_txt).sendKeys(phone);
	}



	public void enterPassword(String password){

		driver.findElement(password_txt).sendKeys(password);
	}



	public void clickOnLogInButton(){

		driver.findElement(Login_btn).click();
	}

}
