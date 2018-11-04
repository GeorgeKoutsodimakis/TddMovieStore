import Movie.Movie;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;


class MovieStoreTest {

    private final MovieStore movieStore = new MovieStore();
    private final Movie starTrek = new Movie("STAR Trek", "Swimmer", 2009);
    private final Movie harryPotter = new Movie("Harry Potter", "Rowling", 2011);
    private final Movie starshipToorpers = new Movie(" starTrip troopers", "Swimmer", 2000);

    @BeforeEach
    void setUp() {
        movieStore.add(harryPotter);
        movieStore.add(starshipToorpers);
        movieStore.add(starTrek);
    }

    @Test
    public void returnNoTitlesWhenToTitlesPartiallyMatchSearch() throws Exception {
        MovieStore movieStore = new MovieStore();
        List<Movie> results = movieStore.findByPartialTitle("abs");
        assertThat(results.size(), is(0));
    }

    @Test
    public void findAmovieWhenTitlePartiallyMatched() throws Exception {
        List<Movie> results = movieStore.findByPartialTitle("arry");
        assertThat(results.size(), is(1));
        assertThat(results, contains(harryPotter));
    }

    @Test
    public void findMovieWhenTitlesArePartiallyMatchedCaseInsesitive() throws Exception {
        List<Movie> results = movieStore.findByPartialTitle("tar");
        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(starshipToorpers, starTrek));
    }

    @Test
    public void findMovieWhenDirectorAreExactlyMatches() throws Exception {
        List<Movie> results = movieStore.findByDirector("Swimmer");
        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(starshipToorpers, starTrek));
    }

    @Test
    public void findMoviesWhenRealeaseYearIsBetweenTwoValues() throws Exception {
        List<Movie> results = movieStore.findByReleaseYear(1999, 2010);
        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(starshipToorpers, starTrek));
    }



}