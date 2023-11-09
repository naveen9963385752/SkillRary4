package testScripts;

import org.testng.asserts.SoftAssert;
//test success
Run All
public class CreateCourseTest extends BaseClass {
	
	@Test
	Run | Debug
	public void createCourseTest() {
		SoftAssert soft = new SoftAssert();
		home.clickCoursesTab();
		home.clickCourseListLink();
		soft.assertTrue(course.getPageHeader().contains("Course List"));
		
		course.clickNe
	}
	

}
