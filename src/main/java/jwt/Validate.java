package jwt;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class Validate {

  public static Jws<Claims> parseJwt(String jwtString) throws Exception {

    PublicKey publicKey = getPublicKey();

    Jws<Claims> jwt = Jwts.parserBuilder().setSigningKey(publicKey).build().parseClaimsJws(jwtString);

    return jwt;
  }

  private static PublicKey getPublicKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
    String rsaPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyu3NB7Tr3nzETLNbZHYi"
        + "ZvgNeg3/OZUJZl40LzBzYGOD/8575eJETjfQ3QXaNyvNThu6Uf9B/V73QUxKI4/+"
        + "rwlbjA3niIga4MdDiY4b9K/KFA+HedvtZF1yE2p4smXGydPLOLBe31EgriGTob78"
        + "EE3f7SMFxlNaqn4Pm7KJkOodnMz0ilwLseeL1IkTtiFn/2OrcMpPHMtTxyDn3pQl"
        + "VCeJM5j/grDh+0YdyTMGdDHOBgM53VqSsDVyo1TNtP2yhPRYCIiI85hEHVaUnVM9"
        + "jGwCjNZLJHWh10Mrmh6B3z8BEmLhMAZXeL4fQBjBd42DLvIIJwM1USKFhjK+XghN" + "rQIDAQAB";

    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(rsaPublicKey));
    KeyFactory kf = KeyFactory.getInstance("RSA");
    PublicKey publicKey = kf.generatePublic(keySpec);
    return publicKey;
  }

}
