package com.github.arknote02.authentication.domain.model;

import lombok.NonNull;
import org.apache.commons.codec.digest.DigestUtils;

public record Password(@NonNull String value) {

  public HashedPassword hash() {
    // TODO Customize hashing algorithm. (hash with a salt and repeat hashing)
    return new HashedPassword(DigestUtils.sha512Hex("static-salt_" + value));
  }

  @Override
  public String toString() {
    // Should not include plain-text password
    return "Password{" +
        "hashCode='" + Integer.toHexString(hashCode()) + '\'' +
        '}';
  }
}
