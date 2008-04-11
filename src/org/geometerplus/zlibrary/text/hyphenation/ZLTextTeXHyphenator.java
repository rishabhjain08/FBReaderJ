package org.geometerplus.zlibrary.text.hyphenation;

import java.util.*;
import org.geometerplus.zlibrary.core.util.*;
import org.geometerplus.zlibrary.core.library.ZLibrary;

public final class ZLTextTeXHyphenator extends ZLTextHyphenator {
	private final HashMap myPatternTable = new HashMap();
	private String myLanguage;
	
	public ZLTextTeXHyphenator() {
	}

	void addPattern(ZLTextTeXHyphenationPattern pattern) {
		myPatternTable.put(pattern, pattern);
	}

	public void load(final String language) {
		if (language.equals(myLanguage)) {
			return;
		}
		myLanguage = language;
		unload();
		final String path = ZLibrary.JAR_DATA_PREFIX + "data/hyphenationPatterns/" + language + ".pattern"; 
		new ZLTextHyphenationReader(this).read(path);
	}	

	public void unload() {
		myPatternTable.clear();
	}

	public void hyphenate(char[] stringToHyphenate, boolean[] mask, int length) {
		if (myPatternTable.isEmpty()) {
			for (int i = 0; i < length - 1; i++) {
				mask[i] = false;
			}
			return;
		}

		byte[] values = new byte[length + 1];
		
		final HashMap table = myPatternTable;
		ZLTextTeXHyphenationPattern pattern =
			new ZLTextTeXHyphenationPattern(stringToHyphenate, 0, length, false);
		for (int offset = 0; offset < length - 1; offset++) {
			int len = length - offset + 1;
			pattern.update(stringToHyphenate, offset, len - 1);
			while (--len > 0) {
				pattern.myLength = len;
				pattern.myHashCode = 0;
				ZLTextTeXHyphenationPattern toApply =
					(ZLTextTeXHyphenationPattern)table.get(pattern);
				if (toApply != null) {
					toApply.apply(values, offset);
				}
			}
		}
 	
		for (int i = 0; i < length - 1; i++) {
			mask[i] = (values[i + 1] % 2) == 1;
		}
	}
}