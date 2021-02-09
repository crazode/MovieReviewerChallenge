package modals;

public class Genre {
    private String genreName;

    private Genre(){

    }
    public Genre(String genreName) {
        this.genreName = genreName.toUpperCase();
    }

    public String getGenreName() {
        return genreName;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Genre genre = (Genre) o;
        return genre.getGenreName().equals(genreName) && this.hashCode() == genre.hashCode();

    }

    @Override
    public int hashCode() {
        return genreName.hashCode();
    }
}
