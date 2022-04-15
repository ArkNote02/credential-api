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
    return new StoredCredential(loginId, new HashedPassword("9b39f66e9fc6ad713334171c9e9f2363924a9d8dc57d3f39de39170d710b175f87b03b075f4d25fc1b12dc224c7eb4c64fed594c47ca3005ec75d9c970f9c6a7"));
  }
}
