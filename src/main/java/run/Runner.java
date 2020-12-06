package run;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jwt.Create;
import jwt.Validate;

public class Runner {


  public static void main(String[] args) throws Exception {

    String jwt = Create.createJwtSignedHMAC();


    System.out.println("JWT TOKEN IS : " + jwt);

    Jws<Claims> parseJwt = Validate.parseJwt(jwt);

    System.out.println(parseJwt);

  }

}
