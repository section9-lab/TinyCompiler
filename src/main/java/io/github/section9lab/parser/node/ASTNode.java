package io.github.section9lab.parser.node;

import java.util.List;
import java.util.Objects;

public class ASTNode {
    public String type;
    public List<ASTNode> _context;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ASTNode astNode = (ASTNode) o;
        return Objects.equals(type, astNode.type) && Objects.equals(_context, astNode._context);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, _context);
    }
}
