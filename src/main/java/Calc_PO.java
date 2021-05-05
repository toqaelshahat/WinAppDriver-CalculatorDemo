import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;

public class Calc_PO {
    private WindowsDriver driver=null;
    public Calc_PO(WindowsDriver wd){
        driver= wd;

    }

    public WebElement One(){
        return driver.findElementByName("One");
    }

    public WebElement Two(){
        return driver.findElementByName("Two");
    }

    public WebElement Three(){
        return driver.findElementByName("Three");
    }

    public WebElement Four(){
        return driver.findElementByName("Four");
    }
    public WebElement Eight(){
        return driver.findElementByName("Eight");
    }
    public WebElement Nine(){
        return driver.findElementByName("Nine");
    }

    public WebElement Plus(){
        return driver.findElementByName("Plus");
    }

    public WebElement Equals(){
        return driver.findElementByName("Equals");
    }
    public WebElement Multiply(){
       return driver.findElementByName("Multiply by");
    }
    public WebElement AppName(){
        return driver.findElementByAccessibilityId("AppName");
    }
    public String getCalcResult(){
        String calcres = driver.findElementByAccessibilityId("CalculatorResults").getText();
        return calcres.replace("Display is", "").trim();

    }
}

