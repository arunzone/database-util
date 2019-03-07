package me.arun;

import org.hamcrest.core.IsCollectionContaining;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertThat;

public class FileReaderTest
{
    @Test
    public void shouldReadFileContent() throws IOException {

        FileReader fileReader =  new FileReader();
        List<String> content = fileReader.readDirectory("./src/test/resources/");

        assertThat(content, IsCollectionContaining.hasItem( "select * from table;"));
    }
}
