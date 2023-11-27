package ru.ddev.blog.properties.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ddev.blog.properties.api.view.BlogPostPropertiesView;

@RestController
@RequestMapping("/api/v1/properties")
public class RestApiBlogProperties {

    @GetMapping("")
    public BlogPostPropertiesView getProperties() {
        return BlogPostPropertiesView.defaultProperties();
    }

    @GetMapping("blogName")
    public String getBlogName() {
        return "Developer's Blog";
    }
}
