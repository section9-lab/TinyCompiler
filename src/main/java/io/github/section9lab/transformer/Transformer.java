package io.github.section9lab.transformer;

import io.github.section9lab.parser.node.ASTCallNode;
import io.github.section9lab.parser.node.ASTNode;
import io.github.section9lab.parser.node.ASTProgramNode;

import java.util.ArrayList;
import java.util.List;

import static io.github.section9lab.Constants.*;

public class Transformer {

    private Visitor visitor = null;

    public ASTNode transform(ASTNode astNode) throws Exception {
        ASTProgramNode newAST = new ASTProgramNode();
        newAST.type = Program;
        newAST.body = new ArrayList<>();
        astNode._context = newAST.body;
        visitor = new Visitor();
        traverse(astNode);
        return newAST;
    }

    private void traverse(ASTNode astNode) throws Exception {
        traverseNode(astNode, null);
    }

    private void traverseNode(ASTNode node, ASTNode parent) throws Exception {
        if (visitor != null) {
            visitor.visitor(node, parent);
        }
        if (Program.equals(node.type)) {
            ASTProgramNode astProgramNode = (ASTProgramNode) node;
            traverseArray(astProgramNode.body, node);
        } else if (CallExpression.equals(node.type)) {
            ASTCallNode astCallNode = (ASTCallNode) node;
            traverseArray(astCallNode.params, node);
        } else if (NumberLiteral.equals(node.type)) {
            return;
        } else {
            throw new Exception("类型错误.");
        }
    }

    private void traverseArray(List<ASTNode> array, ASTNode parent) throws Exception {
        for (ASTNode astNode : array) {
            traverseNode(astNode, parent);
        }
    }
}
