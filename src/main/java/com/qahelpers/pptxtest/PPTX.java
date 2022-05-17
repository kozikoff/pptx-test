package com.qahelpers.pptxtest;

import com.qahelpers.pptxtest.matchers.ContainsText;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.hamcrest.Matcher;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import static com.qahelpers.pptxtest.IO.readBytes;
import static com.qahelpers.pptxtest.IO.readFile;

public class PPTX {
    public final String name;
    public final XMLSlideShow powerpoint;

    public PPTX(String name, byte[] content) {
        this.name = name;
        try (InputStream inputStream = new ByteArrayInputStream(content)){
            powerpoint = new XMLSlideShow(inputStream);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Invalid PPTX " + name, e);
        }
    }

    public PPTX(File pptxFile) {
        this(pptxFile.getAbsolutePath(), readFile(pptxFile));
    }

    public PPTX(URL url) throws IOException {
        this(url.toString(), readBytes(url));
    }

    public PPTX(URI uri) throws IOException {
        this(uri.toURL());
    }

    public PPTX(byte[] content) {
        this("", content);
    }

    public PPTX(InputStream inputStream) throws IOException {
        this(readBytes(inputStream));
    }

    public static Matcher<PPTX> containsText(String text) {
        return new ContainsText(text);
    }
}
