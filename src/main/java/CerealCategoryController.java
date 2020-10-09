import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CerealCategoryController {
    Map<Long,CerealCategory> categoryList = new HashMap<>();

    public CerealCategoryController () {

        Collection<CerealReview> healthyList = new ArrayList<>();
        Collection<CerealReview> sugarList = new ArrayList<>();

        CerealCategory healthy = new CerealCategory("Healthy", "/images/rice-chex-box1.png", healthyList);
        CerealCategory sugar = new CerealCategory("Sugary", "/images/AppleJacks1.png", sugarList);


    }
}
