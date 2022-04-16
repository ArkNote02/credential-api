package com.github.arknote02.credential.adapter.controller.model;

import com.github.arknote02.credential.domain.model.Credential;
import com.github.arknote02.credential.domain.model.LoginId;
import com.github.arknote02.credential.domain.model.Password;

public record LoginJson(String loginId, String password) {

  public Credential toCredential() {
    return new Credential(new LoginId(loginId), new Password(password));
  }
}
