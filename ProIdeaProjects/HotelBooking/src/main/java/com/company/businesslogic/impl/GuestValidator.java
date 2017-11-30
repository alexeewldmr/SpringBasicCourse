package com.company.businesslogic.impl;


import com.company.businesslogic.ValidationError;
import com.mysql.jdbc.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;
public interface GuestValidator {
    Optional<ValidationError> validate(String guestName, String guestDescription);
}

@Component
class GuestValidatorImpl implements GuestValidator {

    @Override
    public Optional<ValidationError> validate(String guestName, String guestDescription) {
        if (StringUtils.isEmptyOrWhitespaceOnly(guestName)){
            return Optional.of(new ValidationError("name", "Must be not empty!"));
        }
        if (StringUtils.isEmptyOrWhitespaceOnly(guestDescription)){
            return Optional.of(new ValidationError("description", "Must be not empty!"));
        }
        return Optional.empty();
    }
}
