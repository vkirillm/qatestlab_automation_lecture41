package myprojects.automation.assignment4;


import myprojects.automation.assignment4.model.ProductData;
import myprojects.automation.assignment4.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        // TODO implement logging in to Admin Panel
        By emailInput = By.id("email");
        By passwordInput = By.id("passwd");
        By loginBtn = By.name("submitLogin");


        driver.get(Properties.getBaseAdminUrl());
        wait.until(ExpectedConditions. elementToBeClickable(emailInput));
        driver.findElement(emailInput).sendKeys(login);
        wait.until(ExpectedConditions. elementToBeClickable(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);
        wait.until(ExpectedConditions. elementToBeClickable(loginBtn));
        driver.findElement(loginBtn).click();
        //throw new UnsupportedOperationException();
    }

    public void createProduct(ProductData newProduct) {
        // TODO implement product creation scenario
        //part A
        By menuItemCatalog = By.cssSelector("li#subtab-AdminCatalog > a:nth-child(1)");
        By menuItemCategories = By.cssSelector("li[id^='subtab-AdminProducts'] > a");

        By newGoodsBtn = By.cssSelector("#page-header-desc-configuration-add");

        By nameInput = By.cssSelector("#form_step1_name_1");
        By amoutInput = By.cssSelector("#form_step1_qty_0_shortcut");
        By priceInput = By.cssSelector("#form_step1_price_shortcut");

        By saveBtn = By.cssSelector("button.js-btn-save");

        By closeBtn = By.cssSelector("div.growl-close");


        wait.until(ExpectedConditions. elementToBeClickable(menuItemCatalog));
        Actions actions = new Actions(driver);
        WebElement elem = driver.findElement(menuItemCatalog);
        actions.moveToElement(elem).perform();
        wait.until(ExpectedConditions. elementToBeClickable(menuItemCategories));
        driver.findElement(menuItemCategories).click();

        wait.until(ExpectedConditions. elementToBeClickable(newGoodsBtn));
        driver.findElement(newGoodsBtn).click();


        wait.until(ExpectedConditions. elementToBeClickable(nameInput));
        driver.findElement(nameInput).sendKeys(newProduct.getName());
        wait.until(ExpectedConditions. elementToBeClickable(amoutInput));
        driver.findElement(amoutInput).sendKeys(newProduct.getQty()+"");
        wait.until(ExpectedConditions. elementToBeClickable(priceInput));
        driver.findElement(priceInput).sendKeys(newProduct.getPrice());

        wait.until(ExpectedConditions. elementToBeClickable(saveBtn));
        driver.findElement(saveBtn).click();

        wait.until(ExpectedConditions. elementToBeClickable(closeBtn));
        driver.findElement(closeBtn).click();
/*
        //part B
        driver.get(Properties.getBaseUrl());
        By allGoodsLink = By.cssSelector(".all-product-link");
        wait.until(ExpectedConditions. elementToBeClickable(allGoodsLink));
        driver.findElement(allGoodsLink).click();

        By goods = By.cssSelector("h1.h3 product-title > a:contains('"+newProduct.getName()+"')");
        wait.until(ExpectedConditions. elementToBeClickable(goods));
        driver.findElement(goods).click();

        By nameGoods = By.cssSelector("h1.h1");
        Assert.assertEquals(driver.findElement(nameGoods).getText(),newProduct.getName(),"False1");
        By priceGoods = By.cssSelector("div.current-price > span");
        Assert.assertEquals(driver.findElement(nameGoods).getText(),newProduct.getName(),"False2");
*/
        //throw new UnsupportedOperationException();
    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
        // TODO implement generic method to wait until page content is loaded

        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXPath)));
        // ...
    }
}
