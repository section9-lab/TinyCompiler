package io.github.section9lab.lexer;

import org.apache.commons.lang3.tuple.ImmutablePair;
import static io.github.section9lab.Constants.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Tokenizer {
    public static void main(String[] args) {
        System.out.println(tokenizer("(add 2 (subtract 4 2))"));
    }

    public static ArrayList<ImmutablePair<String, String>> tokenizer(String code) {
        ArrayList<ImmutablePair<String, String>> tokens = new ArrayList<>();
        int current = 0;
        while (current < code.length()) {
            String token = String.valueOf(code.charAt(current));

            String WHITESPACE = "\\s";
            if (REGEX(WHITESPACE, token)) {
                current++;
                continue;
            }

            if ("(".equals(token)) {
                tokens.add(new ImmutablePair<>(PAREN, token));
                current++;
                continue;
            }

            if (")".equals(token)) {
                tokens.add(new ImmutablePair<>(PAREN, token));
                current++;
                continue;
            }

            String LETTERS = "[a-z]";
            if (REGEX(LETTERS, token)) {
                StringBuilder value = new StringBuilder();
                while (Pattern.matches(LETTERS, token)) {
                    value.append(token);
                    token = String.valueOf(code.charAt(++current));
                }
                tokens.add(new ImmutablePair<>(NAME, value.toString()));
            }

            String NUMBERS = "[0-9]";
            if (REGEX(NUMBERS, token)) {
                StringBuilder value = new StringBuilder();
                while (REGEX(NUMBERS, token)) {
                    value.append(token);
                    token = String.valueOf(code.charAt(++current));
                }
                tokens.add(new ImmutablePair<>(NUMBER, value.toString()));
            }
        }
        return tokens;
    }

    private static boolean REGEX(String pattern, String value) {
        return Pattern.matches(pattern, value);
    }
}
