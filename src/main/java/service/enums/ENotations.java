package service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ENotations {
    ARABIC ("Arabic"),
    ROMAN ("Roman");

    private final String notation;
}