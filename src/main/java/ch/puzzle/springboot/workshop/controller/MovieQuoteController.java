package ch.puzzle.springboot.workshop.controller;

import ch.puzzle.springboot.workshop.model.MovieQuote;
import ch.puzzle.springboot.workshop.model.MovieQuoteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Created by ktran on 8/30/16.
 */
@RestController
public class MovieQuoteController {
    private final Random random;
    private final MovieQuoteRepository repository;

    @Autowired
    public MovieQuoteController(MovieQuoteRepository repository) {
        this.repository = repository;
        this.random = new Random();
    }

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("MovieQuotes.json");
        List<MovieQuote> list = mapper.readValue(resource.getInputStream(), mapper.getTypeFactory().constructCollectionType(List.class, MovieQuote.class));
        repository.save(list);
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public Iterable<MovieQuote> quote() {
        return repository.findAll();
    }

    @RequestMapping(value = "/quote/random", method = RequestMethod.GET)
    public MovieQuote randomQuote() {
        return repository.findOne((long)random.nextInt((int)repository.count()+1));
    }

}
