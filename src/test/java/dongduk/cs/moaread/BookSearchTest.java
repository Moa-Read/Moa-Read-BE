package dongduk.cs.moaread;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dongduk.cs.moaread.service.NaverBookSearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BookSearchTest {

    @Autowired
    private NaverBookSearchService naverBookSearchService;

    @Test
    public void testSearchBooks() {
        String result = naverBookSearchService.searchBooks("파이썬", 10, 1, "sim");
        assertNotNull(result);

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(result);
            JsonNode items = root.path("items");

            for (JsonNode item : items) {
                String title = item.path("title").asText();
                String author = item.path("author").asText();
                System.out.println("Title: " + title + ", Author: " + author);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
