/* 
 * STIParser.java
 * Copyright (C) 2010 Kimmo Tuukkanen
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

import net.sf.marineapi.nmea.sentence.STISentence;
import net.sf.marineapi.nmea.sentence.SentenceId;
import net.sf.marineapi.nmea.sentence.TalkerId;

/**
 * STI sentence parser.
 * 
 * @author Kimmo Tuukkanen
 */
class STIParser extends SentenceParser implements STISentence {

	private static final int PITCH = 4;
	private static final int ROLL = 5;

	/**
	 * Constructor.
	 *
	 * @param mta STI sentence String to parse.
	 */
	public STIParser(String mta) {
		super(mta, SentenceId.STI);
	}

	/**
	 * Constructor for empty STI sentence.
	 *
	 * @param talker Talker ID to set.
	 */
	public STIParser(TalkerId talker) {
		super(talker, SentenceId.STI, 2);
	}

	/*
	 * (non-Javadoc)
	 * @see net.sf.marineapi.nmea.sentence.STISentence#getPitch()
	 */
	public double getPitch() {
		return getDoubleValue(PITCH);
	}

	/*
	 * (non-Javadoc)
	 * @see net.sf.marineapi.nmea.sentence.STISentence#getRoll()
	 */
	public double getRoll() {
		return getDoubleValue(ROLL);
	}
}
