import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Calculator_PO {

    private WindowsDriver calcsession = null;
    private WebElement calcresult = null;
    private Calc_PO cpo=null;
    @BeforeClass
    public void asetup()  {
        System.out.println("setup");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        try {
            calcsession = new WindowsDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            cpo = new Calc_PO(calcsession);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addition(){
        cpo.Nine().click();

        cpo.Plus().click();
        cpo.Eight().click();

        cpo.Equals().click();


        Assert.assertEquals(cpo.getCalcResult(), "17");



    }

    @Test
    public void multiplication(){

        cpo.Nine().click();
        cpo.Multiply().click();
        cpo.Two().click();
        cpo.Equals().click();

        Assert.assertEquals(cpo.getCalcResult(), "18");

    }
    @Test
    public void move() throws InterruptedException {
        Actions move = new Actions(calcsession);

        move.clickAndHold(calcsession.findElementByAccessibilityId("AppName"))
                .moveByOffset(50, 50)
                .release()
                .build().perform();

    }

    @AfterClass
    public void tearDown(){
        calcsession.quit();
    }




}
