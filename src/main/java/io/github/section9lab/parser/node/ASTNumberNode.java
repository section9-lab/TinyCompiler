package io.github.section9lab.parser.node;

import java.util.Objects;

public class ASTNumberNode extends ASTNode{
    public String value;

    @Override
    public String toString() {
        return "ASTNumberNode{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ASTNumberNode that = (ASTNumberNode) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
