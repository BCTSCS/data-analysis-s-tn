import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ArticleAnalyzer {
    private ArrayList<String> stopWords;
    private ArrayList<Article> articles;

    public ArticleAnalyzer() {
        stopWords = new ArrayList<String>();
        articles = new ArrayList<Article>();
    }

    public void addStopWord(String word) {
        stopWords.add(word);
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    public Article parseJson(String jsonLine) {
        String link = "";
        String headline = "";
        String category = "";
        String description = "";
        String author = "";
        String date = "";

        Pattern pattern = Pattern.compile("\"(\\w+)\": \"([^\"]*)\"");
        Matcher matcher = pattern.matcher(jsonLine);

        while (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);

            if (key.equals("link")) link = value;
            else if (key.equals("headline")) headline = value;
            else if (key.equals("category")) category = value;
            else if (key.equals("short_description")) description = value;
            else if (key.equals("authors")) author = value;
            else if (key.equals("date")) date = value;
        }

        return new Article(link, headline, category, description, author, date);
    }

    public String removeStopWords(String text) {
        String[] words = text.split(" ");
        String result = "";
        for (String word : words) {
            if (!stopWords.contains(word.toLowerCase())) {
                result += word + " ";
            }
        }
        return result.trim();
    }

    public static void main(String[] args) {
        ArticleAnalyzer analyzer = new ArticleAnalyzer();

        ArrayList<String> stopWordsList = FileOperator.getStringList("stopwords.txt");
        for (String word : stopWordsList) {
            analyzer.addStopWord(word);
        }

        ArrayList<String> articleLines = FileOperator.getStringList("News_Category_Dataset_v3.json");
        for (String line : articleLines) {
            Article article = analyzer.parseJson(line);
            analyzer.addArticle(article);
        }

        for (Article article : analyzer.articles) {
            String cleanedDescription = analyzer.removeStopWords(article.getDescription());
            System.out.println("Headline: " + article.getHeadline());
            System.out.println("Description: " + cleanedDescription);
            System.out.println();
        }
    }
}
