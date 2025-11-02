package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import lotto.ErrorMessage;
import lotto.util.LottoGenerator;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
        if (new HashSet<>(numbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBERS.getValue());
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public static Lotto generateLotto() {
        TreeSet<Integer> sortedLotto = new TreeSet<>(LottoGenerator.generateLotto());
        return new Lotto(new ArrayList<>(sortedLotto));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
