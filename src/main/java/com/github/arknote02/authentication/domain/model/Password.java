package com.github.arknote02.authentication.domain.model;

public record Password(String value) {

  public HashedPassword hash() {
    // TODO
    return new HashedPassword("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
  }
}
