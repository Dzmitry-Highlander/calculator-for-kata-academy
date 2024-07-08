import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
enum ENotations {
    ARABIC ("Arabic"),
    ROMAN ("Roman"),
    ERROR ("Error");

    private final String notation;
}