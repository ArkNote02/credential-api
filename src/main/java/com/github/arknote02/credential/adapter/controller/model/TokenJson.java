package com.github.arknote02.credential.adapter.controller.model;

import com.github.arknote02.credential.domain.model.AccessToken;

public record TokenJson(String accessToken, String secretToken) {

  public AccessToken toAccessToken() {
    return new AccessToken(accessToken, secretToken);
  }
}
