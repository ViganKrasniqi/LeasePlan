package starter;

import net.serenitybdd.rest.SerenityRest;

public class Responses {

    public void getProductModel(String url) {
        SerenityRest.given().get(url);
    }
}