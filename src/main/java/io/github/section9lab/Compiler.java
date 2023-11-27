package io.github.section9lab;

import io.github.section9lab.gencode.GeneratorCode;
import io.github.section9lab.lexer.Tokenizer;
import io.github.section9lab.parser.Parser;
import io.github.section9lab.parser.node.ASTNode;
import io.github.section9lab.parser.node.ASTProgramNode;
import io.github.section9lab.transformer.Transformer;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.ArrayList;

public class Compiler {

    private static Parser parser = new Parser();
    private static Transformer transformer = new Transformer();
    private static GeneratorCode codeGeneratorCode = new GeneratorCode();

    public static String run(String code) throws Exception {
        ArrayList<ImmutablePair<String, String>> tokenizer = Tokenizer.tokenizer(code);
        ASTNode node = parser.parser(tokenizer);
        ASTProgramNode newNode = (ASTProgramNode) transformer.transform(node);
        return codeGeneratorCode.codeGen(newNode);
    }

    public static void main(String[] args) throws Exception {
        String inputCode = "(add 2 (subtract 4 2))";
        String code = run(inputCode);
        System.out.println(code);
    }
}
