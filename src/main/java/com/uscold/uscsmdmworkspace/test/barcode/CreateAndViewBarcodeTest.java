/**
 * Created by fwrmoral on 11/3/2017.
 */

package com.uscold.uscsmdmworkspace.test.barcode;

        import com.uscold.uscsmdmworkspace.test.AbstractTestClass;
        import com.uscold.uscsmdmworkspace.test.util.PageHelper;
        import org.junit.Assert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.annotations.Test;

        import java.util.List;


public class CreateAndViewBarcodeTest extends AbstractTestClass{

    private boolean succesfullyCreated;
    @Test
    public void createBarcodeTest() {

        PageHelper.chooseModule(driver, "Barcode Capture Maintenance");
        PageHelper.chooseWarehouse(driver, 160);
        PageHelper.waitForJSandJQueryToLoad(driver);

        click(driver.findElement(By.id("addNewRecord")));

        click(chooseValueFromBarcodePopUpHeaderCustomerDropDown("editCustomer_chosen", "107 - AMYS - PFD-1073/1182"));

        click(chooseValueFromBarcodePopUpHeaderLabelTypeDropDown("editLabelType_chosen", "Pallet Label"));

        click(chooseValueFromBarcodePopUpGridDataFieldDropDown("new_row2_dataFieldDesc_chosen", "Pallet Id"));



        driver.findElement(By.id("new_row2_length")).sendKeys("7");
        driver.findElement(By.id("new_row2_startPosition")).sendKeys("1");

        driver.findElement(By.id("jSaveButton_new_row2")).click();


        driver.findElement(By.id("saveNewTemplate")).click();

//        WebElement confAlert = driver.findElement(By.xpath("//img[contains(@src,'/ewm/images/ico_success.png')]"));

        click(chooseValueFromBarcodePopUpHeaderCustomerDropDown("cust_chosen", "107 - AMYS - PFD-1073/1182"));

        driver.findElement(By.id("basicSrch")).click();


//        public static WebElement waitForElementPresent(WebDriver driver, final By selector, int timeOutInSeconds) {
//        WebElement confAlert = driver.findElement(By.xpath("//img[contains(@src,'/ewm/images/ico_success.png')]"));
//
//        try{
//                WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
//            confAlert = wait.until(ExpectedConditions.presenceOfElementLocated(selector));
//
//                return confAlert;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return null;
//        }

//        String url = driver.getCurrentUrl();
//        if (!(confAlert.contains("product/productSearch?") && url.contains("hasSuccessMsg=true"))) {
//            try {
//                Assert.assertFalse(driver.findElement(By.id("prodCode.errors")).getText().toLowerCase().contains("duplicate"), "Product with this product code already exists. \n");
//            } catch (Exception ex) {
//            }
//            throw new RuntimeException("Can`t add this product code.");
//        }
//
//        createdSuccessfully = true;

        //*[@id="reportSuccessMsg"]/img


    }

    //Capture New field - Header - Data Field Dropdown
    private WebElement chooseValueFromBarcodeCustomerDropDown(String id, String value) {
        WebElement accTypeContainer = driver.findElement(By.id(id));
        WebElement aElem = accTypeContainer.findElement(By.cssSelector("a.chosen-single"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aElem);
        click(aElem);
        List<WebElement> accTypes = accTypeContainer.findElements(By.xpath("//div[@class='chosen-drop']/ul/li"));

        return accTypes.stream().filter(el -> el.getAttribute("innerText").trim().equalsIgnoreCase(value)).findFirst().get();


    }


    //Capture New field - Header - Data Field Dropdown
    private WebElement chooseValueFromBarcodePopUpHeaderCustomerDropDown(String id, String value) {
        WebElement accTypeContainer = driver.findElement(By.id(id));
        WebElement aElem = accTypeContainer.findElement(By.cssSelector("a.chosen-single"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aElem);
        click(aElem);
        List<WebElement> accTypes = accTypeContainer.findElements(By.xpath("//div[@class='chosen-drop']/ul/li"));

        return accTypes.stream().filter(el -> el.getAttribute("innerText").trim().equalsIgnoreCase(value)).findFirst().get();


    }

    //Capture New field - Header - Data Field Dropdown
    private WebElement chooseValueFromBarcodePopUpHeaderLabelTypeDropDown(String id, String value) {
        WebElement accTypeContainer = driver.findElement(By.id(id));
        WebElement aElem = accTypeContainer.findElement(By.cssSelector("a.chosen-single.chosen-default"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aElem);
        click(aElem);
        List<WebElement> accTypes = accTypeContainer.findElements(By.xpath("//div[@class='chosen-drop']/ul/li"));

        //*[@id="editLabelType_chosen"]/div
        return accTypes.stream().filter(el -> el.getAttribute("innerText").trim().equalsIgnoreCase(value)).findFirst().get();


    }


    //Capture New field - Grid - Data Field Dropdown
    private WebElement chooseValueFromBarcodePopUpGridDataFieldDropDown(String id, String value) {
        WebElement accTypeContainer = driver.findElement(By.id(id));
        WebElement aElem = accTypeContainer.findElement(By.cssSelector("a.chosen-single"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aElem);
        click(aElem);
        List<WebElement> accTypes = accTypeContainer.findElements(By.xpath("//div[@class='chosen-drop']/ul/li"));
//*[@id="new_row3_dataFieldDesc_chosen"]/a
        return accTypes.stream().filter(el -> el.getAttribute("innerText").trim().equalsIgnoreCase(value)).findFirst().get();


    }



}
