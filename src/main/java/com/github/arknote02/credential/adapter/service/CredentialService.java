package com.github.arknote02.credential.adapter.service;

import com.github.arknote02.credential.domain.model.AccessToken;
import com.github.arknote02.credential.domain.port.CredentialServiceProxy;
import com.github.arknote02.credential.domain.model.Credential;
import com.github.arknote02.credential.domain.model.HashedPassword;
import com.github.arknote02.credential.domain.model.LoginId;
import com.github.arknote02.credential.domain.model.StoredCredential;
import com.github.arknote02.credential.domain.port.AccessTokenNotifier;
import com.github.arknote02.credential.domain.port.CredentialRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CredentialService implements CredentialServiceProxy {

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
