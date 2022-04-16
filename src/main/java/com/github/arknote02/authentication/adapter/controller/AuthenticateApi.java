package com.github.arknote02.authentication.adapter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.arknote02.authentication.adapter.controller.model.LoginJson;
import com.github.arknote02.authentication.domain.model.AccessToken;
import com.github.arknote02.authentication.domain.model.Credential;
import com.github.arknote02.authentication.domain.port.AuthenticateServiceProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthenticateApi {

  private static final ObjectMapper mapper = new ObjectMapper();
  private final AuthenticateServiceProxy proxy;

  @PostMapping("/auth")
  public String auth(@RequestBody LoginJson json) throws JsonProcessingException {
    Credential credential = json.toCredential();
    AccessToken accessToken = proxy.authenticate(credential);
    if (accessToken == null) {
      throw new RuntimeException("Request is invalid.");
    }
    return mapper.writeValueAsString(accessToken);
  }
}
