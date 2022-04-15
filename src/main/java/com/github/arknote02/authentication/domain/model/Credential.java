package com.github.arknote02.authentication.domain.model;

import lombok.NonNull;

public record Credential(@NonNull LoginId loginId, @NonNull Password password) {

}
