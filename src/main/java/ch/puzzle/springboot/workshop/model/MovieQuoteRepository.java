package ch.puzzle.springboot.workshop.model;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by ktran on 8/31/16.
 */
public interface MovieQuoteRepository extends CrudRepository<MovieQuote, Long> {

}
