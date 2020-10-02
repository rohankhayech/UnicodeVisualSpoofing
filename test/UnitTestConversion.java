package test;

import src.controller.*;
import src.model.*;

/**
 * Test Harness for converting IDN's in the post body to punycode.
 * Test harness created using modified generic test harness framework previously created and submitted for DSA by Rohan Khayech
 * 
 * @author Rohan Khayech
 */
public class UnitTestConversion
{
	static int tests, passed;
	static boolean debug;
	public static void main(String[] args) {
		init(args);
		
		Forum forum = new Forum();
		App app = new App(forum);

		try {
			app.registerUser("User 1", "password", "password");
			app.login("User 1", "password");
		} catch (Exception e) {
			e.printStackTrace();
		}

		test("Regular Text - No Conversion");
		try {
			app.publishPost("Hello World");
			Post p = forum.getPosts().get(0);
			passIf(p.getBody().equals("Hello World"),"Post converted incorrectly: "+p.toString());
		} catch (Exception e2) {
			fail(e2.getMessage());
		}

		test("Convert Unicode to Punycode - аррӏеstore.com");
		try {
			app.publishPost("аррӏеstore.com");
			Post p = forum.getPosts().get(1);
			passIf(p.getAuthor().getUsername().equals("User 1") && p.getBody().equals("xn--store-3ve9a1fa44l.com"), "Post not converted to punycode: " + p.getBody());
			if (debug) {
				System.out.println("Post Body: "+p.getBody());
			}
		} catch (Exception e2) {
			fail(e2.getMessage());
		}

		test("Convert Unicode to Punycode - www.аррӏеstore.com");
		try {
			app.publishPost("www.аррӏеstore.com");
			Post p = forum.getPosts().get(2);
			passIf(p.getAuthor().getUsername().equals("User 1") && p.getBody().equals("www.xn--store-3ve9a1fa44l.com"),
					"Post not converted to punycode: " + p.getBody());
			if (debug) {
				System.out.println("Post Body: " + p.getBody());
			}
		} catch (Exception e2) {
			fail(e2.getMessage());
		}

		test("Convert Unicode to Punycode - https://www.аррӏеstore.com");
		try {
			app.publishPost("https://www.аррӏеstore.com");
			Post p = forum.getPosts().get(3);
			passIf(p.getAuthor().getUsername().equals("User 1") && p.getBody().equals("https://www.xn--store-3ve9a1fa44l.com"),
					"Post not converted to punycode: " + p.getBody());
			if (debug) {
				System.out.println("Post Body: " + p.getBody());
			}
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