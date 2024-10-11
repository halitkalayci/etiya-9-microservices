package io.github.halitkalayci.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;



@Service
public class BaseJwtService {
  // TODO: Read from env variables.
  //@Value("${jwt.expiration}")
  private Long EXPIRATION = 6000000L;
  //@Value("${jwt.secret_key}")
  private String SECRET_KEY = "cx4YnoSF1vOn3DCTpckRFlhhuSMWM1reEOrnoGQMrFUlE5kLCvPWaORnZ3hkkCxI7rf1YAznsTn5uM0detQksaFcCDGVHDVQzNB20Wu0EEIDxdlvfdlnAgryUtN7sQyTnmdzu5aM2pg9MKR8OKUHfMZkwEDjVXHuxsI9vRKnYoCnfiQv5Hv4SlC";


  public String generateToken(String userName) {
    return Jwts
            .builder()
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
            .subject(userName)
            .signWith(getSignKey())
            .compact();
  }

  public Boolean validateToken(String token)
  {
    try {
      return getClaimsFromToken(token).getExpiration().after(new Date());
    }
    catch(Exception e)
    {
      // Token bir şekilde çözümlenemezse..
      return false;
    }
  }
  public String extractUsername(String token)
  {
    return getClaimsFromToken(token).getSubject();
  }

  private Claims getClaimsFromToken(String token)
  {
    SecretKey key = (SecretKey) getSignKey();
    return Jwts
            .parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .getPayload();
  }

  private Key getSignKey() {
    byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
