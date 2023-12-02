package ru.ddev.blog.post.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import ru.ddev.blog.post.api.view.BlogPostView;
import ru.ddev.blog.post.application.SearchApplicationService;

import java.util.Collection;

@Log
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/search")
public class RestApiSearchController {

    private final SearchApplicationService searchApplicationService;

    @GetMapping("")
    public Collection<BlogPostView> search(@RequestParam(value = "input") String input,
                                           @RequestParam(value = "limit", required = false) Integer limit) {
        log.info("Get search request with input - " + input + " and limit - " + limit);
        return searchApplicationService.searchByInput(input);
    }

}
