import com.qahelpers.pptxtest.PPTX;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.qahelpers.pptxtest.PPTX.containsText;
import static com.qahelpers.pptxtest.PPTX.doesNotContainText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoesNotContainTextTests {

    @Test
    void canAssertThatPptxDoesNotContainText() throws IOException {
        PPTX pptx = new PPTX(getClass().getClassLoader().getResource("TestPPTX.pptx"));
        assertThat(pptx, doesNotContainText("this text is definitely not in the presentation"));
        assertThat(pptx, doesNotContainText("qwertyuiopasdfghjkl"));
    }

    @Test
    void assertionFailsWhenTextIsPresent() throws IOException {
        PPTX pptx = new PPTX(getClass().getClassLoader().getResource("TestPPTX.pptx"));
        assertThat(pptx, containsText("My pretty chart"));
        assertThrows(AssertionError.class, () -> assertThat(pptx, doesNotContainText("My pretty chart")));
    }
}
