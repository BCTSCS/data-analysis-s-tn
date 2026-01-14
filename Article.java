public class Article {
    private String link;
    private String headline;
    private String category;
    private String description;
    private String author;
    private String date;

    public Article(String link, String headline, String category, String description, String author, String date) {
        this.link = link;
        this.headline = headline;
        this.category = category;
        this.description = description;
        this.author = author;
        this.date = date;
    }

    public String toString() {
        return "";
    }

    public String getLink() {
        return link;
    }

    public String getHeadline() {
        return headline;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }
}