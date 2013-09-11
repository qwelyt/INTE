package Inlupp1;

import java.util.regex.*;
import java.util.*;
import java.lang.*;

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


	splitURL(String inURL){
		if(inURL != "")
			url = inURL;
		else
			throw new IllegalArgumentException("URL is empty"); 
	}

	public String[] getAll(){
		this.getProtocol();
		this.getDomain();
		this.getPath();
		String[] all = {url, protocol, domain, path};
		return all;
	}

	public String getInput(){
		return url;
	}

	public String getProtocol(){
		Pattern pattern = Pattern.compile("(.*)(?=(://))");
		Matcher matcher = pattern.matcher(url);
		if(matcher.find()){
			protocol = matcher.group(0);
		}
		else{
			protocol = "not found";
		}
		return protocol;
	}

	public String getDomain(){
		Pattern pattern = Pattern.compile("(?<=(://))(/)?(.*?)(?=(?:/|$))");
		Matcher matcher = pattern.matcher(url);
		if(matcher.find()){
			domain = matcher.group(0);
		}
		else{
			domain = "not found";
		}
		return domain;
	}

	public String getPath(){
		Pattern pattern = Pattern.compile("(?<=[a-zA-Z]/)(.*)$");
		Matcher matcher = pattern.matcher(url);
		if(matcher.find()){
      			path = matcher.group(0);
		}
		else{
			path = "";
		}
		return path;
	}

	public String toString(){
		this.getProtocol();
		this.getDomain();
		this.getPath();
		return "Protocol: "+protocol+", Domain: "+domain+", Path: "+path;
	}

}
