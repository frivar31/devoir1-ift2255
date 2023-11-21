package Data.Entities.Products;

import java.util.Date;

public class Book extends Product {

    private String ISBN;
    private String author;
    private String editor;
    private String genre;
    private String pubDate;
    private long editorNum;
    private long volNum;

    public Book(String title,
                String desc,
                String category,
                String date,
                long initialQuantity,
                double price,
                long points,
                String ISBN,
                String author,
                String editor,
                String genre,
                String pubDate,
                long editorNum,
                long volNum
    ) {
        super(title, desc, category, date, initialQuantity, price, points);
        this.ISBN = ISBN;
        this.author = author;
        this.editor = editor;
        this.genre = genre;
        this.pubDate = pubDate;
        this.editorNum = editorNum;
        this.volNum = volNum;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public long getEditorNum() {
        return editorNum;
    }

    public void setEditorNum(long editorNum) {
        this.editorNum = editorNum;
    }

    public long getVolNum() {
        return volNum;
    }

    public void setVolNum(long volNum) {
        this.volNum = volNum;
    }

    public String toString() {
        return "{" +
                "\n- id='" + id + '\'' +
                "\n- titre='" + title + '\'' +
                "\n- description='" + desc + '\'' +
                "\n- categoryie='" + category + '\'' +
                "\n- date de mise en vente=" + date +
                "\n- quantite=" + quantity +
                "\n- price=" + (double)Math.round(price*100)/100+"$" +
                "\n- points=" + points +
                "\n- ISBN='" + ISBN + '\'' +
                "\n- auteur='" + author + '\'' +
                "\n- maision d'edition='" + editor + '\'' +
                "\n- genre='" + genre + '\'' +
                "\n- date de publication=" + pubDate +
                "\n- numero d'edition=" + editorNum +
                "\n- numero de volume=" + volNum +
                "\n}";
    }


}