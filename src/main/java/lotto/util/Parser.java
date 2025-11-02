package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.error.ErrorMessage;

public class Parser {

    private static final String LOTTO_PARSER = ",";

    public List<Integer> parseToLotto(String input) {
        return Arrays.stream(input.split(LOTTO_PARSER))
            .map(String::trim)
            .filter(number -> !number.isBlank())
            .map(this::parseToInt)
            .toList();
    }

    private Integer parseToInt(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_FORMAT.getValue());
        }
    }
}
