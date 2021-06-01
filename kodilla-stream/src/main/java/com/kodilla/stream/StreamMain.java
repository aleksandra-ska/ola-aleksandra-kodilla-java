package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;

import java.io.PipedOutputStream;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String text1 = poemBeautifier.beautify("Beautifier text task",(text -> text.toUpperCase()));
        System.out.println(text1);

        String text2 = poemBeautifier.beautify("Beautifier text task",(text -> text.toLowerCase()));
        System.out.println(text2);

        String text3 = poemBeautifier.beautify("Beautifier text task",(text -> "ABC" + text + "ABC"));
        System.out.println(text3);

        String text4 = poemBeautifier.beautify("Beautifier text task",(text -> "/" + text + "/"));
        System.out.println(text4);

        String text5 = poemBeautifier.beautify("Beautifier text task",(text -> text.substring(11, 16)));
        System.out.println(text5);

        String text6 = poemBeautifier.beautify("Beautifier text task",(text -> text + "."));
        System.out.println(text6);

    }
}
