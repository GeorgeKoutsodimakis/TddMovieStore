package Movie;

public class Movie {
    private String title;
    private String director;
    private int date;

    public Movie(String title, String director, int date) {
        this.title = title;
        this.director = director;
        this.date = date;
    }

    public String title() {
        return title;
    }

    public String director() {
        return director;
    }
    public int year(){
        return date;
    }
}
