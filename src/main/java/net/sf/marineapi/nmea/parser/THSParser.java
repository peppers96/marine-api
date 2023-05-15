/* 
 * THSParser.java
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

import net.sf.marineapi.nmea.sentence.THSSentence;
import net.sf.marineapi.nmea.sentence.SentenceId;
import net.sf.marineapi.nmea.sentence.TalkerId;

/**
 * THS sentence parser.
 * 
 * @author Kimmo Tuukkanen
 */
class THSParser extends SentenceParser implements THSSentence {

	private static final int HEADING = 0;
	private static final int MODE_INDICATOR = 1;

	/**
	 * Creates a new THS parser.
	 * 
	 * @param nmea THS sentence String to parse.
	 */
	public THSParser(String nmea) {
		super(nmea, SentenceId.THS);
	}

	/**
	 * Creates a new empty THS sentence.
	 * 
	 * @param talker Talker id to set
	 */
	public THSParser(TalkerId talker) {
		super(talker, SentenceId.THS, 2);
	}

	/*
	 * (non-Javadoc)
	 * @see net.sf.marineapi.nmea.parser.HeadingSentence#getHeading()
	 */
	public double getHeading() {
		return getDoubleValue(HEADING);
	}

	/*
	 * (non-Javadoc)
	 * @see net.sf.marineapi.nmea.sentence.HeadingSentence#isTrue()
	 */
	public boolean isTrue() {
		return getCharValue(MODE_INDICATOR) == 'A';
	}

	/*
	 * (non-Javadoc)
	 * @see net.sf.marineapi.nmea.parser.HeadingSentence#setHeading(double)
	 */
	public void setHeading(double THS) {
		setDegreesValue(HEADING, THS);
	}
}
