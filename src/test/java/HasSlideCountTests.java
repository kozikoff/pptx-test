import com.qahelpers.pptxtest.PPTX;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.qahelpers.pptxtest.PPTX.hasSlideCount;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HasSlideCountTests {

    @Test
    void canAssertThatPptxHasSlideCount() throws IOException {
        PPTX pptx = new PPTX(getClass().getClassLoader().getResource("TestPPTX.pptx"));
        assertThat(pptx, hasSlideCount(4));
    }

    @Test
    void assertionFailsWhenSlideCountIsDifferent() throws IOException {
        PPTX pptx = new PPTX(getClass().getClassLoader().getResource("TestPPTX.pptx"));
        assertThrows(AssertionError.class, () -> assertThat(pptx, hasSlideCount(5)));
    }
}
