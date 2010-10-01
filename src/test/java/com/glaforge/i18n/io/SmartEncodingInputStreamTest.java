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

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

public class SmartEncodingInputStreamTest extends TestCase {
	private InputStream getInputStream(String fileName) throws IOException {
		return this.getClass().getResource(fileName).openStream();
	}

	public void testIso88591() throws IOException {
		SmartEncodingInputStream smartEncodingInputStream = new SmartEncodingInputStream(
				getInputStream("iso-8859-1.txt"), 4096, Charset
						.forName("ISO-8859-1"));
		assertEquals(Charset.forName("ISO-8859-1"), smartEncodingInputStream
				.getEncoding());
		assertEquals("\u00E9", IOUtils
				.toString(smartEncodingInputStream.getReader()));

	}

	public void testUtf16be() throws IOException {
		SmartEncodingInputStream smartEncodingInputStream = new SmartEncodingInputStream(
				getInputStream("utf-16-be.txt"), 4096, Charset
						.forName("ISO-8859-1"));
		assertEquals(Charset.forName("UTF-16BE"), smartEncodingInputStream
				.getEncoding());
		assertEquals("\u00E9", IOUtils
				.toString(smartEncodingInputStream.getReader()));

	}

	public void testUtf16le() throws IOException {
		SmartEncodingInputStream smartEncodingInputStream = new SmartEncodingInputStream(
				getInputStream("utf-16-le.txt"), 4096, Charset
						.forName("ISO-8859-1"));
		assertEquals(Charset.forName("UTF-16LE"), smartEncodingInputStream
				.getEncoding());
		assertEquals("\u00E9", IOUtils
				.toString(smartEncodingInputStream.getReader()));

	}

	public void testUtf8() throws IOException {
		SmartEncodingInputStream smartEncodingInputStream = new SmartEncodingInputStream(
				getInputStream("utf-8.txt"), 4096, Charset
						.forName("ISO-8859-1"));
		assertEquals(Charset.forName("UTF-8"), smartEncodingInputStream
				.getEncoding());
		assertEquals("\u00E9", IOUtils
				.toString(smartEncodingInputStream.getReader()));

	}

	public void testUtf8Bom() throws IOException {
		SmartEncodingInputStream smartEncodingInputStream = new SmartEncodingInputStream(
				getInputStream("utf-8-bom.txt"), 4096, Charset
						.forName("ISO-8859-1"));
		assertEquals(Charset.forName("UTF-8"), smartEncodingInputStream
				.getEncoding());
		assertEquals("\u00E9", IOUtils
				.toString(smartEncodingInputStream.getReader()));

	}

}
