package dio.dio_spring_security_jwt.security;

import java.security.Key;
import java.util.List;
import java.util.stream.Collectors;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;

public class JWTCreator {
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String ROLES_AUTHORITIES = "authorities";

    public static String create(String prefix, String key, JWTObject jwtObject) {
        Key signingKey = Keys.hmacShaKeyFor(key.getBytes());

        String token = Jwts.builder()
                .setSubject(jwtObject.getSubject())
                .setIssuedAt(jwtObject.getIssuedAt())
                .setExpiration(jwtObject.getExpiration())
                .claim(ROLES_AUTHORITIES, formatRoles(jwtObject.getRoles()))
                .signWith(signingKey, SignatureAlgorithm.HS512)
                .compact();

        return prefix + " " + token;
    }

    public static JWTObject create(String token, String prefix, String key)
            throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException {
        Key signingKey = Keys.hmacShaKeyFor(key.getBytes());
        token = token.replace(prefix, "").trim();

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        JWTObject object = new JWTObject();
        object.setSubject(claims.getSubject());
        object.setIssuedAt(claims.getIssuedAt());
        object.setExpiration(claims.getExpiration());

        Object rolesClaim = claims.get(ROLES_AUTHORITIES);
        if (rolesClaim instanceof List<?> list) {
            List<String> roles = list.stream()
                    .filter(item -> item instanceof String)
                    .map(String.class::cast)
                    .collect(Collectors.toList());
            object.setRoles(roles);
        }
        return object;
    }
    private static List<String> formatRoles(List<String> roles) {
        return roles.stream()
                .map(role -> "ROLE_" + role.replace("ROLE_", ""))
                .collect(Collectors.toList());
    }
}
