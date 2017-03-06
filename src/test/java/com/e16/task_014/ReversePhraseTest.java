package com.e16.task_014;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ReversePhraseTest {
    @Test
    public void whenManyWords() throws Exception {
        ReversePhrase phrase = new ReversePhrase("code or sleep and learn");

        assertThat(phrase.reverse(), is("learn and sleep or code"));
    }

    @Test
    public void whenOneWord() throws Exception {
        ReversePhrase phrase = new ReversePhrase("Java");

        assertThat(phrase.reverse(), is("Java"));
    }

    @Test
    public void whenStringIsEmpty() throws Exception {
        ReversePhrase phrase = new ReversePhrase("");

        assertThat(phrase.reverse(), is(""));
    }
}