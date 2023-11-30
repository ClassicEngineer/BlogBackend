package ru.ddev.blog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ddev.blog.post.domain.MarkdownHeader;

@ExtendWith(MockitoExtension.class)
public class MarkdownHeaderTest {


    @Test
    public void shouldCorrectlyParseSimpleHeader() throws Exception {
        String header = """
                ---
                title: "Back vs Front"
                date: 2023-11-26T19:44:49+03:00
                image: "back_VS_front.jpg"
                draft: false
                tags:
                  - tagA
                ---
                """;

        var extracted = MarkdownHeader.extract(header);

        Assertions.assertEquals("Back vs Front", extracted.getTitle());
        Assertions.assertEquals("back_VS_front.jpg", extracted.getImage());
        Assertions.assertEquals("tagA", extracted.getTags().get(0));
    }


}
