package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import net.bytebuddy.agent.builder.AgentBuilder.RawMatcher.Disjunction;
import pomPage.AddNewCategoryPage;
import pomPage.AddNewCoursePage;
import pomPage.AddNewUserPage;
import pomPage.AdminHomePage;
import pomPage.CategoryPage;
import pomPage.CourseListPage;
import pomPage.LoginPage;
import pomPage.UsersPage;
import pomPage.WelcomePage;
// this is base class

public class BaseClass {
	
	//@BeforeSuite
	//@BeforeTest
	
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility webUtil;
	protected WebDriver driver;
	
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	
	protected WelcomePage welcome;
	protected LoginPage login;
	protected AdminHomePage home;
	protected UsersPage users;
	protected CourseListPage course;
	protected CategoryPage category;
	protected AddNewUserPage addUser;
	protected AddNewCoursePage addCourse;
	protected AddNewCategoryPage addCategory;
	
	
	@BeforeClass
	public void classConfig() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		jutil = new JavaUtility();
		webUtil = new WebDriverUtility();
		
		property.propertiesInitialization(IConstentPath.PROPERTIES_PATH);
		driver = webUtil.launchBrowser(property.readFromProperties("browser"));
		
		sdriver = driver;
		sjutil = jutil;
	}
	
	@BeforeMethod
	public void methodConfig() {
		excel.excelInitialization(IConstentPath.PROPERTIES_PATH);
		
		welcome = new WelcomePage(driver);
		login = new LoginPage(driver);
		home = new AdminHomePage(driver);
		users = new UsersPage(driver);
		course = new CourseListPage(driver);
		category = new CategoryPage(driver);
		addUser = new AddNewUserPage(driver);
		addCourse = new AddNewCoursePage(driver);
		addCategory = new AddNewCategoryPage(driver);
		
		webUtil.navigateToApp(property.readFromProperties("url"));
		
		long time = Long.parseLong(property.readFromProperties("timeouts"));
		webUtil.waitTillElementFound(time);
		
		welcome.clickLoginButton();
		login.setEmail(property.readFromProperties("username"));
		login.setpassword(property.readFromProperties("password"));
		login.clickLogin();
		
		Assert.assertEquals(home.getAdminIcon(), "SkillRary Admin");
	}
	
	@AfterMethod
	public void methodTeardown() {
		excel.closeExcel();
		home.signOutofApp();
	}
	
	@AfterClass
	public void classTeardown() {
		webUtil.closeCurrentWindow();
	}
	
	//@AfterTest
	//@AfterSuite
	
	}

	
	
	


