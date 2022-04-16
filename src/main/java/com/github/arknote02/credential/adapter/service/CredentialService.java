package com.github.arknote02.credential.adapter.service;

import com.github.arknote02.credential.domain.model.AccessToken;
import com.github.arknote02.credential.domain.port.CredentialServiceProxy;
import com.github.arknote02.credential.domain.model.Credential;
import com.github.arknote02.credential.domain.model.HashedPassword;
import com.github.arknote02.credential.domain.model.LoginId;
import com.github.arknote02.credential.domain.model.StoredCredential;
import com.github.arknote02.credential.domain.port.AccessTokenRepository;
import com.github.arknote02.credential.domain.port.CredentialRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CredentialService implements CredentialServiceProxy {

  private final CredentialRepository credentialRepository;
  private final AccessTokenRepository tokenRepository;

  @Override
  public AccessToken authenticate(Credential credential) {
    try {
      // Is this credential stored?
      LoginId loginId = credential.loginId();
      StoredCredential storedCredential = credentialRepository.find(loginId);
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
      tokenRepository.store(loginId, accessToken);
      return accessToken;
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public LoginId authenticate(AccessToken accessToken) {
    try {
      return tokenRepository.find(accessToken);
    } catch (Exception e) {
      return null;
    }
  }
}
