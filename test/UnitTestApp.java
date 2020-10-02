package test;

import src.controller.*;
import src.model.*;

/**
 * Test Harness for the web forum app. 
 * Test harness created using modified generic test harness framework previously created and submitted for DSA by Rohan Khayech 
 * 
 * @author Rohan Khayech
 */
public class UnitTestApp
{
	static int tests, passed;
	static boolean debug;
	public static void main(String[] args) {
		init(args);
		
		Forum forum = new Forum();
		App app = new App(forum);

		test("Register User");
		try {
			app.registerUser("User 1", "password", "password");
			passIf(forum.userExists("User 1"),"Failed to create user.");
		} catch (Exception e2) {
			fail(e2.getMessage());
		}

		test("Register User - Duplicate User");
		try {
			app.registerUser("User 1", "pass", "pass");
			fail("Added duplicate user.");
		} catch (UsernameTakenException e) {
			pass();
		} catch (Exception e2) {
			fail(e2.getMessage());
		}

		test("Register User - Password Mismatch");
		try {
			app.registerUser("User 2", "pass", "password");
			fail("Added user despite passwords not matching.");
		} catch (PasswordMismatchException e) {
			pass();
		} catch (Exception e2) {
			fail(e2.getMessage());
		}

		test("Add Post - Logged Out");
		try {
			app.publishPost("Hello World.");
			fail("Published post while logged out.");
		} catch (UnauthorizedUserException e) {
			pass();
		} catch (Exception e2) {
			fail(e2.getMessage());
		}

		test("Add Post - Logged Out");
		try {
			app.publishPost("Hello World.");
			fail("Published post while logged out.");
		} catch (UnauthorizedUserException e) {
			pass();
		} catch (Exception e2) {
			fail(e2.getMessage());
		}

		test("Login - Invalid Username");
		try {
			app.login("User 2","password");
			fail("Logged in with invalid username.");
		} catch (InvalidLoginException e) {
			passIf(app.getCurrentUser()==null,"Logged in with invalid username.");
		} catch (Exception e2) {
			fail(e2.getMessage());
		}

		test("Login - Incorrect password");
		try {
			app.login("User 1", "pass");
			fail("Logged in with incorrect password.");
		} catch (InvalidLoginException e) {
			passIf(app.getCurrentUser()==null, "Logged in with incorrect password.");
		} catch (Exception e2) {
			fail(e2.getMessage());
		}

		test("Login");
		try {
			app.login("User 1", "password");
			passIf(app.getCurrentUser() == "User 1", "Failed to login.");
		} catch (Exception e2) {
			fail(e2.getMessage());
		}

		test("Add Post - Hello World");
		try {
			app.publishPost("Hello World ");
			Post p = forum.getPosts().get(0);
			passIf(p.getAuthor().getUsername().equals("User 1") && p.getBody().equals("Hello World "),"Post incorrect: "+p.toString());
		} catch (Exception e2) {
			fail(e2.getMessage());
		}

		test("Add Post - Example Post");
		try {
			app.publishPost("Example Post ");
			Post p = forum.getPosts().get(1);
			passIf(p.getAuthor().getUsername().equals("User 1") && p.getBody().equals("Example Post "),"Post incorrect: "+p.toString());
		} catch (Exception e2) {
			fail(e2.getMessage());
		}

		test("Convert Post Body from Unicode to Punycode - www.аррӏеstore.com");
		try {
			app.publishPost("www.аррӏеstore.com");
			Post p = forum.getPosts().get(2);
			passIf(p.getAuthor().getUsername().equals("User 1") && p.getBody().equals("www.xn--store-3ve9a1fa44l.com "), "Post not converted to punycode: " + p.getBody());
			if (debug) {
				System.out.println("Post Body: "+p.getBody());
			}
		} catch (Exception e2) {
			fail(e2.getMessage());
		}

		test("Logout");
		try {
			app.logout();
			passIf(app.getCurrentUser()==null, "Still logged in.");
		} catch (Exception e2) {
			fail(e2.getMessage());
		}

		summary();

		if (debug) {
			System.out.println("\nDebug - Showing all posts:");
			System.out.println(forum.getPosts());
		}

		
		/*
		//Tests
		test("");
		try {
			pass();
		} catch (Exception e2) {
			fail(e2.getMessage());
		}
		*/
		
	}
	
	//---- GENERIC TEST HARNESS FRAMEWORK by Rohan Khayech -------

	public static void init(String[] args) {
		tests = 0;
		passed = 0;
		
		if (args.length > 0) {
			if (args[0].equals("d")) {
				debug = true;
				System.out.println("Running in debug mode...");
			} else {
				System.out.println("Invalid mode argument - ignoring...");
				System.out.println("Note: Running with 'd' runs the program in debug mode.");
				debug = false;
			}
		} else {
			debug = false;
		}
	}
	
	public static void test(String title) {
		tests++;
		System.out.print("\nTest "+tests+" - "+title+": ");
	}
	
	public static void pass() {
		System.out.println("PASSED");
		passed++;
	}
	
	public static void passIf(boolean cond) {
		if (cond) 
		{
			System.out.println("PASSED");
			passed++;
		} else {
			fail();
		}
	}
	
	public static void passIf(boolean cond, String failMsg) {
		if (cond) 
		{
			System.out.println("PASSED");
			passed++;
		} else {
			fail(failMsg);
		}
	}
	
	public static void fail() {
		System.out.println("FAILED");
	}
	
	public static void fail(String message) {
		System.out.println("FAILED - "+message);
	}
	
	public static void summary() {
		System.out.println("\nSummary:\n"+passed+"/"+tests+" Passed - "+(((double)passed/(double)tests)*100.0)+"%");
	}
	
}