import main.java.WordCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class WordCounterTest {

    @Test
    public void testMultipleWordsWithNumbers() {
        String input = "word1 word2 word3 12345";
        assertEquals(3, WordCounter.countWords(input));
    }

    @Test
    public void testWithMixedCharacters() {
        String input = "hello, world! test.";
        assertEquals(3, WordCounter.countWords(input));
    }

    @Test
    public void testNullInput() {
        String input = null;
        assertEquals(0, WordCounter.countWords(input));
    }

    @Test
    public void testEmptyInput() {
        String input = "";
        assertEquals(0, WordCounter.countWords(input));
    }

    @Test
    public void testShortWords() {
        String input = "hi he lo";
        assertEquals(0, WordCounter.countWords(input));
    }
}
