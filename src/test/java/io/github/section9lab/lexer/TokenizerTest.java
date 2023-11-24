package io.github.section9lab.lexer;

import io.github.section9lab.lexer.Tokenizer;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static io.github.section9lab.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TokenizerTest {

    @Test
    void tokenizer() {
        String code = "(add 2 (subtract 4 2))";
        ArrayList<ImmutablePair<String, String>> tokens = new ArrayList<>();
        tokens.add(new ImmutablePair<>(PAREN , "("));
        tokens.add(new ImmutablePair<>(NAME , "add"));
        tokens.add(new ImmutablePair<>(NUMBER , "2"));
        tokens.add(new ImmutablePair<>(PAREN , "("));
        tokens.add(new ImmutablePair<>(NAME , "subtract"));
        tokens.add(new ImmutablePair<>(NUMBER , "4"));
        tokens.add(new ImmutablePair<>(NUMBER , "2"));
        tokens.add(new ImmutablePair<>(PAREN , ")"));
        tokens.add(new ImmutablePair<>(PAREN , ")"));

        assertEquals(Tokenizer.tokenizer(code), tokens);
    }
}