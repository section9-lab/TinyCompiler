package io.github.section9lab;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompilerTest {

    @Test
    void run() throws Exception {
        assertEquals(Compiler.run("(add 2 (subtract 4 2))"), "add(2,subtract(4,2));");
    }
}