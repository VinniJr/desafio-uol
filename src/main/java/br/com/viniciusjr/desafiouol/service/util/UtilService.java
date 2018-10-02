package br.com.viniciusjr.desafiouol.service.util;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class UtilService {

	public String getClientIpAddress(HttpServletRequest request) {
	    String xForwardedForHeader = request.getHeader("X-Forwarded-For");
	    if (xForwardedForHeader == null) {
	    	System.setProperty("java.net.preferIPv4Stack" , "true");
	    	System.out.println("IP CLIENT: "+request.getRemoteAddr());
	        return   request.getRemoteAddr();
	        
	    } else {
	        // As of https://en.wikipedia.org/wiki/X-Forwarded-For
	        // The general format of the field is: X-Forwarded-For: client, proxy1, proxy2 ...
	        // we only want the client
	        return new StringTokenizer(xForwardedForHeader, ",").nextToken().trim();
	    }
	}
}
