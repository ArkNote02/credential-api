package com.github.arknote02.authentication.adapter.dynamodb;

import com.github.arknote02.authentication.domain.model.HashedPassword;
import com.github.arknote02.authentication.domain.model.LoginId;
import com.github.arknote02.authentication.domain.model.StoredCredential;
import com.github.arknote02.authentication.domain.port.CredentialRepository;
import org.springframework.stereotype.Component;

@Component
public class CredentialRepositoryAdapter implements CredentialRepository {

  @Override
  public StoredCredential find(LoginId loginId) {
    // TODO
    return new StoredCredential(loginId, new HashedPassword("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8"));
  }
}
