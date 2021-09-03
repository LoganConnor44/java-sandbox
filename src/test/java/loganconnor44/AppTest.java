package loganconnor44;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import loganconnor44.katas.*;
import loganconnor44.pojo.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}

	@Test
	public void testDictionarySimilaritySearchSetOne() {
		Dictionary kata = new Dictionary(new String[] { "liar", "lizard", "lion", "litigation", "liter" });
		String actual = kata.findMostSimilar("litre");
		String expected = "liter";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testDictionarySimilaritySearchSetTwo() {
		Dictionary kata = new Dictionary(new String[] { "cherry", "pineapple", "melon", "strawberry", "raspberry" });
		String actual = kata.findMostSimilar("trawberry");
		String expected = "strawberry";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testDictionarySimilaritySearchSetFour() {
		Dictionary kata = new Dictionary(new String[] { "java", "python" });
		String actual = kata.findMostSimilar("heaven");
		String expected = "java";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testRecurrenceDelete1stOccurrence() {
		Recurrence recurrence = new Recurrence(new int[] { 20, 37, 20, 21 });
		List<Integer> actual = recurrence.deleteNth(1);
		List<Integer> expected = Arrays.asList(20, 37, 21);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testRecurrenceDelete3rdOccurrence() {
		Recurrence recurrence = new Recurrence(new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 });
		List<Integer> actual = recurrence.deleteNth(3);
		List<Integer> expected = Arrays.asList(1, 1, 3, 3, 7, 2, 2, 2);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testRecurrenceDelete3rdOccurrencePart2() {
		Recurrence recurrence = new Recurrence(new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 });
		List<Integer> actual = recurrence.deleteNth(3);
		List<Integer> expected = Arrays.asList(1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testRecurrenceDelete5thOccurrence() {
		Recurrence recurrence = new Recurrence(new int[] { 1, 1, 1, 1, 1 });
		List<Integer> actual = recurrence.deleteNth(5);
		List<Integer> expected = Arrays.asList(1, 1, 1, 1, 1);
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

	@Test
	public void testUniqueEmail() {
		UniqueEmail uniqueEmail = new UniqueEmail();
		Assert.assertEquals(4, uniqueEmail.numberOfUniqueEmails(new String[] { "bo.b@gmail.com",
				"sally+mally@gmail.com", "b.ob@yahoo.com", "sally@hotmail.com", "bob@gmail.com" }));
		Assert.assertEquals(3, uniqueEmail
				.numberOfUniqueEmails(new String[] { "a@leetcode.com", "b@leetcode.com", "c@leetcode.com" }));
	}

	@Test
	public void testFruitBaskets() {
		FruitBaskets fruitBaskets = new FruitBaskets();

		Assert.assertEquals(5, fruitBaskets.totalFruit(new int[] { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 }));
		Assert.assertEquals(3, fruitBaskets.totalFruit(new int[] { 1, 2, 1 }));
	}

	@Test
	public void testMaxGain() {
		BuyAndSellStock buyAndSellStock = new BuyAndSellStock();

		Assert.assertEquals(5, buyAndSellStock.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));

		Assert.assertEquals(0, buyAndSellStock.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
	}

	@Test
	public void testPrefix() {
		LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

		Assert.assertEquals("fl", longestCommonPrefix.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
		Assert.assertEquals("", longestCommonPrefix.longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
	}

	@Test
	public void testNodeList() {
		Node shouldBeZero = new Node();
		Assert.assertEquals(0, shouldBeZero.value);

		Node shouldBeOne = new Node(1);
		Assert.assertEquals(1, shouldBeOne.value);

		NodeList initializeWithNoValue = new NodeList();
		Assert.assertEquals(null, initializeWithNoValue.head);

		NodeList initializeWithThreeValue = new NodeList(3);
		Assert.assertEquals(3, initializeWithThreeValue.head.value);

		NodeList addANewNodeToHead = new NodeList(5);
		addANewNodeToHead.addToHead(4);
		Assert.assertEquals(4, addANewNodeToHead.head.value);
		Assert.assertEquals(5, addANewNodeToHead.head.next.value);

		NodeList addANewNodeToTail = new NodeList(5);
		addANewNodeToTail.addToTail(6);
		addANewNodeToTail.addToTail(7);
		Assert.assertEquals(5, addANewNodeToTail.head.value);
		Assert.assertEquals(6, addANewNodeToTail.head.next.value);
		Assert.assertEquals(7, addANewNodeToTail.head.next.next.value);

		NodeList removingANode = new NodeList(5);
		removingANode.addToTail(6);
		removingANode.removeLast();
		Assert.assertEquals(null, removingANode.head.next);

		NodeList atIndex = new NodeList(5);
		atIndex.addToTail(6);
		atIndex.addToTail(9);
		Assert.assertEquals(9, atIndex.getAtIndex(2));

		NodeList atIndexTheSequal = new NodeList(5);
		atIndexTheSequal.addToTail(6);
		atIndexTheSequal.addToTail(9);
		Assert.assertEquals(6, atIndexTheSequal.getAtIndex(1));

		NodeList addAtIndexAgain = new NodeList(5);
		addAtIndexAgain.addToTail(6);
		addAtIndexAgain.addToTail(9);
		addAtIndexAgain.addAtIndex(8, 7);
		Assert.assertEquals(3, addAtIndexAgain.size);

		NodeList addAtIndexAgainAgain = new NodeList(5);
		addAtIndexAgainAgain.addToTail(6);
		addAtIndexAgainAgain.addToTail(9);
		addAtIndexAgainAgain.addAtIndex(8, 3);
		Assert.assertEquals(8, addAtIndexAgainAgain.head.next.next.value);

		NodeList deleteAtIndex = new NodeList(5);
		deleteAtIndex.addToTail(6);
		deleteAtIndex.addToHead(3);
		deleteAtIndex.deleteAtIndex(0);
		Assert.assertEquals(5, deleteAtIndex.head.value);

		NodeList deleteAtIndex2 = new NodeList(5);
		deleteAtIndex2.addToTail(6);
		deleteAtIndex2.addToHead(3);
		deleteAtIndex2.deleteAtIndex(1);
		Assert.assertEquals(6, deleteAtIndex2.head.next.value);
	}

	@Test
	public void leetCodeLinkedListTests() {
		NodeList leetCodeBaseCase = new NodeList();
		// [1]
		leetCodeBaseCase.addToHead(1);
		// [1, 3]
		leetCodeBaseCase.addToTail(3);
		// [1, 2, 3]
		leetCodeBaseCase.addAtIndex(1, 2);
		// [1, 3]
		leetCodeBaseCase.deleteAtIndex(1);
		Assert.assertEquals(3, leetCodeBaseCase.getAtIndex(1));

		NodeList leetCodeBaseCase2 = new NodeList();

		leetCodeBaseCase2.addToHead(2);
		Assert.assertEquals(2, leetCodeBaseCase2.getAtIndex(0));

		leetCodeBaseCase2.deleteAtIndex(1);
		Assert.assertEquals(2, leetCodeBaseCase2.getAtIndex(0));

		leetCodeBaseCase2.addToHead(2);
		Assert.assertEquals(2, leetCodeBaseCase2.getAtIndex(0));

		leetCodeBaseCase2.addToHead(7);
		Assert.assertEquals(7, leetCodeBaseCase2.getAtIndex(0));

		leetCodeBaseCase2.addToHead(3);
		Assert.assertEquals(3, leetCodeBaseCase2.getAtIndex(0));

		NodeList leetCodeBaseCase3 = new NodeList();

		// 4
		leetCodeBaseCase3.addToHead(4);
		Assert.assertEquals(4, leetCodeBaseCase3.getAtIndex(0));

		// 4
		Assert.assertEquals(-1, leetCodeBaseCase3.getAtIndex(1));

		// 1, 4
		leetCodeBaseCase3.addToHead(1);
		Assert.assertEquals(1, leetCodeBaseCase3.getAtIndex(0));

		// 5, 1, 4
		leetCodeBaseCase3.addToHead(5);
		Assert.assertEquals(5, leetCodeBaseCase3.getAtIndex(0));

		// 5, 1, 4
		leetCodeBaseCase3.deleteAtIndex(3);
		Assert.assertEquals(5, leetCodeBaseCase3.getAtIndex(0));

		NodeList leetCodeBaseCase4 = new NodeList();

		// 10
		leetCodeBaseCase4.addAtIndex(0, 10);
		Assert.assertEquals(10, leetCodeBaseCase4.getAtIndex(0));
	}

	@Test
	public void leetCodeLinkedListTestCase2() {
		/**
		 * ["MyLinkedList","addAtHead","addAtIndex","get","addAtHead","addAtTail","get","addAtTail","get","addAtHead","get","addAtHead"]
		 * [[], [5], [1,2], [1] ,[6], [2], [3], [1], [5], [2], [2], [6]]
		 */

		NodeList kata = new NodeList();
		// [5]
		kata.addToHead(5);
		// [5, 2]
		kata.addAtIndex(1, 2);
		// [6, 5, 2]
		kata.addToHead(6);
		// [6, 5, 2, 2]
		kata.addToTail(2);
		// [6, 5, 2, 2, 1]
		kata.addToTail(1);
		// [2, 6, 5, 2, 2, 1]
		kata.addToHead(2);
		// [6, 2, 6, 5, 2, 2, 1]
		kata.addToHead(6);

		Assert.assertEquals(6, kata.getAtIndex(0));
		Assert.assertEquals(1, kata.getAtIndex(6));
	}

	@Test
	public void leetCodeLinkedListTestCase3() {
		/**
		 * ["MyLinkedList","addAtHead","addAtTail","addAtTail","addAtTail","addAtTail","addAtTail","addAtTail","deleteAtIndex","addAtHead","addAtHead","get","addAtTail","addAtHead","get","addAtTail","addAtIndex","addAtTail","addAtHead","addAtHead","addAtHead","get","addAtIndex","addAtHead","get","addAtHead","deleteAtIndex","addAtHead","addAtTail","addAtTail","addAtIndex","addAtTail","addAtHead","get","addAtTail","deleteAtIndex","addAtIndex","deleteAtIndex","addAtHead","addAtTail","addAtHead","addAtHead","addAtTail","addAtTail","get","get","addAtHead","addAtTail","addAtTail","addAtTail","addAtIndex","get","addAtHead","addAtIndex","addAtHead","addAtTail","addAtTail","addAtIndex","deleteAtIndex","addAtIndex","addAtHead","addAtHead","deleteAtIndex","addAtTail","deleteAtIndex","addAtIndex","addAtTail","addAtHead","get","addAtIndex","addAtTail","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","deleteAtIndex","get","get","addAtHead","get","addAtTail","addAtTail","addAtIndex","addAtIndex","addAtHead","addAtTail","addAtTail","get","addAtIndex","addAtHead","deleteAtIndex","addAtTail","get","addAtHead","get","addAtHead","deleteAtIndex","get","addAtTail","addAtTail"]
		 * [[], 			[38],        [66],        [61],      [76],       [26],      [37],        [8],        [5],             [4],        [45],     [4],     [85],        [37],   [5],   [93],        [10,23],   [21],         [52],       [15],        [47],    [12],   [6,24],   [64],[4],[31],[6],[40],[17],[15],[19,2],[11],[86],[17],[55],[15],[14,95],[22],[66],[95],[8],[47],[23],[39],[30],[27],[0],[99],[45],[4],[9,11],[6],[81],[18,32],[20],[13],[42],[37,91],[36],[10,37],[96],[57],[20],[89],[18],[41,5],[23],[75],[7],[25,51],[48],[46],[29],[85],[82],[6],[38],[14],[1],[12],[42],[42],[83],[13],[14,20],[17,34],[36],[58],[2],[38],[33,59],[37],[15],[64],[56],[0],[40],[92],[63],[35],[62],[32]]
		 */

		NodeList kata = new NodeList();
		// 38
		kata.addToHead(38);
		// 38, 66
		kata.addToTail(66);
		// 38, 66, 61
		kata.addToTail(61);
		// 38, 66, 61, 76
		kata.addToTail(76);
		// 38, 66, 61, 76, 26
		kata.addToTail(26);
		// 38, 66, 61, 76, 26, 37
		kata.addToTail(37);
		// 38, 66, 61, 76, 26, 37, 8
		kata.addToTail(8);
		// 38, 66, 61, 76, 26, 8
		kata.deleteAtIndex(5);
		// 4, 38, 66, 61, 76, 26, 8
		kata.addToHead(4);
		// 45, 4, 38, 66, 61, 76, 26, 8
		kata.addToHead(45);

		Assert.assertEquals(
			45,
			kata.getAtIndex(0)
		);
		Assert.assertEquals(
			8,
			kata.getAtIndex(7)
		);

		// 45, 4, 38, 66, 61, 76, 26, 8, 85
		kata.addToTail(85);
		// 37, 45, 4, 38, 66, 61, 76, 26, 8, 85
		kata.addToHead(37);
		// 93, 37, 45, 4, 38, 66, 61, 76, 26, 8, 85
		kata.addToHead(93);
		// 93, 37, 45, 4, 38, 66, 61, 76, 26, 8, 23, 85
		kata.addAtIndex(10,23);

		Assert.assertEquals(
			23,
			kata.getAtIndex(10)
		);
		Assert.assertEquals(
			85,
			kata.getAtIndex(11)
		);
		
		// 93, 37, 45, 4, 38, 66, 61, 76, 26, 8, 23, 85, 21
		kata.addToTail(21);
		// 52, 93, 37, 45, 4, 38, 66, 61, 76, 26, 8, 23, 85, 21
		kata.addToHead(52);
		// 15, 52, 93, 37, 45, 4, 38, 66, 61, 76, 26, 8, 23, 85, 21
		kata.addToHead(15);
		// 47, 15, 52, 93, 37, 45, 4, 38, 66, 61, 76, 26, 8, 23, 85, 21
		kata.addToHead(47);
		// 47, 15, 52, 93, 37, 45, 24, 4, 38, 66, 61, 76, 26, 8, 23, 85, 21
		kata.addAtIndex(6, 24);

		Assert.assertEquals(
			4,
			kata.getAtIndex(7)	
		);
		Assert.assertEquals(
			24,
			kata.getAtIndex(6)	
		);
		Assert.assertEquals(
			21,
			kata.getAtIndex(16)	
		);

	}

	@Test
	public void testMoveZeros() {
		int[] nums = new int[] { 1, 0, 1, 3, 0, 3 };
		MoveZerosToEnd kata = new MoveZerosToEnd();

		Assert.assertArrayEquals(new int[] { 1, 1, 3, 3, 0, 0 }, kata.moveZeroes(nums));
	}

	@Test
	public void testSortByParity() {
		int[] nums = new int[] { 3, 1, 2, 4 };
		SortByParity kata = new SortByParity();

		Assert.assertArrayEquals(new int[] { 2, 4, 3, 1 }, kata.sort(nums));
	}

	@Test
	public void testReverseStringViaRecursion() {
		ReverseStringUsingRecursion kata = new ReverseStringUsingRecursion();

		Assert.assertArrayEquals(new char[] { 't', 'a', 'c' }, kata.reverse(new char[] { 'c', 'a', 't' }));

		Assert.assertArrayEquals(new char[] { 'p', 'o', 'p', 'p', 'i', 'h' },
				kata.reverse(new char[] { 'h', 'i', 'p', 'p', 'o', 'p' }));
	}

	@Test
	public void testSwapNodesInPairsIteratively() {
		Node tobeSorted = new Node(1);
		Node second = new Node(2);
		tobeSorted.next = second;
		Node third = new Node(3);
		second.next = third;
		Node forth = new Node(4);
		third.next = forth;

		SwapAdjacentPairsOfNodes kata = new SwapAdjacentPairsOfNodes();
		Node sorted = kata.swapAdjacentIteratively(tobeSorted);

		Assert.assertEquals(2, sorted.value);
		Assert.assertEquals(1, sorted.next.value);
		Assert.assertEquals(4, sorted.next.next.value);
		Assert.assertEquals(3, sorted.next.next.next.value);
		Assert.assertEquals(null, sorted.next.next.next.next);
	}

	@Test
	public void testSwapNodesInPairsRecursively() {
		Node tobeSorted = new Node(1);
		Node second = new Node(2);
		tobeSorted.next = second;
		Node third = new Node(3);
		second.next = third;
		Node forth = new Node(4);
		third.next = forth;

		SwapAdjacentPairsOfNodes kata = new SwapAdjacentPairsOfNodes();
		Node sorted = kata.swapAdjacentRecursively(tobeSorted);

		Assert.assertEquals(2, sorted.value);
		Assert.assertEquals(1, sorted.next.value);
		Assert.assertEquals(4, sorted.next.next.value);
		Assert.assertEquals(3, sorted.next.next.next.value);
		Assert.assertEquals(null, sorted.next.next.next.next);
	}

	@Test
	public void testRobotBoundedInCircleCaseOne() {
		RobotBoundedInCircle robot = new RobotBoundedInCircle();
		boolean actual = robot.main("GGLLGG");
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testRobotBoundedInCircleCaseTwo() {
		RobotBoundedInCircle robot = new RobotBoundedInCircle();
		boolean actual = robot.main("GG");
		boolean expected = false;
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testRobotBoundedInCircleCaseThree() {
		RobotBoundedInCircle robot = new RobotBoundedInCircle();
		boolean actual = robot.main("GL");
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}

}
