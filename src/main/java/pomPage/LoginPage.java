package pomPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// declaration

	@FindBy(xpath = "//h3[text()='Login']")
	private WebElement pageHeader;

	@FindBy(id = "email")
	private WebElement emailTF;

	@FindBy(id = "password")
	private WebElement passwordTF;

	@FindBy(id = "login")
	private WebElement loginButton;

//Intialization

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//Utilization
	
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
   
	public void setEmail(String email)
	{
		emailTF.sendKeys(email);
	}
	
	public void setpassword(String password)
	{
		passwordTF.sendKeys(password);
	}
	
	public void clickLogin()
	{
		loginButton.submit();
	}
}


