package tests;

import org.testng.annotations.Test;

import base.BaseTest;

public class Firsttest extends BaseTest {

	@Test
	public void firstTest() { 
		// TODO Auto-generated method stub
		System.out.println("This is Test file");
		
		page.navigate("https://www.google.com/");
		String pageTitle = page.title();
		
		System.out.println("The page title is: " + pageTitle);
	}

}
