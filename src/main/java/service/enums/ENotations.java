package service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ENotations {
    ARABIC ("Arabic"),
    ROMAN ("Roman"),
    ERROR ("Error");

    private final String notation;
}