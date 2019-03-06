package me.arun;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.hamcrest.core.Is;
import org.junit.Test;

public class FileReaderTest
{
    @Test
    public void shouldReadFileContent()
    {

        FileReader fileReader =  new FileReader();
        String content = fileReader.read("test.sql");

        assertThat(content, is( "select * from table;"));
    }
}
