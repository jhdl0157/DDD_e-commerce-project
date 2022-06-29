package com.example.order.common.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TokenGeneratorTest {

    @Test
    void randomCharacter() {
        String str=TokenGenerator.randomCharacter(10);
        System.out.println(str);
        assertThat(str).hasSize(10);
    }

    @Test
    @DisplayName("랜덤 StringToken 생성")
    void randomCharacterWithPrefix() {
        String str=TokenGenerator.randomCharacterWithPrefix("test");
        assertThat(str).hasSize(20);

    }
}