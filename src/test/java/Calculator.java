import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Calculator {

    private WindowsDriver calcsession = null;
    private WebElement calcresult = null;
    @BeforeClass
    public void setup()  {
        System.out.println("setup");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        try {
            calcsession = new WindowsDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addition(){

        calcsession.findElementByName("Nine").click();
        calcsession.findElementByName("Plus").click();

        calcsession.findElementByName("Eight").click();
        calcsession.findElementByName("Equals").click();

        Assert.assertEquals(getCalcResult(), "17");



    }
    public String getCalcResult(){
        String calcres = calcsession.findElementByAccessibilityId("CalculatorResults").getText();
        return calcres.replace("Display is", "").trim();

    }
    @Test
    public void multiplication(){

        calcsession.findElementByName("Nine").click();
        calcsession.findElementByName("Multiply by").click();

        calcsession.findElementByName("Two").click();
        calcsession.findElementByName("Equals").click();

        Assert.assertEquals(getCalcResult(), "18");

    }
    @Test
    public void subtraction(){

        System.out.println("subtraction");
        calcsession.findElementByName("Nine").click();
        calcsession.findElementByName("Minus").click();

        calcsession.findElementByName("Eight").click();
        calcsession.findElementByName("Equals").click();

        Assert.assertEquals(getCalcResult(), "1");
    }
    @Test
    public void division(){

        System.out.println("division");
        calcsession.findElementByName("Nine").click();
        calcsession.findElementByName("Divide by").click();

        calcsession.findElementByName("Three").click();
        calcsession.findElementByName("Equals").click();

        Assert.assertEquals(getCalcResult(), "3");
    }
    @AfterClass
    public void tearDown(){
        calcsession.quit();
    }

    public void ChooseCalculator(String locator){
        calcsession.findElementByAccessibilityId("TogglePaneButton").click();
        List<WebElement> allelements = calcsession.findElementsByClassName("Microsoft.UI.Xaml.Controls.NavigationViewItem");
        for(int i = 0 ; i< allelements.size(); i++){
            if(allelements.get(i).getAttribute("Name").equals(locator)){
                allelements.get(i).click();
                break;
            }

        }
    }
    public void ChooseCalculatorXpath(String locator){
        calcsession.findElementByAccessibilityId("TogglePaneButton").click();
        List<WebElement> allelements = calcsession.findElementsByXPath("//ListItem");
        for(int i = 0 ; i< allelements.size(); i++){
            if(allelements.get(i).getAttribute("Name").equals(locator)){
                allelements.get(i).click();
                break;
            }

        }
    }
    public void ChooseCalculatorXpathSimple(String locator){
        calcsession.findElementByAccessibilityId("TogglePaneButton").click();
        calcsession.findElementByXPath("//ListItem[contains(@Name,\""+ locator +"\")]").click();

    }
    ///ListItem[contains(@Name,\"Standard Calculator\")
    @Test
    public void SelectAnotherCalculator(){
       // ChooseCalculatorXpath("Standard Calculator");
        ChooseCalculatorXpathSimple("Standard Calculator");
       // ChooseCalculator("Scientific Calculator");

    }


}
