import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;

import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void test1() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> expected=new ArrayList<>();
        expected.add("https://something.com");
        expected.add("some-thing.html");
        assertEquals(expected,
        MarkdownParse.getLinks(content));
    }
    @Test
    public void snippet1() throws IOException{
        Path fileName = Path.of("Snippet1.md");
        String content = Files.readString(fileName);
        List<String> expected=List.of("`google.com", "google.com", "ucsd.edu");
        System.out.println(expected);
        assertEquals(expected,
        MarkdownParse.getLinks(content));
    }
    @Test
    public void snippet2() throws IOException{
        Path fileName = Path.of("Snippet2.md");
        String content = Files.readString(fileName);
        List<String> expected=List.of("a.com", "a.com(())", "example.com");
        System.out.println(expected);
        assertEquals(expected,
        MarkdownParse.getLinks(content));
    }
    @Test
    public void snippet3() throws IOException{
        Path fileName = Path.of("Snippet3.md");
        String content = Files.readString(fileName);
        List<String> expected=List.of("https://www.twitter.com", 
        "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule", 
        "https://cse.ucsd.edu/, https://cse.ucsd.edu/");
        System.out.println(expected);
        assertEquals(expected,
        MarkdownParse.getLinks(content));
    }
}
