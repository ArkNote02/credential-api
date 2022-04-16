package com.github.arknote02.authentication.adapter.controller.model;

import com.github.arknote02.authentication.domain.model.Credential;
import com.github.arknote02.authentication.domain.model.LoginId;
import com.github.arknote02.authentication.domain.model.Password;

public record LoginJson(String loginId, String password) {

  public Credential toCredential() {
    return new Credential(new LoginId(loginId), new Password(password));
  }
}
