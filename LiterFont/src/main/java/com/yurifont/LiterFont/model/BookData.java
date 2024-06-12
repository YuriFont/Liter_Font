package com.yurifont.LiterFont.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(String title, AuthorData authors, String[] languages, Integer download_count) {
    @Override
    public String toString() {
        return "\n***** BOOK *****\n"
                + "Title - " + this.title + "\n"
                + "Language - " + Arrays.toString(this.languages) + "\n"
                + "Downloads count - " + this.download_count + "\n";
    }
}
