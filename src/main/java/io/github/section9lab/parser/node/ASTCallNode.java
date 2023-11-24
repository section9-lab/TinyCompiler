package io.github.section9lab.parser.node;

import java.util.List;
import java.util.Objects;

public class ASTCallNode extends ASTNode{
    public String name;
    public List<ASTNode> params;

    @Override
    public String toString() {
        return "ASTCallNode{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", params=" + params +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ASTCallNode that = (ASTCallNode) o;
        return Objects.equals(name, that.name) && Objects.equals(params, that.params);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, params);
    }
}
