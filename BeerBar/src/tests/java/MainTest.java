package java;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MainTest {

    @Test
    public void shouldTest() {
        Assert.assertEquals("Hello", "Hello");
    }
}

