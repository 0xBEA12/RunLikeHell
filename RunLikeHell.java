// ====================
// RunLikeHell.java
// ====================

import java.util.*;


public class RunLikeHell
{
	public static int maxGain(int [] blocks)
	{
		// Base cases to check before reaching for loop.
		int maxKnowledge [] = new int[blocks.length];

		if (blocks.length == 0)
		{
			return 0;
		}
		else if (blocks.length == 1)
		{
			return blocks[0];
		}
		else if (blocks.length == 2)
		{
			return Math.max(blocks[0], blocks[1]);
		}
		else if (blocks.length == 3)
		{
			return Math.max((blocks[0] + blocks[2]), blocks[1]);
		}

		// If blocks[] has at least 4 blocks these are the base cases
		// that every test will have to start with.
		// We also store the results of each subproblem in this array.
		maxKnowledge[0] = blocks[0];
		maxKnowledge[1] = blocks[1];
		maxKnowledge[2] = blocks[0] + blocks[2];

		// Iterate through each block in blocks[], starting at 4, and determine which
		// possibility it adds the most value to. Each block opens 4 possible moves to
		// consider so we take the max value of these 4 moves every iteration and sum
		// the subproblems to solve the overall problem.
		for (int i = 3; i < blocks.length; i++)
		{
			maxKnowledge[i] += Math.max(Math.max(maxKnowledge[i - 1], maxKnowledge[i - 2] + blocks[i]), Math.max(maxKnowledge[i - 2], maxKnowledge[i - 3] + blocks[i]));

		}

		// The answer to the overall problem will always be in the final cell of
		// our maxKnowledge[].
		return maxKnowledge[blocks.length - 1];



}