package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	
	protected WebDriver driver;

	//Constructor
	public LandingPage(WebDriver driver){
		this.driver=driver;
	}


	//Elements

	private By login_btn= By.xpath("//*[@id='react-root']/div/div/div/main/div/div/div/div[1]/div/div[3]/a[2]/div");

	
	
	//Methods
	
	public void pressOnLoginOption(){
		
		driver.findElement(login_btn).click();
	}

}
