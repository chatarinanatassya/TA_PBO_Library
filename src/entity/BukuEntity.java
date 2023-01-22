package entity;

public class BukuEntity {
    String idbuku,judul,author,genre;

    public BukuEntity(String idbuku, String judul, String author, String genre) {
        this.idbuku = idbuku;
        this.judul = judul;
        this.author = author;
        this.genre = genre;
    }

    public String getIdbuku() {
        return idbuku;
    }

    public String getJudul() {
        return judul;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public void setIdbuku(String idbuku) {
        this.idbuku = idbuku;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
