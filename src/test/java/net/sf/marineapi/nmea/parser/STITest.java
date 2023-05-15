package net.sf.marineapi.nmea.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.sf.marineapi.nmea.sentence.STISentence;
import net.sf.marineapi.nmea.sentence.SentenceId;
import net.sf.marineapi.nmea.sentence.TalkerId;

import org.junit.Before;
import org.junit.Test;

public class STITest {

	public static final String EXAMPLE = "$PSTI,036,054314.000,030521,191.69,-16.35,0.00,R";

	private STISentence mta;

	@Before
	public void setUp() throws Exception {
		mta = new STIParser(EXAMPLE);
	}

	@Test
	public void testSTIParserString() {
		assertEquals(TalkerId.P, mta.getTalkerId());
		assertEquals(SentenceId.STI.name(), mta.getSentenceId());
	}

	@Test
	public void testGetPitch() {
		assertEquals(-16.35, mta.getPitch(), 0.01);
	}

	@Test
	public void testgetRoll() {
		assertEquals(0.00, mta.getRoll(), 0.01);
	}

}
