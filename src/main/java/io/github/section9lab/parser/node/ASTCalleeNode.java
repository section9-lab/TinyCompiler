package io.github.section9lab.parser.node;

public class ASTCalleeNode extends ASTNode {

    public String name;

    @Override
    public String toString() {
        return "ASTCalleeNode{" +
                "name='" + name + '\'' +
                '}';
    }
}
