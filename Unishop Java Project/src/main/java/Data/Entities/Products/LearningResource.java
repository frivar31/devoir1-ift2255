package Data.Entities.Products;

import Data.Entities.Type;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LearningResource extends Product {

    private String author;
    private String organisation;
    private String publishDate;
    private Type type;
    private Long editionNumber;
    private String ISBN;


    @JsonCreator
    public LearningResource(@JsonProperty("title") String title,
                            @JsonProperty("desc") String desc,
                            @JsonProperty("category") ProductType category,
                            @JsonProperty("date") String date,
                            @JsonProperty("initialQuantity") long initialQuantity,
                            @JsonProperty("price") double price,
                            @JsonProperty("points") long points,
                            @JsonProperty("ISBN") String ISBN,
                            @JsonProperty("author") String author,
                            @JsonProperty("organisation") String organisation,
                            @JsonProperty("publishDate") String publishDate,
                            @JsonProperty("type") Type type,
                            @JsonProperty("editionNumber") Long editionNumber) {
        super(title, desc, date, initialQuantity, price, points);
        this.ISBN = ISBN;
        this.author = author;
        this.organisation = organisation;
        this.publishDate = publishDate;
        this.type = type;
        this.editionNumber = editionNumber;
        this.category = category ;
    }

    public String getauthor() {
        return author;
    }

    public void setAuteur(String auteur) {
        this.author = auteur;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(Long editionNumber) {
        this.editionNumber = editionNumber;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String toString() {
        return "{" +
                "\n- id='" + id + '\'' +
                "\n- titre='" + title + '\'' +
                "\n- description='" + desc + '\'' +
                "\n- categorie='" + category + '\'' +
                "\n- date de mise en vente=" + date +
                "\n- quantite=" + quantity +
                "\n- price=" + (double) Math.round(price * 100) / 100 + "$" +
                "\n- points=" + points +
                "\n- ISBN='" + ISBN + '\'' +
                "\n- auteur='" + author + '\'' +
                "\n- organisation ='" + organisation + '\'' +
                //"\n- genre='" + genre + '\'' +
                "\n- date de publication =" + publishDate +
                "\n- numero d'edition =" + editionNumber +
                "\n}";
    }
}
