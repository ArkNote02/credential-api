package com.github.arknote02.authentication.domain.event;

import com.github.arknote02.authentication.domain.model.AccessToken;
import com.github.arknote02.authentication.domain.model.Credential;

public interface Authenticate {

  AccessToken authenticate(Credential credential);
}
