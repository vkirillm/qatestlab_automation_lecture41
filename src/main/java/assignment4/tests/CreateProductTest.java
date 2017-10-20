package myprojects.automation.assignment4.tests;

import myprojects.automation.assignment4.BaseTest;
import myprojects.automation.assignment4.model.ProductData;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateProductTest extends BaseTest {

    @Parameters({"login","password"})
    @Test
    public void createNewProduct(String login, String password) {
        // TODO implement test for product creation
        actions.login(login, password);
        actions.createProduct(ProductData.generate());

        // actions.login(login, password);
        // ...
    }

    // TODO implement logic to check product visibility on website
}
