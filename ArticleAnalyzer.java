
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ArticleAnalyzer {

    private ArrayList<String> stopWords; //load from FileOperators
    private ArrayList<Article> articles; //load from FileOperators json 
    private ArrayList<String> words; // sentiment words
    private ArrayList<Double> values; // sentiment values

    public ArticleAnalyzer(){
        stopWords=FileOperator.getStringList("stopwords.txt");
        System.out.println("Stop Word count"+stopWords.size());
        articles=new ArrayList<>();
        System.out.println("Articles count"+articles.size());
        words = new ArrayList<>();
        values = new ArrayList<>();



    }
    public static void main(String[] args) {
       ArticleAnalyzer riano = new ArticleAnalyzer();
       
       ArrayList<String> sentimentLines = FileOperator.getStringList("sentiments.txt");
       
       String regex = "([a-zA-Z0-9]+),(-?\\d+\\.?\\d*)";
       
       for (String text : sentimentLines) {
           Pattern l = Pattern.compile(regex);
           Matcher lm = l.matcher(text);
           boolean found = lm.find();
           String word = found ? lm.group(1) : "";
           Double value = found ? Double.parseDouble(lm.group(2)) : 0.0;
           
           if (found) {
               riano.words.add(word);
               riano.values.add(value);
           }
           
           System.out.println(word + "   ----  " + value);
       }
       
       System.out.println("\nTotal words loaded: " + riano.words.size());
       System.out.println("Total values loaded: " + riano.values.size());


    }

    public void addStopWord(String word){

    }

    public void addArticle(Article article){

    }

    public Article parseJson(String jsonLine){
 
        Article result;
        Pattern l = Pattern.compile("\"link\":\\s*\"([^\"]+)\""); 
        Matcher lm =l.matcher(jsonLine); 
         String lt = lm.find() ? lm.group(1) : ""; 
        result=new Article(lt, "", "", "", "","");

    return result;
}

 
    public String removeStopWords(String text){
        
        String result="";
  
       
        return result;


    } //remove stop words from Description


}
