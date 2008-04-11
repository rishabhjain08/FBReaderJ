package org.geometerplus.zlibrary.text.view.impl;

import org.geometerplus.zlibrary.text.view.ZLTextStyle;

public class ZLTextElementArea extends ZLTextRectangularArea { 
	public final int ParagraphNumber;
	public final int TextElementNumber;
	final int StartCharNumber;	
	final int Length;
	final boolean AddHyphenationSign;
	final boolean ChangeStyle;
	final ZLTextStyle Style;
	public final ZLTextElement Element;

	ZLTextElementArea(int paragraphNumber, int textElementNumber, int startCharNumber, int length, boolean addHyphenationSign, boolean changeStyle, ZLTextStyle style, ZLTextElement element, int xStart, int xEnd, int yStart, int yEnd) {
		super(xStart, xEnd, yStart, yEnd);
		ParagraphNumber = paragraphNumber;
		TextElementNumber = textElementNumber;
		StartCharNumber = startCharNumber;
		Length = length;
		AddHyphenationSign = addHyphenationSign;
		ChangeStyle = changeStyle;
		Style = style;
		Element = element;
	}
}