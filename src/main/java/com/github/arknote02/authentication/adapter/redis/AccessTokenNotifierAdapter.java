package com.github.arknote02.authentication.adapter.redis;

import com.github.arknote02.authentication.domain.model.AccessToken;
import com.github.arknote02.authentication.domain.model.LoginId;
import com.github.arknote02.authentication.domain.port.AccessTokenNotifier;
import org.springframework.stereotype.Component;

@Component
public class AccessTokenNotifierAdapter implements AccessTokenNotifier {

  @Override
  public void notice(LoginId loginId, AccessToken accessToken) {
    // TODO store access token or notify another domain of access token
    // NOTE: If the access token is in another domain, changes must be made to the domain package.
  }
}
