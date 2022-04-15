package com.github.arknote02.authentication.domain.port;

import com.github.arknote02.authentication.domain.model.AccessToken;
import com.github.arknote02.authentication.domain.model.LoginId;

public interface AccessTokenNotifier {

  void notice(LoginId loginId, AccessToken accessToken);
}
