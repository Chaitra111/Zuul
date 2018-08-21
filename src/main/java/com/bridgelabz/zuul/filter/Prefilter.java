package com.bridgelabz.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @author Chaitra Ankolekar
 * Purpose :Filter class
 */
public class Prefilter extends ZuulFilter {
	
	@Autowired
	Utility utility;

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run(){

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		System.out.println("run method executing");
		if (request.getRequestURI().matches("(.*)/notes(.*)")) {
			System.out.println("entering to note api");
			String token = request.getHeader("Authorization");
			String userId;
			try {
				System.out.println("Token is "+token);
				//Claims claims=utility.parseJwt(token);
				userId =utility.parseJwt(token).getSubject();
				System.out.println("uderid is "+userId);
				System.out.println("id is:"+utility.parseJwt(token).getIssuer());
			
				ctx.set("Authorization");
				//ctx.addZuulRequestHeader("userId", userId);
			} catch (ZuulException e) { 
				e.printStackTrace();
			}
		}
		return null;
	}	
}







