package io.github.section9lab.parser.node;

import java.util.List;
import java.util.Objects;

public class ASTProgramNode extends ASTNode{
    public List<ASTNode> body;

    @Override
    public String toString() {
        return "ASTProgramNode{" +
                "type='" + type + '\'' +
                ", body=" + body +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ASTProgramNode that = (ASTProgramNode) o;
        return Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }
}
