package com.github.arknote02.credential.adapter.redis;

import com.github.arknote02.credential.domain.model.AccessToken;
import com.github.arknote02.credential.domain.model.LoginId;
import com.github.arknote02.credential.domain.port.AccessTokenNotifier;
import org.springframework.stereotype.Component;

@Component
public class AccessTokenNotifierAdapter implements AccessTokenNotifier {

  @Override
  public void notice(LoginId loginId, AccessToken accessToken) {
    // TODO store access token or notify another domain of access token
    // NOTE: If the access token is in another domain, changes must be made to the domain package.
  }
}
