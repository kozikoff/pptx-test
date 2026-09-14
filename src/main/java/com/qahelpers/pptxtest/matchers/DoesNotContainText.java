package com.qahelpers.pptxtest.matchers;

import com.qahelpers.pptxtest.PPTX;
import org.apache.poi.xslf.usermodel.*;
import org.hamcrest.Description;

import java.util.List;

public class DoesNotContainText extends PPTXMatcher {
    private final String substring;

    public DoesNotContainText(String substring) {
        this.substring = reduceSpaces(substring);
    }

    @Override
    protected boolean matchesSafely(PPTX item) {
        List<XSLFSlide> slides = item.powerpoint.getSlides();
        for (XSLFSlide slide : slides) {
            List<XSLFShape> shapes = slide.getShapes();
            for (XSLFShape shape : shapes) {
                if (shape instanceof XSLFTextShape) {
                    XSLFTextShape textShape = (XSLFTextShape) shape;
                    if (textShape.getText().contains(substring)) {
                        return false;
                    }
                }
                if (shape instanceof XSLFTable) {
                    XSLFTable tableShape = (XSLFTable) shape;
                    for (XSLFTableRow tableRow : tableShape) {
                        for (XSLFTableCell tableCell : tableRow) {
                            if (tableCell.getText().contains(substring)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a PPTX file does not contain text ").appendValue(reduceSpaces(substring));
    }
}
