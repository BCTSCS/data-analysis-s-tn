
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReviewCollector {
    private ArrayList<ProductReview> reviewList;
    private ArrayList<String> productList;
    public ReviewCollector() {
        reviewList = new ArrayList<>();
        productList = new ArrayList<>();
    }
    public void addReview(ProductReview prodReview) {
        reviewList.add(prodReview);
        
        String productName = prodReview.getName();
        
        boolean found = false;
        for (String product : productList) {
            if (product.equals(productName)) {
                found = true;
                break;
            }
        }
        
        if (!found) {
            productList.add(productName);
        }
        
        System.out.println("Review list size: " + reviewList.size());
    }
    public int getNumGoodReviews(String prodName) {
        int count = 0;
        for (ProductReview review : reviewList) {
            if (review.getName().equals(prodName) && review.getReview().contains("best")) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {

        ReviewCollector reviewCollector = new ReviewCollector();
        ArrayList<String> lines = FileOperator.getStringList("reviews.txt");
        Pattern productPattern = Pattern.compile("Product:\\s*(.+)");
        Pattern reviewPattern = Pattern.compile("Review:\\s*(.+)");

        String productName = null;
        String review = null;
        for (String line : lines) {
            Matcher productMatcher = productPattern.matcher(line);
            Matcher reviewMatcher = reviewPattern.matcher(line);

            if (productMatcher.find()) {
                productName = productMatcher.group(1);
            } else if (reviewMatcher.find()) {
                review = reviewMatcher.group(1);

            }
            if (productName != null && review != null) {
                ProductReview product = new ProductReview(productName, review);
                reviewCollector.addReview(product);
                System.out.println(product);
                productName = null;
                review = null;
            }
        }
    }
}
