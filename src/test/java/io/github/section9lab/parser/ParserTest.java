package io.github.section9lab.parser;

import io.github.section9lab.Constants;
import io.github.section9lab.lexer.Tokenizer;
import io.github.section9lab.parser.Parser;
import io.github.section9lab.parser.node.ASTCallNode;
import io.github.section9lab.parser.node.ASTNode;
import io.github.section9lab.parser.node.ASTNumberNode;
import io.github.section9lab.parser.node.ASTProgramNode;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {

    ArrayList<ImmutablePair<String, String>> tokens;

    @BeforeEach
    void init(){
        String code = "(add 2 (subtract 4 2))";
        tokens = Tokenizer.tokenizer(code);
    }

    @Test
    void parser() throws Exception {
//ASTProgramNode{
//    type='Program',
//    body=[
//        ASTCallNode{
//            name='add',
//            type='CallExpression',
//            params=[
//                ASTNumberNode{
//                    type='NumberLiteral',
//                    value='2'
//                },
//                ASTCallNode{
//                    name='subtract',
//                    type='CallExpression',
//                    params=[
//                        ASTNumberNode{
//                            type='NumberLiteral',
//                            value='4'
//                        },
//                        ASTNumberNode{
//                            type='NumberLiteral',
//                            value='2'
//                        }
//                    ]
//                }
//            ]
//        }
//    ]
//}
        ASTProgramNode programNode = new ASTProgramNode();
        programNode.type = Constants.Program;

        ASTCallNode callNode1 = new ASTCallNode();
        callNode1.name = "add";
        callNode1.type = Constants.CallExpression;

        ASTNumberNode numberNode1 = new ASTNumberNode();
        numberNode1.type = Constants.NumberLiteral;
        numberNode1.value = "2";

        ASTCallNode callNode2 = new ASTCallNode();
        callNode2.name = "subtract";
        callNode2.type = Constants.CallExpression;

        ASTNumberNode numberNode2 = new ASTNumberNode();
        numberNode2.type = Constants.NumberLiteral;
        numberNode2.value = "4";
        ASTNumberNode numberNode3 = new ASTNumberNode();
        numberNode3.type = Constants.NumberLiteral;
        numberNode3.value = "2";

        callNode2.params = Arrays.asList(numberNode2,numberNode3);
        callNode1.params = Arrays.asList(numberNode1,callNode2);
        programNode.body = Collections.singletonList(callNode1);
        System.out.println(programNode);

        ASTNode node = new Parser().parser(tokens);
        System.out.println(node);

        assertEquals(node, programNode);
    }
}