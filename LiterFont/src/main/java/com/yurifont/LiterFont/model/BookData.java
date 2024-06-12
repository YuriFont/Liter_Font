package com.yurifont.LiterFont.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(String title, List<AuthorData> authors, String[] languages, Integer download_count) {
}
