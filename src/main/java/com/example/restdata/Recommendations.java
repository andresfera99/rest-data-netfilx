package com.example.restdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/recommend")
public class Recommendations {
    @Autowired
    private TitleRepository titleRepository;

    @GetMapping("/best")
    List<Title> bestTitles(@RequestParam(value = "top", defaultValue = "10") int top) {
        top = sanitizeParam(top);
        return titleRepository.findAllByBestRating(top);
    }


    /**
     * This sanitizes the input of the top parameter, so we have no negatives, nor we request too many.
     * @param top Parameter to sanitize
     * @return It'll return top if it's between 1 and 500, or 10 if it's not within the range
     */
    private int sanitizeParam(int top) {
        if (top < 1 || top > 500)
            top = 10;
        return top;
    }
}
