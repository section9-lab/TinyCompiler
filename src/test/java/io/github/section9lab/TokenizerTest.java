package io.github.section9lab;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TokenizerTest {

    @Test
    void tokenizer() {
        String code = "(add 2 (subtract 4 2))";
        ArrayList<ImmutablePair<String,String >> tokens = new ArrayList<>();
        tokens.add(new ImmutablePair<>("paren", "("));
        tokens.add(new ImmutablePair<>("name", "add"));
        tokens.add(new ImmutablePair<>("number", "2"));
        tokens.add(new ImmutablePair<>("paren", "("));
        tokens.add(new ImmutablePair<>("name", "subtract"));
        tokens.add(new ImmutablePair<>("number", "4"));
        tokens.add(new ImmutablePair<>("number", "2"));
        tokens.add(new ImmutablePair<>("paren", ")"));
        tokens.add(new ImmutablePair<>("paren", ")"));

        assertEquals(Tokenizer.tokenizer(code), tokens);
    }
}