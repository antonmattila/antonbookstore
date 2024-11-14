package antonbookstore.antonbookstore.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @GetMapping("/index")
    public String index() {
        return "toimii";
    }
}
