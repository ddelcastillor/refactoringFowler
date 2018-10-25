package es.escuelait.refactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IntervalTest {

	private static final double PRECISION = 0.0000001;

	@Test
	void shiftTest() {
		Interval interval = new IntervalBuilder().closed(4.4).open(5.6).build();
		interval.shift(4.9);
		assertTrue(interval.includes(4.4 + 4.9));
		assertFalse(interval.includes(5.6 + 4.9));
		assertEquals(interval.length(), 1.2, PRECISION);
	}

	@Test
	void lengthTest() {
		Interval interval = new IntervalBuilder().closed(-4.4).open(5.6).build();
		assertEquals(interval.length(), 10, PRECISION);
	}

	@Test
	void IsIncludeDoubleIncludedIncludedtest() {
		Interval interval = new IntervalBuilder().closed(-4).closed(4).build();
		assertFalse(interval.includes(-(4 + PRECISION)));
		assertTrue(interval.includes(-4));
		assertTrue(interval.includes(0));
		assertTrue(interval.includes(4));
		assertFalse(interval.includes(4 + PRECISION));
	}

	@Test
	void IsIncludeDoubleOpenClosedTest() {
		Interval interval = new IntervalBuilder().open(-4).closed(4).build();
		assertFalse(interval.includes(-(4 + PRECISION)));
		assertFalse(interval.includes(-4));
		assertTrue(interval.includes(0));
		assertTrue(interval.includes(4));
		assertFalse(interval.includes(4 + PRECISION));
	}

	@Test
	void IsIncludeDoubleOpenOpenTest() {
		Interval interval = new IntervalBuilder().open(-4).open(4).build();
		assertFalse(interval.includes(-(4 + PRECISION)));
		assertFalse(interval.includes(-4));
		assertTrue(interval.includes(0));
		assertFalse(interval.includes(4));
		assertFalse(interval.includes(4 + PRECISION));
	}

	@Test
	void IsIncludeDoubleClosedOpenTest() {
		Interval interval = new IntervalBuilder().closed(-4).open(4).build();
		assertFalse(interval.includes(-(4 + PRECISION)));
		assertTrue(interval.includes(-4));
		assertTrue(interval.includes(0));
		assertFalse(interval.includes(4));
		assertFalse(interval.includes(4 + PRECISION));
	}

	@Test
	void IsIncludeIntervalClosedClosedTest() {
		Interval inclusiveInterval = new IntervalBuilder().closed(-4).closed(4).build();
		Interval includedInterval = new IntervalBuilder().closed(-4).closed(4).build();
		assertTrue(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().open(-4).closed(4).build();
		includedInterval = new IntervalBuilder().closed(-4).closed(4).build();
		assertFalse(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().closed(-4).open(4).build();
		includedInterval = new IntervalBuilder().closed(-4).closed(4).build();
		assertFalse(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().open(-4).open(4).build();
		includedInterval = new IntervalBuilder().closed(-4).closed(4).build();
		assertFalse(inclusiveInterval.includes(includedInterval));
		
		inclusiveInterval = new IntervalBuilder().closed(-2).closed(2).build();
		includedInterval = new IntervalBuilder().closed(-4).closed(4).build();
		assertFalse(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().open(-2).closed(2).build();
		includedInterval = new IntervalBuilder().closed(-4).closed(4).build();
		assertFalse(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().closed(-2).open(2).build();
		includedInterval = new IntervalBuilder().closed(-4).closed(4).build();
		assertFalse(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().open(-2).open(2).build();
		includedInterval = new IntervalBuilder().closed(-4).closed(4).build();
		assertFalse(inclusiveInterval.includes(includedInterval));
		
		inclusiveInterval = new IntervalBuilder().closed(-6).closed(6).build();
		includedInterval = new IntervalBuilder().closed(-4).closed(4).build();
		assertTrue(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().open(-6).closed(6).build();
		includedInterval = new IntervalBuilder().closed(-4).closed(4).build();
		assertTrue(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().closed(-6).open(6).build();
		includedInterval = new IntervalBuilder().closed(-4).closed(4).build();
		assertTrue(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().open(-6).open(6).build();
		includedInterval = new IntervalBuilder().closed(-4).closed(4).build();
		assertTrue(inclusiveInterval.includes(includedInterval));
		
		inclusiveInterval = new IntervalBuilder().closed(0).closed(6).build();
		includedInterval = new IntervalBuilder().closed(-4).closed(4).build();
		assertFalse(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().open(0).closed(6).build();
		includedInterval = new IntervalBuilder().closed(-4).closed(4).build();
		assertFalse(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().closed(0).open(6).build();
		includedInterval = new IntervalBuilder().closed(-4).closed(4).build();
		assertFalse(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().open(0).open(6).build();
		includedInterval = new IntervalBuilder().closed(-4).closed(4).build();
		assertFalse(inclusiveInterval.includes(includedInterval));
	}
	
	@Test
	void IsIncludeIntervalOpenClosedTest() {
		Interval inclusiveInterval = new IntervalBuilder().closed(-4).closed(4).build();
		Interval includedInterval = new IntervalBuilder().open(-4).closed(4).build();
		assertTrue(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().open(-4).closed(4).build();
		includedInterval = new IntervalBuilder().open(-4).closed(4).build();
		assertTrue(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().closed(-4).open(4).build();
		includedInterval = new IntervalBuilder().open(-4).closed(4).build();
		assertFalse(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().open(-4).open(4).build();
		includedInterval = new IntervalBuilder().open(-4).closed(4).build();
		assertFalse(inclusiveInterval.includes(includedInterval));
	}
	
	@Test
	void IsIncludeIntervalClosedOpenTest() {
		Interval inclusiveInterval = new IntervalBuilder().closed(-4).closed(4).build();
		Interval includedInterval = new IntervalBuilder().closed(-4).open(4).build();
		assertTrue(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().open(-4).closed(4).build();
		includedInterval = new IntervalBuilder().closed(-4).open(4).build();
		assertFalse(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().closed(-4).open(4).build();
		includedInterval = new IntervalBuilder().closed(-4).open(4).build();
		assertTrue(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().open(-4).open(4).build();
		includedInterval = new IntervalBuilder().closed(-4).open(4).build();
		assertFalse(inclusiveInterval.includes(includedInterval));
	}
	
	@Test
	void IsIncludeIntervalOpenOpenTest() {
		Interval inclusiveInterval = new IntervalBuilder().closed(-4).closed(4).build();
		Interval includedInterval = new IntervalBuilder().open(-4).open(4).build();
		assertTrue(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().open(-4).closed(4).build();
		includedInterval = new IntervalBuilder().open(-4).open(4).build();
		assertTrue(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().closed(-4).open(4).build();
		includedInterval = new IntervalBuilder().open(-4).open(4).build();
		assertTrue(inclusiveInterval.includes(includedInterval));
		inclusiveInterval = new IntervalBuilder().open(-4).open(4).build();
		includedInterval = new IntervalBuilder().open(-4).open(4).build();
		assertTrue(inclusiveInterval.includes(includedInterval));
	}

}
