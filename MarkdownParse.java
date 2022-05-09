//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        ArrayList<String> input = new ArrayList<>(Arrays.asList(markdown.split("\n")));
        //System.out.println(input);
        
        for (int i=0;i<input.size();i++){
            int openBracket = input.get(i).indexOf("[");
            int closeBracket = input.get(i).indexOf("]");
            int openParen = input.get(i).indexOf("(");
            int closeParen = input.get(i).indexOf(")");
            if(openBracket!=-1&&closeBracket!=-1&&openParen!=-1&&closeParen!=-1){
                String temp= input.get(i).substring(openParen + 1, closeParen);
                toReturn.add(temp);
            }
        }
        /*This is the original markdownParse
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0; 
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            //if(openBracket == -1){
            //    break;
            //}
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            if(openBracket == -1){
                break;
            }
            int closeParen = markdown.indexOf(")", openParen);
            toReturn.add(markdown.substring(openParen+1, closeParen));
            currentIndex=closeParen+1;
        }*/
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
