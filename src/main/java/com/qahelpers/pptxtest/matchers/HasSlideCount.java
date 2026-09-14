package com.qahelpers.pptxtest.matchers;

import com.qahelpers.pptxtest.PPTX;
import org.hamcrest.Description;

public class HasSlideCount extends PPTXMatcher {
    private final int expectedSlideCount;

    public HasSlideCount(int expectedSlideCount) {
        this.expectedSlideCount = expectedSlideCount;
    }

    @Override
    protected boolean matchesSafely(PPTX item) {
        return item.powerpoint.getSlides().size() == expectedSlideCount;
    }

    @Override
    protected void describeMismatchSafely(PPTX item, Description mismatchDescription) {
        mismatchDescription.appendText("was \"").appendText(item.name).appendText("\" with ")
                .appendValue(item.powerpoint.getSlides().size()).appendText(" slides");
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a PPTX file with ").appendValue(expectedSlideCount).appendText(" slides");
    }
}
