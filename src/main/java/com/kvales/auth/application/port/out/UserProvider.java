package com.kvales.auth.application.port.out;

public interface UserProvider {

    UserData findByEmail(String email);

    record UserData(
            Long id,
            String email,
            String passwordHash
    ) {}

}