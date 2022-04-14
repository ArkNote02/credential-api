package com.github.arknote02.authentication.domain.service;

import com.github.arknote02.authentication.domain.event.Authenticate;
import com.github.arknote02.authentication.domain.model.AccessToken;
import com.github.arknote02.authentication.domain.model.Credential;
import com.github.arknote02.authentication.domain.model.StoredCredential;
import com.github.arknote02.authentication.domain.port.CredentialRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthenticateService implements Authenticate {

  private final CredentialRepository repository;

  @Override
  public AccessToken authenticate(Credential credential) {
    try {
      StoredCredential storedCredential = repository.find(credential.loginId());
      boolean isValid = Objects.equals(credential.password().hash(), storedCredential.hashedPassword());
      if (!isValid) {
        return null;
      }
      // TODO generate and store
      return new AccessToken("tooooooooooken", "seeeeeeeeeecret");
    } catch (Exception e) {
      System.err.println(e.getMessage());
      return null;
    }
  }
}
