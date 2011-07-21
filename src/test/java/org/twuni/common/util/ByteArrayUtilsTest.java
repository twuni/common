package org.twuni.common.util;

import org.junit.Assert;
import org.junit.Test;

public class ByteArrayUtilsTest {

	@Test
	public void testTrimArrayWithNoLeadingZeroes() {
		byte [] expected = { 1, 2, 3, 4, 5 };
		byte [] actual = { 1, 2, 3, 4, 5 };
		Assert.assertArrayEquals( expected, ByteArrayUtils.trim( actual ) );
	}

	@Test
	public void testTrimArrayWithOneLeadingZero() {
		byte [] expected = { 1, 2, 3, 4, 5 };
		byte [] actual = { 0, 1, 2, 3, 4, 5 };
		Assert.assertArrayEquals( expected, ByteArrayUtils.trim( actual ) );
	}

	@Test
	public void testTrimArrayWithManyLeadingZeroes() {
		byte [] expected = { 1, 2, 3, 4, 5 };
		byte [] actual = { 0, 0, 0, 0, 0, 1, 2, 3, 4, 5 };
		Assert.assertArrayEquals( expected, ByteArrayUtils.trim( actual ) );
	}

	@Test
	public void testTrimArrayWithContainedZeroes() {
		byte [] expected = { 1, 0, 2, 0, 3, 0, 4, 0, 5 };
		byte [] actual = { 0, 1, 0, 2, 0, 3, 0, 4, 0, 5 };
		Assert.assertArrayEquals( expected, ByteArrayUtils.trim( actual ) );
	}
	
	@Test
    public void testPadLeftForExactLength() {
		byte [] expected = { 1, 2, 3, 4, 5 };
		byte [] actual = { 1, 2, 3, 4, 5 };
		Assert.assertArrayEquals( expected, ByteArrayUtils.padLeft( actual, expected.length ) );
    }

	@Test
    public void testPadLeftForShorterLength() {
		byte [] expected = { 1, 2, 3, 4, 5 };
		byte [] actual = { 1, 2, 3, 4, 5 };
		Assert.assertArrayEquals( expected, ByteArrayUtils.padLeft( actual, expected.length - 1 ) );
    }

	@Test
    public void testPadLeftForGreaterLength() {
		byte [] expected = { 0, 0, 1, 2, 3, 4, 5 };
		byte [] actual = { 1, 2, 3, 4, 5 };
		Assert.assertArrayEquals( expected, ByteArrayUtils.padLeft( actual, expected.length ) );
    }

	@Test
    public void testPadRightForExactLength() {
		byte [] expected = { 1, 2, 3, 4, 5 };
		byte [] actual = { 1, 2, 3, 4, 5 };
		Assert.assertArrayEquals( expected, ByteArrayUtils.padRight( actual, expected.length ) );
    }

	@Test
    public void testPadRightForShorterLength() {
		byte [] expected = { 1, 2, 3, 4, 5 };
		byte [] actual = { 1, 2, 3, 4, 5 };
		Assert.assertArrayEquals( expected, ByteArrayUtils.padRight( actual, expected.length - 1 ) );
    }

	@Test
    public void testPadRightForGreaterLength() {
		byte [] expected = { 1, 2, 3, 4, 5, 0, 0, 0 };
		byte [] actual = { 1, 2, 3, 4, 5 };
		Assert.assertArrayEquals( expected, ByteArrayUtils.padRight( actual, expected.length ) );
    }

}
