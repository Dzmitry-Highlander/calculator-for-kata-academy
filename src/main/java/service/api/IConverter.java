package service.api;

public interface IConverter {
    String[] convertInput(String[] input);

    String convertOutput(int output, String notation);
}
