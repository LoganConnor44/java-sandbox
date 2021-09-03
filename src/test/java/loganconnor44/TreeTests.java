package loganconnor44;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import loganconnor44.katas.trees.*;

public class TreeTests {
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}

	@Test
	public void allPathsForASum() {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		int sum = 23;

		AllPathsForASum allPathsForASum = new AllPathsForASum();
		List<List<Integer>> actual = allPathsForASum.findPaths(root, sum);
		
		List<Integer> expectedSubList1 = Arrays.asList(12, 7, 4);
		List<Integer> expectedSubList2 = Arrays.asList(12, 1, 10);

		List<List<Integer>> expected = new ArrayList<>();
		expected.add(expectedSubList1);
		expected.add(expectedSubList2);

		Assert.assertEquals(
			expected,
			actual
		);
	}

	@Test
	public void binaryTreePathSum() {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);

		int sum1 = 23;
		int sum2 = 16;

		BinaryTreePathSum binaryTreePathSum = new BinaryTreePathSum();		
		
		Assert.assertTrue(binaryTreePathSum.hasPath(root, sum1));
		Assert.assertFalse(binaryTreePathSum.hasPath(root, sum2));
	}

	@Test
	public void sumOfPathNumbers() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);

		int expected = 332;

		SumOfPathNumbers sumOfPathNumbers = new SumOfPathNumbers();
		int actual = sumOfPathNumbers.findSumOfPathNumbers(root);
		
		Assert.assertEquals(
			expected, 
			actual
		);

		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(7);
		root2.right = new TreeNode(9);
		root2.right.left = new TreeNode(2);
		root2.right.right = new TreeNode(9);

		int expected2 = 408;

		SumOfPathNumbers sumOfPathNumbers2 = new SumOfPathNumbers();
		int actual2 = sumOfPathNumbers2.findSumOfPathNumbers(root2);
		
		Assert.assertEquals(
			expected2, 
			actual2
		);

		TreeNode root3 = new TreeNode(2);
		root3.left = new TreeNode(5);
		root3.right = new TreeNode(7);
		root3.right.left = new TreeNode(2);
		root3.right.right = new TreeNode(8);

		int expected3 = 575;

		SumOfPathNumbers sumOfPathNumbers3 = new SumOfPathNumbers();
		int actual3 = sumOfPathNumbers3.findSumOfPathNumbers(root3);
		
		Assert.assertEquals(
			expected3, 
			actual3
		);
	}

	@Test
	public void pathWithGivenSequence() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);

		int[] sequence1 = new int[]{1, 0, 7};
		int[] sequence2 = new int[]{1, 1, 6};

		PathWithGivenSequence pathWithGivenSequence = new PathWithGivenSequence();
		
		Assert.assertFalse(pathWithGivenSequence.findPaths(root, sequence1));
		Assert.assertTrue(pathWithGivenSequence.findPaths(root, sequence2));
	}
}
