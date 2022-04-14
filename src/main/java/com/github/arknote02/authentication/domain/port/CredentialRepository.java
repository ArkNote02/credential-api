package com.github.arknote02.authentication.domain.port;

import com.github.arknote02.authentication.domain.model.LoginId;
import com.github.arknote02.authentication.domain.model.StoredCredential;

public interface CredentialRepository {

  StoredCredential find(LoginId loginId);
}
