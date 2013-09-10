package Inlupp1

/**
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

public class splitURL{
	private String url;
	private String protocol;
	private String domain;
	private String path;


	public splitURL(String inURL){
		url = inURL;
	}

	public String[] getAll(){
		String[] all = {url, protocol, domain, path}
		return all;
	}
}
