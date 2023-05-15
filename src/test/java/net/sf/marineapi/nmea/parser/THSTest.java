/* 
 * THSTest.java
 * Copyright (C) 2011 Kimmo Tuukkanen
 * 
 * This file is part of Java Marine API.
 * <http://ktuukkan.github.io/marine-api/>
 * 
 * Java Marine API is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Java Marine API is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Java Marine API. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.marineapi.nmea.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import net.sf.marineapi.nmea.sentence.THSSentence;
import net.sf.marineapi.nmea.sentence.SentenceId;
import net.sf.marineapi.nmea.sentence.TalkerId;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Kimmo Tuukkanen
 */
public class THSTest {

	public static final String EXAMPLE = "$GNTHS,90.1,A";
	THSSentence THS;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		THS = new THSParser(EXAMPLE);
	}

	/**
	 * Test method for {@link net.sf.marineapi.nmea.parser.THSParser(TalkerId)}.
	 */
	@Test
	public void testConstructor() {
		THSSentence empty = new THSParser(TalkerId.HE);
		assertEquals(TalkerId.HE, empty.getTalkerId());
		assertEquals(SentenceId.THS.toString(), empty.getSentenceId());
		try {
			empty.getHeading();
		} catch (DataNotAvailableException e) {
			// pass
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link net.sf.marineapi.nmea.parser.THSParser#isTrue()}.
	 */
	@Test
	public void testIsTrue() {
		assertTrue(THS.isTrue());
	}

	/**
	 * Test method for
	 * {@link net.sf.marineapi.nmea.parser.THSParser#getHeading()}.
	 */
	@Test
	public void testGetHeading() {
		double value = THS.getHeading();
		assertEquals(90.0, value, 0.1);
	}

	/**
	 * Test method for
	 * {@link net.sf.marineapi.nmea.parser.THSParser#setHeading(double)}.
	 */
	@Test
	public void testSetHeading() {
		THS.setHeading(123.45);
		assertEquals(123.5, THS.getHeading(), 0.1);
	}

	/**
	 * Test method for
	 * {@link net.sf.marineapi.nmea.parser.THSParser#setHeading(double)}.
	 */
	@Test
	public void testSetNegativeHeading() {
		try {
			THS.setHeading(-0.005);
			fail("Did not throw exception");
		} catch (IllegalArgumentException iae) {
			// pass
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link net.sf.marineapi.nmea.parser.THSParser#setHeading(double)}.
	 */
	@Test
	public void testSetHeadingTooHigh() {
		try {
			THS.setHeading(360.0001);
			fail("Did not throw exception");
		} catch (IllegalArgumentException iae) {
			// pass
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
