package com.yurifont.LiterFont.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(String title, List<AuthorData> authors, String[] languages, Integer download_count) {
    @Override
    public String toString() {
        return "\n***** BOOK *****\n"
                + "Title - " + this.title + "\n"
                + "Language - " + Arrays.toString(this.languages) + "\n"
                + "Author - " + authors.get(0).name() + "\n"
                + "Downloads count - " + this.download_count + "\n";
    }
}
