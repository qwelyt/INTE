package Inlupp1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Assert.*;

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
	splitURL url = new splitURL("apa");
	
	@Test
	public void creation(){
		System.out.println("Test 1");
		System.out.flush();
		org.junit.Assert.assertNotNull(url);
	}

	@Test
	public void getString(){
		System.out.println("Test 2");
		System.out.flush();
		assertEquals("apa", url.getInput());
	}

	@Test
	public void getProtocol(){
		System.out.println("Test 3");
		System.out.flush();
		splitURL url2 = new splitURL("http://www.google.com/search?q=url");
		assertEquals("http", url2.getDomain());
	}

}
