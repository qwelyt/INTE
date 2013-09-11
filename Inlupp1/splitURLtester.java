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

	@Test
	public void testFormat(){
		splitURL test = new splitURL("http://www.google.com/");
		splitURL test2 = new splitURL("http://www.google.com");
		splitURL test3 = new splitURL("http://www.google.com/search?q=url");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFormatFail(){
		splitURL test = new splitURL("just a string");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFormatFail2(){
		splitURL test = new splitURL("http://");
	}

	@Test(expected = IllegalArgumentException.class)
	public void noProtocol(){
		splitURL test = new splitURL("www.google.com/");
	}

	@Test
	public void all(){
		splitURL test = new splitURL("http://www.google.com/search?q=url");
		org.junit.Assert.assertTrue(test.validURL());
		assertEquals("http", test.getProtocol());
		assertEquals("www.google.com", test.getDomain());
		assertEquals("search?q=url", test.getPath());
		assertEquals("Protocol: http, Domain: www.google.com, Path: search?q=url", test.toString());

	}

	@Test
	public void testFile(){
		splitURL test = new splitURL("file:///home/chewtoy/chewtoy.vim");
		org.junit.Assert.assertTrue(test.validURL());
		assertEquals("file", test.getProtocol());
		assertEquals("/home", test.getDomain());
		assertEquals("chewtoy/chewtoy.vim", test.getPath());
		assertEquals("Protocol: file, Domain: /home, Path: chewtoy/chewtoy.vim", test.toString());
	}

	@Test
	public void testSeveralSubs(){
		splitURL test = new splitURL("https://wiki.archlinux.org/index.php/Taking_a_Screenshot");
		org.junit.Assert.assertTrue(test.validURL());
		assertEquals("https", test.getProtocol());
		assertEquals("wiki.archlinux.org", test.getDomain());
		assertEquals("index.php/Taking_a_Screenshot", test.getPath());
		assertEquals("Protocol: https, Domain: wiki.archlinux.org, Path: index.php/Taking_a_Screenshot", test.toString());
	}

	@Test
	public void testSeveralProtocols(){
		splitURL test = new splitURL("http://test.com");
		assertEquals("http", test.getProtocol());

		splitURL test2 = new splitURL("https://test.com");
		assertEquals("https", test2.getProtocol());

		splitURL test3 = new splitURL("smtp://test.com");
		assertEquals("smtp", test3.getProtocol());

		splitURL test4 = new splitURL("file:///test.txt");
		assertEquals("file", test4.getProtocol());

		splitURL test5 = new splitURL("ftp://test.com");
		assertEquals("ftp", test5.getProtocol());

		splitURL test6 = new splitURL("gopher://test.com");
		assertEquals("gopher", test6.getProtocol());

		splitURL test7 = new splitURL("ssh://test.com");
		assertEquals("ssh", test7.getProtocol());

		splitURL test8 = new splitURL("imap://test.com");
		assertEquals("imap", test8.getProtocol());
	}


}
