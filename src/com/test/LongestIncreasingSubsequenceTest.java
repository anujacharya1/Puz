package com.test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.LongestIncreasingSubsequence;

public class LongestIncreasingSubsequenceTest {

	LongestIncreasingSubsequence seq;

	@Before
	public void setUp() throws Exception {
		seq = new LongestIncreasingSubsequence();
	}

	@After
	public void tearDown() throws Exception {
		seq = null;
	}

	@Test
	public void testLIS() {
		int[] input = {1, 33, 2, 5, 11, 13, 4};
		List<Integer> output = seq.LIS(input);

		Integer[] intArray = { 1, 2, 5, 11, 13 };
		List<Integer> expected = Arrays.asList(intArray);
		
		assertEquals(expected, output);
	}
}