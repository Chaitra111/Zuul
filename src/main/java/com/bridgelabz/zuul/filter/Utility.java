package com.bridgelabz.zuul.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * @author Chaitra Ankolekar
 * Purpose :Utility class for validation
 */
public class Utility {
	static final String KEY = "chaitra";

	public Utility() {

	}
	/**
	 * to decode the jwt token
	 * @param jwt
	 * @return
	 * @throws ZuulException 
	 */
	public Claims parseJwt(String jwt) throws ZuulException {
		//System.out.println(jwt);
		 return Jwts.parser().setSigningKey(KEY).parseClaimsJws(jwt).getBody();
		/*try {
			Claims claims = Jwts.parser().setSigningKey("KEY").parseClaimsJws(jwt).getBody();
			return claims;
		} catch (UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
			throw new ZuulException("Error in JWT Token");
		} catch (ExpiredJwtException e) {
			throw new ZuulException("Token Expired");
		}*/
		}
}

	