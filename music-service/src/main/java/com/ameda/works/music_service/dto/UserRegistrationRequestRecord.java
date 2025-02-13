package com.ameda.works.music_service.dto;

import java.time.LocalDate;

public record UserRegistrationRequestRecord(
        Boolean artist,
        String id,
        String name,
        LocalDate dob,
        String gender,
        String language,
        String countryIso2
) {
}
