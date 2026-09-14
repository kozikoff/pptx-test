# PPTX Test

PowerPoint testing library

Make sure your code always generates correct and valid PPTX files (from PowerPoint 2007 version and later)!

## How to use
Just add assertThat from Hamcrest and enjoy ))

### containsText matcher

```java
import PPTX;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static PPTX.containsText;
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
```

### doesNotContainText matcher

```java
import PPTX;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static PPTX.doesNotContainText;
import static org.hamcrest.MatcherAssert.assertThat;

public class DoesNotContainTextTests {

    @Test
    void canAssertThatPptxDoesNotContainText() throws IOException {
        PPTX pptx = new PPTX(getClass().getClassLoader().getResource("TestPPTX.pptx"));
        assertThat(pptx, doesNotContainText("Confidential information"));
        assertThat(pptx, doesNotContainText("Debug text"));
        assertThat(pptx, doesNotContainText("TODO: fix this"));
    }
}
```

### hasSlideCount matcher

```java
import PPTX;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static PPTX.hasSlideCount;
import static org.hamcrest.MatcherAssert.assertThat;

public class HasSlideCountTests {

    @Test
    void canAssertThatPptxHasExpectedNumberOfSlides() throws IOException {
        PPTX pptx = new PPTX(getClass().getClassLoader().getResource("TestPPTX.pptx"));
        assertThat(pptx, hasSlideCount(10));
    }
}
```

## How to add

Just copy jar-file into ```lib``` directory of your project and make import in IntelliJ IDEA (Project structure - Modules - Dependencies). 
If you use **Gradle**, please add the following dependency to build.gradle:

```groovy
dependencies {
    testImplementation files('lib/pptx-test.jar')
}
```

# Thanks

Many thanks to [Andrei Solntsev](https://github.com/asolntsev) and his
project [xls-test](https://github.com/codeborne/xls-test) for the inspiration.

# License

pptx-test is open-source project and distributed under [MIT](http://choosealicense.com/licenses/mit/) license
