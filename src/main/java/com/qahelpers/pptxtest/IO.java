package com.qahelpers.pptxtest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IO {
    static byte[] readBytes(URL url) throws IOException {
        try (InputStream inputStream = url.openStream()) {
            return readBytes(inputStream);
        }
    }

    static byte[] readBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[2048];

        int nRead;
        while ((nRead = inputStream.read(buffer, 0, buffer.length)) != -1) {
            result.write(buffer, 0, nRead);
        }

        return result.toByteArray();
    }

    static byte[] readFile(File pptxFile) {
        try {
            return Files.readAllBytes(Paths.get(pptxFile.getAbsolutePath()));
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to read PPTX file " + pptxFile, e);
        }
    }
}
