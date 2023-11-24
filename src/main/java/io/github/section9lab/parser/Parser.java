package io.github.section9lab.parser;


import io.github.section9lab.lexer.Tokenizer;
import io.github.section9lab.parser.node.ASTCallNode;
import io.github.section9lab.parser.node.ASTNode;
import io.github.section9lab.parser.node.ASTNumberNode;
import io.github.section9lab.parser.node.ASTProgramNode;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.ArrayList;
import java.util.List;

import static io.github.section9lab.Constants.*;

public class Parser {
    private int index = 0;
    private List<ImmutablePair<String, String>> tokens = null;

    public ASTNode parser(List<ImmutablePair<String, String>> tokens) throws Exception {
        index = 0;
        this.tokens = tokens;
        ASTProgramNode astProgramNode = new ASTProgramNode();
        astProgramNode.type = Program;

        List<ASTNode> bodyNodeArray = new ArrayList<>();

        for (; index < tokens.size(); index++) {
            bodyNodeArray.add(walk());
        }

        astProgramNode.body = bodyNodeArray;
        return astProgramNode;
    }

    private ASTNode walk() throws Exception {
        ImmutablePair<String, String> token = tokens.get(index);
        if (NUMBER.equals(token.left)) {
            index++;
            ASTNumberNode astNumberNode = new ASTNumberNode();
            astNumberNode.type = NumberLiteral;
            astNumberNode.value = token.getValue();
            return astNumberNode;
        }

        if (PAREN.equals(token.left) && "(".equals(token.right)) {
            token = tokens.get(++index);
            ASTCallNode astCallNode = new ASTCallNode();
            astCallNode.type = CallExpression;
            astCallNode.name = token.getValue();
            token = tokens.get(++index);
            List<ASTNode> paramArray = new ArrayList<>();
            while (!PAREN.equals(token.left) || ((PAREN.equals(token.left) && !")".equals(token.right)))) {
                paramArray.add(walk());
                token = tokens.get(index);
            }
            astCallNode.params = paramArray;
            index++;//跳过右圆括号
            return astCallNode;
        }
        throw new Exception("类型未知");
    }


    public static void main(String[] args) throws Exception {
        String code = "(add 2 (subtract 4 2))";
        ArrayList<ImmutablePair<String, String>> tokens = Tokenizer.tokenizer(code);

        ASTNode node = new Parser().parser(tokens);
        System.out.println(node);
    }
}
