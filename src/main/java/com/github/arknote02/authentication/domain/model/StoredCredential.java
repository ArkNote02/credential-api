package com.github.arknote02.authentication.domain.model;

import lombok.NonNull;

public record StoredCredential(@NonNull LoginId loginId, @NonNull HashedPassword hashedPassword) {

}
