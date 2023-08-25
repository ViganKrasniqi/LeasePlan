package starter.stepdefinitions;

import com.google.gson.GsonBuilder;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import starter.Responses;
import utility.Detail;
import utility.ProductErrorModel;
import utility.ProductModel;

import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class SearchStepDefinitions {

    private List<ProductModel> productModelList;
    private ProductErrorModel productErrorModel;
    @Steps
    private Responses responses;


    @When("he calls endpoint {string}")
    public void heCallsEndpoint(String url) {
        responses.getProductModel(url);
    }

    @Then("he sees the results displayed for product")
    public void heSeesTheResultsDisplayedForProduct() {

        ProductModel[] tempProductList = new GsonBuilder().create().fromJson(SerenityRest.lastResponse().body().prettyPrint(), ProductModel[].class);
        productModelList = Arrays.asList(tempProductList);
        Assert.assertTrue(productModelList.stream().allMatch(ProductModel::CheckALlNullValues));
    }

    @Then("he should get the {int} status code")
    public void heShouldGetTheStatusCode(int arg0) {
        restAssuredThat(response -> response.statusCode(arg0));
    }

    @Then("he doesn't see the results of {string}")
    public void heDoesnTSeeTheResultsOf(String missing_product) {

        productErrorModel = new GsonBuilder().create().fromJson(SerenityRest.lastResponse().body().prettyPrint(), ProductErrorModel.class);
        Assert.assertTrue(Detail.validateProperErrorStructure(productErrorModel.getDetail(), missing_product));
    }
}
