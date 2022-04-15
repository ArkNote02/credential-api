package com.github.arknote02.authentication.domain.service;

import com.github.arknote02.authentication.domain.event.Authenticate;
import com.github.arknote02.authentication.domain.model.AccessToken;
import com.github.arknote02.authentication.domain.model.Credential;
import com.github.arknote02.authentication.domain.model.HashedPassword;
import com.github.arknote02.authentication.domain.model.LoginId;
import com.github.arknote02.authentication.domain.model.StoredCredential;
import com.github.arknote02.authentication.domain.port.AccessTokenNotifier;
import com.github.arknote02.authentication.domain.port.CredentialRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthenticateService implements Authenticate {

  private final CredentialRepository repository;
  private final AccessTokenNotifier notifier;

  @Override
  public AccessToken authenticate(Credential credential) {
    try {
      // Is this credential stored?
      LoginId loginId = credential.loginId();
      StoredCredential storedCredential = repository.find(loginId);
      if (storedCredential == null) {
        return null;
      }
      // Is the password correct?
      HashedPassword password = credential.password().hash();
      HashedPassword storedPassword = storedCredential.hashedPassword();
      boolean isValid = Objects.equals(password, storedPassword);
      if (!isValid) {
        return null;
      }
      // Create an access token.
      String token = "tooooooooooken";
      String tokenSecret = "seeeeeeeeeecret";
      AccessToken accessToken = new AccessToken(token, tokenSecret);
      notifier.notice(loginId, accessToken);
      return accessToken;
    } catch (Exception e) {
      return null;
    }
  }
}
