package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	//Constructor
	public HomePage(WebDriver driver){

		this.driver=driver;
	}
	
	
	
	//Elements

	private By profile_tab=By.xpath("//span[contains(text(),'Profile')]");
	

	//Methods
	
	public void TaponProfile(){
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(profile_tab));
		driver.findElement(profile_tab).click();
	}


	

}
