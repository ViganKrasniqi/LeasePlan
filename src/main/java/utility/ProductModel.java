package utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@AllArgsConstructor
//@NoArgsConstructor
@Data
public class ProductModel {

    String image;
    String unit;
    String provider;
    Object price;
    String title;
    String promoDetails;
    String brand;
    boolean isPromo;
    String url;


    public static boolean CheckALlNullValues(ProductModel product) {
        return product.getBrand() != null &&
                product.getProvider() != null &&
                product.getPrice() != null &&
                product.getTitle() != null &&
                product.getPromoDetails() != null &&
                product.getImage() != null &&
                product.getUnit() != null &&
                product.getUrl() != null;
    }
}
