package com.github.arknote02.credential.adapter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.arknote02.credential.adapter.controller.model.LoginJson;
import com.github.arknote02.credential.adapter.controller.model.TokenJson;
import com.github.arknote02.credential.domain.model.AccessToken;
import com.github.arknote02.credential.domain.model.Credential;
import com.github.arknote02.credential.domain.model.LoginId;
import com.github.arknote02.credential.domain.port.CredentialServiceProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CredentialController {

  private static final ObjectMapper mapper = new ObjectMapper();
  private final CredentialServiceProxy proxy;

  @PostMapping("/auth")
  public String auth(@RequestBody LoginJson json) throws JsonProcessingException {
    Credential credential = json.toCredential();
    AccessToken accessToken = proxy.authenticate(credential);
    if (accessToken == null) {
      throw new RuntimeException("Request is invalid.");
    }
    return mapper.writeValueAsString(accessToken);
  }

  @PostMapping("/valid")
  public String valid(@RequestBody TokenJson json) throws JsonProcessingException {
    AccessToken accessToken = json.toAccessToken();
    LoginId loginId = proxy.authenticate(accessToken);
    if (loginId == null) {
      throw new RuntimeException("Token is invalid.");
    }
    return mapper.writeValueAsString(loginId);
  }
}
