enum ENotations {
    ARABIC ("Arabic"),
    ROMAN ("Roman"),
    ERROR ("Error");

    private final String notation;

    ENotations(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }
}