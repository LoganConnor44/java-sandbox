package loganconnor44;

import org.junit.Assert;
import org.junit.Test;

import loganconnor44.katas.*;



public class SlidingWindowTests {
    //epsilon the negative tells the digits to go to the left 
    //so 0.0008 would be the tolerance
    public static final double TOLERANCE = 1e-4;

    @Test
	public void testBruteForce() {
        SlidingWindow slidingWindow = new SlidingWindow();
        double[] actual = slidingWindow.bruteForce(
            new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2},
            5
        );
        double[] expected = new double[] {2.2, 2.8, 2.4, 3.6, 2.8};
        Assert.assertArrayEquals(expected, actual, TOLERANCE);
	}

    @Test
	public void testOptimized() {
        SlidingWindow slidingWindow = new SlidingWindow();
        double[] actual = slidingWindow.create(
            new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2},
            5
        );
        double[] expected = new double[] {2.2, 2.8, 2.4, 3.6, 2.8};
        Assert.assertArrayEquals(expected, actual, TOLERANCE);
	}

    @Test
	public void testMaxSumOfContiguousSub() {
        SlidingWindow slidingWindow = new SlidingWindow();
        int actual = slidingWindow.maxSumOfContiguousSub(
            new int[] {2, 1, 5, 1, 3, 2},
            3
        );
        int expected = 9;
        Assert.assertEquals(expected, actual);
	}

    @Test
	public void testMaxSumOfContiguousSub2() {
        SlidingWindow slidingWindow = new SlidingWindow();
        int actual = slidingWindow.maxSumOfContiguousSub(
            new int[] {2, 3, 4, 1, 5},
            2
        );
        int expected = 7;
        Assert.assertEquals(expected, actual);
	}

    @Test
	public void testLengthOfSmallestArrayWithSumGreaterThanOrEqualToK() {
        SlidingWindow slidingWindow = new SlidingWindow();
        int actual = slidingWindow.lengthOfSmallestArrayWithSumGreaterThanOrEqualToK(
            new int[] {2, 1, 5, 2, 3, 2},
            7
        );
        int expected = 2;
        Assert.assertEquals(expected, actual);
	}

    @Test
	public void testLengthOfSmallestArrayWithSumGreaterThanOrEqualToK2() {
        SlidingWindow slidingWindow = new SlidingWindow();
        int actual = slidingWindow.lengthOfSmallestArrayWithSumGreaterThanOrEqualToK(
            new int[] {2, 1, 5, 2, 8},
            7
        );
        int expected = 1;
        Assert.assertEquals(expected, actual);
	}

    @Test
	public void testLengthOfSmallestArrayWithSumGreaterThanOrEqualToK3() {
        SlidingWindow slidingWindow = new SlidingWindow();
        int actual = slidingWindow.lengthOfSmallestArrayWithSumGreaterThanOrEqualToK(
            new int[] {2, 1, 5, 2, 8},
            7
        );
        int expected = 1;
        Assert.assertEquals(expected, actual);
	}

    @Test
	public void testLengthOfLongestSubStringWithNoMoreThanXDistinctCharacters() {
        SlidingWindow slidingWindow = new SlidingWindow();
        int actual = slidingWindow.lengthOfLongestSubStringWithNoMoreThanXDistinctCharacters(
            "araaci",
            2
        );
        int expected = 4;
        Assert.assertEquals(expected, actual);
	}

    @Test
	public void testLengthOfLongestSubStringWithNoMoreThanXDistinctCharacters2() {
        SlidingWindow slidingWindow = new SlidingWindow();
        int actual = slidingWindow.lengthOfLongestSubStringWithNoMoreThanXDistinctCharacters(
            "araaci",
            1
        );
        int expected = 2;
        Assert.assertEquals(expected, actual);
	}

    @Test
	public void testLengthOfLongestSubStringWithNoMoreThanXDistinctCharacters3() {
        SlidingWindow slidingWindow = new SlidingWindow();
        int actual = slidingWindow.lengthOfLongestSubStringWithNoMoreThanXDistinctCharacters(
            "cbbebi",
            3
        );
        int expected = 5;
        Assert.assertEquals(expected, actual);
	}

    @Test
	public void testLengthOfLongestSubStringWithNoMoreThanXDistinctCharacters4() {
        SlidingWindow slidingWindow = new SlidingWindow();
        int actual = slidingWindow.lengthOfLongestSubStringWithNoMoreThanXDistinctCharacters(
            "cbbebi",
            10
        );
        int expected = 6;
        Assert.assertEquals(expected, actual);
	}

    @Test
	public void testFruitIntoBaskets() {
        SlidingWindow slidingWindow = new SlidingWindow();
        int actual = slidingWindow.fruitIntoBaskets(
            new char[]{'A', 'B', 'C', 'B', 'B', 'C'}
        );
        int expected = 5;
        Assert.assertEquals(expected, actual);
	}

    @Test
	public void testFruitIntoBaskets2() {
        SlidingWindow slidingWindow = new SlidingWindow();
        int actual = slidingWindow.fruitIntoBaskets(
            new char[]{'A', 'B', 'C', 'A', 'C'}
        );
        int expected = 3;
        Assert.assertEquals(expected, actual);
	}

    @Test
	public void testLongestSubstringWithDistinctCharacters() {
        SlidingWindow slidingWindow = new SlidingWindow();
        int actual = slidingWindow.longestSubstringWithDistinctCharacters("aabccbb");
        int expected = 3;
        Assert.assertEquals(expected, actual);
	}

    @Test
	public void testLongestSubstringWithDistinctCharacters2() {
        SlidingWindow slidingWindow = new SlidingWindow();
        int actual = slidingWindow.longestSubstringWithDistinctCharacters("abbbb");
        int expected = 2;
        Assert.assertEquals(expected, actual);
	}

    @Test
	public void testLongestSubstringWithDistinctCharacters3() {
        SlidingWindow slidingWindow = new SlidingWindow();
        int actual = slidingWindow.longestSubstringWithDistinctCharacters("abccde");
        int expected = 3;
        Assert.assertEquals(expected, actual);
	}
}
