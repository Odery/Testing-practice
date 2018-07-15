package com.vakamisu.testing.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordWrapperTest {

    private static final int LINE_LENGTH = 5;

    @Test
    public void lineShouldWrapIfOverLineLength() {
        String result = WordWrapper.wrap("The Sleepy", LINE_LENGTH);
        assertEquals("The S\nleepy", result);
    }

    @Test
    public void shortLineShouldNotBeWrapped() {
        String result = WordWrapper.wrap("The", LINE_LENGTH);
        assertEquals("The", result);
    }

    @Test
    public void longerLineShouldWrapTwice() {
        String result = WordWrapper.wrap("The Sleepy Brow", LINE_LENGTH);
        assertEquals("The S\nleepy\n Brow", result);
    }

    @Test
    public void evenLongerLineShouldWrapThrice() {
        String result = WordWrapper.wrap("The Sleepy Brown Fox", LINE_LENGTH);
        assertEquals("The S\nleepy\n Brow\nn Fox", result);
    }

    @Test
    public void longLinesCanBeVariousLength() {
        String result = WordWrapper.wrap("The Sleepy Brown Foxes in my yard", LINE_LENGTH);
        assertEquals("The S\nleepy\n Brow\nn Fox\nes in\n my y\nard", result);
    }
}
