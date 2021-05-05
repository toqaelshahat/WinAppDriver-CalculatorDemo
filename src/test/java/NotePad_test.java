import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class NotePad_test {
    private WindowsDriver notepad = null;
    private NotePad_PO nppo=null;
    @BeforeClass
    public void setup(){
        System.out.println("setup");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Windows\\system32\\notepad.exe");
        try {
            notepad = new WindowsDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            nppo = new NotePad_PO(notepad);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
    @AfterClass
    public void teardown(){
        notepad.quit();

    }
    @Test
    public void testnotepad(){
        nppo.textArea().sendKeys("Hello world!");
        Assert.assertEquals(nppo.textArea().getText(), "Hello world!");
        nppo.textArea().sendKeys(Keys.ALT, Keys.F4);
        nppo.dialogCancel().click();
        nppo.textArea().sendKeys(Keys.ALT,Keys.F4);
        nppo.dialogDontSave().click();
    }



}
