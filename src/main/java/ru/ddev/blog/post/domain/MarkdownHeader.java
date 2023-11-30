package ru.ddev.blog.post.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.ddev.blog.post.domain.exception.IncorrectHeaderException;

import java.util.Arrays;
import java.util.List;

/*
Header should have this structure
---
title: "Title"
date: Thu Nov 30 2023
image: "image.jpg"
draft: false
tags:
   - tagA
---
 */
@Data
@Builder
@AllArgsConstructor
public class MarkdownHeader {

    private String raw;
    private String title;
    private String date;
    private String image;
    private Boolean isDraft;
    private List<String> tags;


    public static MarkdownHeader extract(String content) throws IncorrectHeaderException {
        try {
            String[] parts = content.split("---");
            String headerContent = parts[1];
            String[] keysAndValues = headerContent.split("\n");
            String title = getValue(keysAndValues[1]);
            String date = getValue(keysAndValues[2]);
            String image = getValue(keysAndValues[3]);
            Boolean draft = Boolean.getBoolean(getValue(keysAndValues[4]));
            List<String> tags = getTags(headerContent);
            return MarkdownHeader.builder()
                    .raw("---\n" + headerContent + "---\n")
                    .title(title)
                    .date(date)
                    .image(image)
                    .isDraft(draft)
                    .tags(tags)
                    .build();
        } catch (Exception e) {
            throw new IncorrectHeaderException(e);
        }
    }

    private static List<String> getTags(String header) {
        var list = Arrays.stream(header.split("tags:")[1]
                .split("\n"))
                .map(str -> str.replaceAll(" ", "").replaceAll("-", ""))
                .toList();
        return list.subList(1, list.size());
    }

    /**
     *
     * @param keyAndValue in format <key: "value">
     * @return key
     */
    private static String getValue(String keyAndValue) {
        return keyAndValue.split(":")[1].trim().replaceAll("\"", "");
    }
}
