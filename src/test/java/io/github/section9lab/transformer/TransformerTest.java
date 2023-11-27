package io.github.section9lab.transformer;

import io.github.section9lab.lexer.Tokenizer;
import io.github.section9lab.parser.Parser;
import io.github.section9lab.parser.node.ASTNode;
import io.github.section9lab.parser.node.ASTProgramNode;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class TransformerTest {

    private static Transformer transformer = new Transformer();
    ASTNode node = null;

    @BeforeEach
    void init() throws Exception {
        String code = "(add 2 (subtract 4 2))";
        ArrayList<ImmutablePair<String, String>> tokenizer = Tokenizer.tokenizer(code);
        node = new Parser().parser(tokenizer);
    }

    @Test
    void visitor() throws Exception {
        System.out.println("input:" + node);
        ASTProgramNode newASTRoot = (ASTProgramNode) transformer.transform(node);
        System.out.println("output:" + newASTRoot);
    }

}