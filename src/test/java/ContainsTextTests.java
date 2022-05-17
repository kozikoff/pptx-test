import com.qahelpers.pptxtest.PPTX;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.qahelpers.pptxtest.PPTX.containsText;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContainsTextTests {

    @Test
    void canAssertThatPptxContainsText() throws IOException {
        PPTX pptx = new PPTX(getClass().getClassLoader().getResource("TestPPTX.pptx"));
        assertThat(pptx, containsText("lacinia nisi. Ut ac dolor vitae odio"));
        assertThat(pptx, containsText("My pretty chart"));
        assertThat(pptx, containsText("37.12%"));
        assertThat(pptx, containsText("Beehive State (official), The Mormon State"));
    }
}
