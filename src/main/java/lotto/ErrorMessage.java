package lotto;

public enum ErrorMessage {
    EMPTY_INPUT("[ERROR] 입력이 비어 있습니다."),
    INVALID_INPUT_NUMBER_FORMAT("[ERROR] 입력 값은 숫자로 이루어져 있습니다."),
    INVALID_MONEY_UNIT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),

    INVALID_LOTTO_NUMBER_FORMAT("[ERROR] 로또 번호는 1에서 45사이 정수만 입력될 수 있습니다."),
    VALIDATE_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBERS("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자입니다."),

    DUPLICATE_BONUS_LOTTO_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
