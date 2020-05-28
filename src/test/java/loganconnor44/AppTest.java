package loganconnor44;

import static org.junit.Assert.assertTrue;

import loganconnor44.katas.Dictionary;
import loganconnor44.katas.Isogram;
import loganconnor44.katas.Recurrence;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testDictionarySimilaritySearchSetOne() {
        Dictionary kata = new Dictionary(
            new String[] {"liar", "lizard", "lion", "litigation", "liter"}
        );
        String actual = kata.findMostSimilar("litre");
        String expected = "liter";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDictionarySimilaritySearchSetTwo() {
        Dictionary kata = new Dictionary(
            new String[] {"cherry", "pineapple", "melon", "strawberry", "raspberry"}
        );
        String actual = kata.findMostSimilar("trawberry");
        String expected = "strawberry";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDictionarySimilaritySearchSetThree() {
        Dictionary kata = new Dictionary(
            new String[] {"stars", "mars", "wars", "codec", "codewars"}
        );
        String actual = kata.findMostSimilar("coddwars");
        String expected = "codewars";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDictionarySimilaritySearchSetFour() {
        Dictionary kata = new Dictionary(
            new String[] {"java", "python"}
        );
        String actual = kata.findMostSimilar("heaven");
        String expected = "java";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRecurrenceDelete1stOccurrence() {
        Recurrence recurrence = new Recurrence(
            new int[] {20, 37, 20, 21}
        );
        List<Integer> actual = recurrence.deleteNth(1);
        List<Integer> expected = Arrays.asList(20, 37, 21);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRecurrenceDelete3rdOccurrence() {
        Recurrence recurrence = new Recurrence(
            new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }
        );
        List<Integer> actual = recurrence.deleteNth(3);
        List<Integer> expected = Arrays.asList(1, 1, 3, 3, 7, 2, 2, 2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRecurrenceDelete3rdOccurrencePart2() {
        Recurrence recurrence = new Recurrence(
            new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }
        );
        List<Integer> actual = recurrence.deleteNth(3);
        List<Integer> expected = Arrays.asList(1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRecurrenceDelete5thOccurrence() {
        Recurrence recurrence = new Recurrence(
            new int[] { 1, 1, 1, 1, 1 }
        );
        List<Integer> actual = recurrence.deleteNth(5);
        List<Integer> expected = Arrays.asList( 1, 1, 1, 1, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsograms() {
        Isogram isogram = new Isogram();
        Assert.assertEquals(false, isogram.isIsogram("aa"));
        Assert.assertEquals(true, isogram.isIsogram("isogram"));
        Assert.assertEquals(true, isogram.isIsogram("Dermatoglyphics"));
        Assert.assertEquals(false, isogram.isIsogram("moose"));
        Assert.assertEquals(false, isogram.isIsogram("isIsogram"));
        Assert.assertEquals(false, isogram.isIsogram("aba"));
        Assert.assertEquals(false, isogram.isIsogram("moOse"));
        Assert.assertEquals(true, isogram.isIsogram("thumbscrewjapingly"));
        Assert.assertEquals(true, isogram.isIsogram(""));
    }

}
