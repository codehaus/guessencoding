/**
 * Copyright 2010 Francois-Xavier Bonnet
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *           http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the License.
 **/
package com.glaforge.i18n.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import junit.framework.TestCase;

public class CharsetToolkitTest extends TestCase {

	private File getFile(String fileName) throws URISyntaxException {
		return new File(this.getClass().getResource(fileName).toURI());
	}

	public void testGuessEncodingIso88591() throws FileNotFoundException,
			IOException, URISyntaxException {
		assertEquals(Charset.forName("ISO-8859-1"), CharsetToolkit
				.guessEncoding(getFile("iso-8859-1.txt"), 4096, Charset
						.forName("ISO-8859-1")));
	}

	public void testGuessEncodingUsAscii() throws FileNotFoundException,
			IOException, URISyntaxException {
		assertEquals(Charset.forName("US-ASCII"), CharsetToolkit.guessEncoding(
				getFile("us-ascii.txt"), 4096, Charset
				.forName("ISO-8859-1")));
	}

	public void testGuessEncodingUtf16be() throws FileNotFoundException,
			IOException, URISyntaxException {
		assertEquals(Charset.forName("UTF-16BE"), CharsetToolkit.guessEncoding(
				getFile("utf-16-be.txt"), 4096, Charset.forName("ISO-8859-1")));
	}

	public void testGuessEncodingUtf16le() throws FileNotFoundException,
			IOException, URISyntaxException {
		assertEquals(Charset.forName("UTF-16LE"), CharsetToolkit.guessEncoding(
				getFile("utf-16-le.txt"), 4096, Charset.forName("ISO-8859-1")));
	}

	public void testGuessEncodingUtf8() throws FileNotFoundException,
			IOException, URISyntaxException {
		assertEquals(Charset.forName("UTF-8"), CharsetToolkit.guessEncoding(
				getFile("utf-8.txt"), 4096, Charset.forName("ISO-8859-1")));
	}

	public void testGuessEncodingUtf8Bom() throws FileNotFoundException,
			IOException, URISyntaxException {
		assertEquals(Charset.forName("UTF-8"), CharsetToolkit.guessEncoding(
				getFile("utf-8-bom.txt"), 4096, Charset.forName("ISO-8859-1")));
	}

}
