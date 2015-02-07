package com.sck2.files;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

/**
 * @author newlight77@gmail.com
 */
public class testReadFileToString {

    /**
     * The content of the file-to-string.txt: "File to string example"
     */
    private static final String FILE_PATH = "file-to-string.txt";
    private URI fileLocation;

    /**
     * This is the content of the file-to-string.txt file.
     */
    @Before public void setUp() throws URISyntaxException {
        fileLocation = this.getClass().getClassLoader().getResource(FILE_PATH).toURI();
    }

    @Test public void usingBufferedReader() throws IOException {
        File file = new File(fileLocation);
        assertEquals("File to string example", FileToString.usingBufferedReader(file));
    }

    @Test public void usingScanner() throws FileNotFoundException {
        File file = new File(fileLocation);
        assertEquals("File to string example", FileToString.usingScanner(file));
    }

    @Test public void usingNioFilesReadAllLines() throws IOException {
        Path path = Paths.get(fileLocation);
        assertEquals("File to string example", FileToString.usingNioFilesReadAllLines(path));
    }

    @Test public void usingNioFilesReadBytes() throws IOException {
        Path path = Paths.get(fileLocation);
        assertEquals("File to string example\n", FileToString.usingNioFilesReadBytes(path));
    }

    @Test public void usingNioFilesWithCollectors() throws IOException {
        Path path = Paths.get(fileLocation);
        assertEquals("File to string example", FileToString.usingNioFilesWithCollectors(path));
    }

    @Test public void usingNioFilesWithCollectorsAndLambdaWithinTryBlock() throws IOException {
        Path path = Paths.get(fileLocation);
        assertEquals("File to string example",
            FileToString.usingNioFilesWithCollectorsAndLambdaWithinTryBlock(path));
    }

    @Test public void usingNioFilesWithFilteringAndLambda() throws IOException {
        Path path = Paths.get(fileLocation);
        assertEquals("File to string example",
            FileToString.usingNioFilesWithFilteringAndLambda(path));
    }

    @Test public void usingGuava() throws IOException {
        File file = new File(fileLocation);
        assertEquals("File to string example\n", FileToString.usingGuava(file));
    }

    @Test public void usingApacheCommonsIo() throws IOException {
        File file = new File(fileLocation);
        assertEquals("File to string example\n", FileToString.usingApacheCommonsIo(file));
    }
}

