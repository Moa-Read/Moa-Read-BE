package dongduk.cs.moaread.controller;

import dongduk.cs.moaread.service.NaverBookSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookSearchController {

    @Autowired
    private NaverBookSearchService naverBookSearchService;

    @GetMapping("/search")
    public String searchBooks(@RequestParam String query,
                              @RequestParam(defaultValue = "10") int display,
                              @RequestParam(defaultValue = "1") int start,
                              @RequestParam(defaultValue = "sim") String sort) {
        return naverBookSearchService.searchBooks(query, display, start, sort);
    }
}
