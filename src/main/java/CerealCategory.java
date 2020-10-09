import java.util.Collection;

public class CerealCategory {
    private String category;
    private String categoryImage;
    private Collection<CerealReview> cereals;


    public CerealCategory(String category, String categoryImage, Collection<CerealReview> cereals) {
        this.category = category;
        this.categoryImage = categoryImage;
        this.cereals = cereals;
    }

    public String getCategory() {
        return category;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public Collection<CerealReview> getCereals() {
        return cereals;
    }
}
