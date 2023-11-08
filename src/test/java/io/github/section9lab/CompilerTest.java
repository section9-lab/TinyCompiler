package io.github.section9lab;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompilerTest {

    @Test
    void run() {
        assertEquals(Compiler.run(2, 4), 6);
    }
}