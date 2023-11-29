package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

public class Electronics extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {

        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //1.3 Verify the text “Cell phones”
        verifyElements("error", "Cell phones", By.xpath("//h1[normalize-space()='Cell phones']"));

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

        //2.2 Mouse Hover on “Cell phones” and click
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //2.3 Verify the text “Cell phones”
        verifyElements("error", "Cell phones", By.xpath("//h1[normalize-space()='Cell phones']"));

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));

        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//a[normalize-space()='Nokia Lumia 1020']"));

        //2.6 Verify the text “Nokia Lumia 1020”
        verifyElements("error", "Nokia Lumia 1020", By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"));

        //2.7 Verify the price “$349.00”
        verifyElements("error", " $349.00 ", By.xpath("//span[@id='price-value-20']"));

        //2.8 Change quantity to 2
        sendTextToElement(By.id("product_enteredQuantity_20"), Keys.BACK_SPACE + "2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.id("add-to-cart-button-20"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        verifyElements("error", "The product has been added to your shopping cart", By.xpath("//p[@class='content']"));
        clickOnElement(By.xpath("//span[@title='Close']"));
        Thread.sleep(1000);

        //2.12 Verify the message "Shopping cart"
        verifyElements("error", "Shopping cart", By.xpath("//h1[normalize-space()='Shopping cart']"));

        //2.13 Verify the quantity is 2
        verifyElements("error", "2", By.id("itemquantity11237"));

        //2.14 Verify the Total $698.00
        verifyElements("error", "$698.00", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("//input[@id='termsofservice']"));

        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        verifyElements("error", "Welcome, Please Sign In!", By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));

        //2.19 Verify the text “Register”
        verifyElements("error", "Register", By.xpath("//h1[normalize-space()='Register']"));

        //2.20 Fill the mandatory fields
        clickOnElement(By.id("gender-male"));
        sendTextToElement(By.id("FirstName"), "Danny");
        sendTextToElement(By.id("LastName"), "Daniels");
        selectByValueFromDropDown(By.name("DateOfBirthDay"), "01");
        selectByValueFromDropDown(By.name("DateOfBirthMonth"), "09");
        selectByValueFromDropDown(By.name("DateOfBirthYear"), "1996");
        sendTextToElement(By.id("Email"), "dannydaniels100@gmail.com");
        sendTextToElement(By.id("Password"), "dd@123");
        sendTextToElement(By.id("ConfirmPassword"), "dd@123");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));

        //2.22 Verify the message “Your registration completed”
        verifyElements("error", "Your registration completed", By.xpath("//div[@class='result']"));

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        //2.24 Verify the text “Shopping card”
        verifyElements("error", "Shopping cart", By.xpath("//h1[normalize-space()='Shopping cart']"));

        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("checkout"));

        //2.27 Fill the Mandatory fields
        selectByVisibleTextFromDropdown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "123 High Street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "EC157YN");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "1234567");

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropdown(By.id("CreditCardType"), "Visa");

        //2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Danny Daniels");
        sendTextToElement(By.id("CardNumber"), "5356 6548 1418 5420");
        selectByVisibleTextFromDropdown(By.id("ExpireMonth"), "12");
        selectByVisibleTextFromDropdown(By.id("ExpireYear"), "2025");
        sendTextToElement(By.id("CardCode"), "123");

        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.35 Verify “Payment Method” is “Credit Card”
        verifyElements("error", "Payment Method:", By.xpath("//span[contains(text(),'Payment Method:')]"));

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyElements("error", "Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"));
        verifyElements("error", "Shipping Method:", By.xpath("//span[contains(text(),'Shipping Method:')]"));
        verifyElements("error", "2nd Day Air", By.xpath("//span[contains(.,'2nd Day Air')]"));

        //2.37 Verify Total is “$698.00”
        verifyElements("error", "$698.00", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));

        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.39 Verify the Text “Thank You”
        verifyElements("error", "Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));

        //2.40 Verify the message “Your order has been successfully processed!”
        verifyElements("error", "Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.42 Verify the text “Welcome to our store”
        verifyElements("error", "Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"));

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://demo.nopcommerce.com/");
    }

    @After
    public void tearDown() {

        closeBrowser();
    }


}










