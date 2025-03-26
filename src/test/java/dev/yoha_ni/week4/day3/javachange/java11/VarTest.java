package dev.yoha_ni.week4.day3.javachange.java11;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;

public class VarTest {

    @Test
    void varTest() {
        // given
        var intVar = 1;
        var longVar = 1L;
        var booleanVar = true;
        var stringVar = "hello";

        assertThat(intVar).isInstanceOf(Integer.class);
        assertThat(longVar).isInstanceOf(Long.class);
        assertThat(booleanVar).isInstanceOf(Boolean.class);
        assertThat(stringVar).isInstanceOf(String.class);

        var listVar = new ArrayList<String>();
        var mapVar = new HashMap<String, String>();

        assertThat(listVar).isInstanceOf(ArrayList.class);
        assertThat(mapVar).isInstanceOf(HashMap.class);

        var mouse = new Mouse("Logitech", 100);
        assertThat(mouse).isInstanceOf(Mouse.class);
    }

    record Mouse(String name, int price) {

    }
}
