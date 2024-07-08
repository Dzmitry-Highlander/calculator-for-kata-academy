package service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ENotation {
    ARABIC ("Arabic"),
    ROMAN ("Roman");

    private final String notation;
}