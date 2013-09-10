package Inlupp1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Test for splitURL
 * The splitURL-program is supposed to take a string,
 * evaluate the string to see if it's a URL,
 * split the URL into
 * 	protocal
 * 	domain
 * 	path
 * The result for http://www.google.com/search?q=url should be
 * 	http
 * 	www.google.com
 * 	search?q=url
 */

@RunWith(JUnit4.class)
public class splitURLtester{
	private splitURL url = new splitURL("apa");
	
	@Test
	public void creation(){
		System.out.println("Test 1");
		System.out.flush();
		assertNull(url);
	}
}
