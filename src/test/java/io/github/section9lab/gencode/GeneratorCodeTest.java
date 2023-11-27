package io.github.section9lab.gencode;

import io.github.section9lab.lexer.Tokenizer;
import io.github.section9lab.parser.Parser;
import io.github.section9lab.parser.node.ASTNode;
import io.github.section9lab.parser.node.ASTProgramNode;
import io.github.section9lab.transformer.Transformer;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneratorCodeTest {
    private static Transformer transformer = new Transformer();
    private static GeneratorCode codeGeneratorCode = new GeneratorCode();
    ASTProgramNode newASTRoot;
    String inputCode;
    @BeforeEach
    void init() throws Exception {
        inputCode = "(add 2 (subtract 4 2))";
        ArrayList<ImmutablePair<String, String>> tokenizer = Tokenizer.tokenizer(inputCode);
        ASTNode node = new Parser().parser(tokenizer);
        newASTRoot = (ASTProgramNode)transformer.transform(node);
    }

    @Test
    void visitor() throws Exception {
        assertEquals(codeGeneratorCode.codeGen(newASTRoot), "add(2,subtract(4,2));");
    }
}