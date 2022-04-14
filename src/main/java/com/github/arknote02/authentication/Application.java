package com.github.arknote02.authentication;

import com.github.arknote02.authentication.domain.event.Authenticate;
import com.github.arknote02.authentication.domain.model.AccessToken;
import com.github.arknote02.authentication.domain.model.Credential;
import com.github.arknote02.authentication.domain.model.LoginId;
import com.github.arknote02.authentication.domain.model.Password;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(Application.class, args);
    Authenticate authenticate = context.getBean(Authenticate.class);
    LoginId loginId = new LoginId("arknote02");
    Password password = new Password("password");
    AccessToken accessToken = authenticate.authenticate(new Credential(loginId, password));
    System.out.println(accessToken);
  }
}
