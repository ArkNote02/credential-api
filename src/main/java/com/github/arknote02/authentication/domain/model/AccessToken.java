package com.github.arknote02.authentication.domain.model;

import lombok.NonNull;

public record AccessToken(@NonNull String token, @NonNull String secretToken) {

}
