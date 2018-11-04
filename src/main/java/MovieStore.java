import Movie.Movie;

import java.util.LinkedList;
import java.util.List;

public class MovieStore {
    List<Movie> movies = new LinkedList();


    public List<Movie> findByPartialTitle(final String partialTitle) {
        Predicate predicate = new Predicate() {
            public boolean matches(Movie movie) {
                return movie.title().toUpperCase().contains(partialTitle.toUpperCase());
            }
        };
        return findBy(predicate);
    }


    public void add(Movie title) {
        movies.add(title);
    }

    public List<Movie> findByDirector(final String director) {
        Predicate predicate = new Predicate() {
            public boolean matches(Movie movie) {
                return movie.director().equals(director);
            }
        };
        return findBy(predicate);
    }

    public List<Movie> findByReleaseYear(final int from, final int to) {
        Predicate predicate = new Predicate() {
            public boolean matches(Movie movie) {
                return movie.year() > from && movie.year() < to;
            }
        };
        return findBy(predicate);
    }

    public List<Movie> findBy(Predicate predicate) {
        List<Movie> result = new LinkedList<Movie>();
        for (Movie movie : movies) {
            if (predicate.matches(movie)) {
                result.add(movie);
            }
        }
        return result;
    }
}

