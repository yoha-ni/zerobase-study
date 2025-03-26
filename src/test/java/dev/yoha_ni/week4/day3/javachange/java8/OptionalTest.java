package dev.yoha_ni.week4.day3.javachange.java8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class OptionalTest {
    @Test
    void create() {
        // given
        Optional<String> optional = Optional.ofNullable("hello");
        assertThat(optional.isPresent()).isTrue();
        System.out.println(optional.isPresent());
        System.out.println(optional.get());

        Optional<String> oprional2 = Optional.of("hello2");
        assertThat(oprional2.isPresent()).isTrue();
        System.out.println(oprional2.isPresent());
        System.out.println(oprional2.get());

        Optional<String> oprional3 = Optional.ofNullable(null);
        assertThat(oprional3.isPresent()).isFalse();
        System.out.println(oprional3.isPresent());
//        System.out.println(oprional3.get());

        Optional<String> oprional4 = Optional.empty();
        assertThat(oprional4.isPresent()).isFalse();
        System.out.println(oprional4.isPresent());
    }

    @Test
    void orElse(){
        Optional<String> optional = Optional.ofNullable("hello");
        assertThat(optional.orElse("default")).isEqualTo("hello");
        System.out.println(optional.orElse("default"));

        Optional<String> optional2 = Optional.ofNullable(null);
        assertThat(optional2.orElse("default")).isEqualTo("default");
        System.out.println(optional2.orElse("default"));
    }

    @Test
    void orElseThrow(){
        Optional<String> optional = Optional.ofNullable("hello");
        assertThat(optional.orElseThrow()).isEqualTo("hello");
        System.out.println(optional.orElseThrow());

        Optional<String> optional2 = Optional.empty();
        assertThatThrownBy(() -> optional2.orElseThrow(IllegalStateException::new))
                .isInstanceOf(Exception.class);
//        System.out.println(optional2.orElseThrow());
    }

    @Test
    void map(){
        Optional<String> optional = Optional.ofNullable("hello");
        assertThat(optional.map(String::toUpperCase).orElse("default")).isEqualTo("HELLO");
        System.out.println(optional.map(String::toUpperCase).orElse("default"));

        Optional<String> optional2 = Optional.ofNullable(null);
        assertThat(optional2.map(String::toUpperCase).orElse("default")).isEqualTo("default");
        System.out.println(optional2.map(String::toUpperCase).orElse("default"));
    }

    @Test
    void ifPresent() {
        Optional<String> optional = Optional.ofNullable("hello");
        optional.ifPresent(s -> System.out.println(s.toUpperCase()));

        Optional<String> optional2 = Optional.ofNullable(null);
        optional2.ifPresent(s -> System.out.println(s.toUpperCase()));
    }
}
