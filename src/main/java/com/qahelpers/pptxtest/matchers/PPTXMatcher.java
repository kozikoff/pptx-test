package com.qahelpers.pptxtest.matchers;

import com.qahelpers.pptxtest.PPTX;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;
import org.hamcrest.TypeSafeMatcher;

import java.util.List;


abstract class PPTXMatcher extends TypeSafeMatcher<PPTX> implements SelfDescribing {

    protected String reduceSpaces(String text) {
        return text.replaceAll("[\\s\\n\\r\u00a0]+", " ").trim();
    }

    @Override
    protected void describeMismatchSafely(PPTX item, Description mismatchDescription) {
        mismatchDescription.appendText("was \"").appendText(item.name).appendText("\"\n");
        List<XSLFSlide> slides = item.powerpoint.getSlides();
        for (XSLFSlide slide : slides) {
            List<XSLFShape> shapes = slide.getShapes();
            for (XSLFShape shape : shapes) {
                if (shape instanceof XSLFTextShape) {
                    XSLFTextShape textShape = (XSLFTextShape) shape;
                    mismatchDescription.appendText(textShape.getText()).appendText("\t");
                }
            }
            mismatchDescription.appendText("\n");
        }
    }
}
