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
		assertEquals("http", url2.getProtocol());
	}

	@Test
	public void getDomain(){
		System.out.println("Test 4");
		System.out.flush();
		splitURL url2 = new splitURL("http://www.google.com/search?q=url");
		assertEquals("www.google.com", url2.getDomain());
	}

	@Test
	public void getPath(){
		System.out.println("Test 5");
		System.out.flush();
		splitURL url2 = new splitURL("http://www.google.com/search?q=url");
		assertEquals("search?q=url", url2.getPath());
	}

	@Test
	public void getAll(){
		System.out.println("Test 6");
		System.out.flush();
		splitURL url2 = new splitURL("http://www.google.com/search?q=url");
		String[] expect = {"http://www.google.com/search?q=url", "http", "www.google.com", "search?q=url"};
		org.junit.Assert.assertArrayEquals(expect, url2.getAll());
	}

	@Test
	public void TesttoString(){
		System.out.println("Test 7");
		System.out.flush();
		splitURL url2 = new splitURL("http://www.google.com/search?q=url");
		assertEquals("Protocol: http, Domain: www.google.com, Path: search?q=url", url2.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void createEmpty(){
		System.out.println("Test 8");
		System.out.flush();
		splitURL url3 = new splitURL("");
		System.out.println("Test 8 done");
		System.out.flush();
	}

	@Test
	public void createFile(){
		System.out.println("Test 9");
		System.out.flush();
		splitURL url4 = new splitURL("file:///home/chewtoy/chewtoy.vim");
		assertEquals("file", url4.getProtocol());
		assertEquals("/home", url4.getDomain());
		assertEquals("chewtoy/chewtoy.vim", url4.getPath());
		System.out.println(url4.toString());
	}







}
