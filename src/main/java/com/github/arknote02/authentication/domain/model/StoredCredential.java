package com.github.arknote02.authentication.domain.model;

public record StoredCredential(LoginId loginId, HashedPassword hashedPassword) {

}
