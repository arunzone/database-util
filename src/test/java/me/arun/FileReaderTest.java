package me.arun;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.io.IOException;

public class FileReaderTest
{
    @Test
    public void shouldReadFileContent() throws IOException {

        FileReader fileReader =  new FileReader();
        String content = fileReader.read("./src/test/resources/test.sql");

        assertThat(content, is( "select * from table;"));
    }
}
