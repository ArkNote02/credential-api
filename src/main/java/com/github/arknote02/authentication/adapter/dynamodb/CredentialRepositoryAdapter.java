package com.github.arknote02.authentication.adapter.dynamodb;

import com.github.arknote02.authentication.domain.model.HashedPassword;
import com.github.arknote02.authentication.domain.model.LoginId;
import com.github.arknote02.authentication.domain.model.StoredCredential;
import com.github.arknote02.authentication.domain.port.CredentialRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CredentialRepositoryAdapter implements CredentialRepository {

  @Value("${key}")
  private String value;

  @Override
  public StoredCredential find(LoginId loginId) {
    // TODO
    return new StoredCredential(loginId, new HashedPassword(value));
  }
}
