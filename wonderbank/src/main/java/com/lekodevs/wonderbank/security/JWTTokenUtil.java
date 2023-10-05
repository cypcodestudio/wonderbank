package com.lekodevs.wonderbank.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTTokenUtil {

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	@Value("${jwt.secret}")
	private String secret;

	// retrieve username from jwt token
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	// retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		if(claims != null) {
			return claimsResolver.apply(claims);
		}
		return null;
	}

	// for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		try {
			return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	// generate token for user
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
			claims.put("role", userDetails.getAuthorities());
		return doGenerateToken(claims, userDetails.getUsername());
	}
	
	// generate token for user
		public String generateRefreshToken(UserDetails userDetails) {
			Map<String, Object> claims = new HashMap<>();
				claims.put("role", userDetails.getAuthorities());
			return doGenerateRefreshToken(claims, userDetails.getUsername());
		}

	// while creating the token -
	// 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID
	// 2. Sign the JWT using the HS512 algorithm and secret key.
	// 3. According to JWS Compact
	// Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	// compaction of the JWT to a URL-safe string
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		Header header = Jwts.header();
		header.setType("JWT");
		return Jwts.builder().setHeader((Map<String, Object>) 
		        header).setClaims(claims).setSubject(subject).setIssuer("Wonderbank").setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	//refresh token
	private String doGenerateRefreshToken(Map<String, Object> claims, String subject) {
		Header header = Jwts.header();
		header.setType("JWT");
		return Jwts.builder().setHeader((Map<String, Object>) 
		        header).setClaims(claims).setSubject(subject).setIssuer("Wonderbank").setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 2 * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	// validate token
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		if(username != null) {
			return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));	
		}
		return false;
	}
}
