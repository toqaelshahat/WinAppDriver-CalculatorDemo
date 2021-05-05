import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;

public class NotePad_PO {
    private WindowsDriver driver=null;
    public NotePad_PO(WindowsDriver wd){
        driver= wd;

    }
    public WebElement Maximize(){
        return driver.findElementByName("Maximize");

    }
    public WebElement Minimize(){
        return driver.findElementByName("Minimize");

    }
    public WebElement Close(){
        return driver.findElementByName("Close");

    }
    public WebElement menuFile(){
        return driver.findElementByName("File");

    }

    public WebElement textArea(){
        return driver.findElementByName("Text Editor");

    }
    public WebElement dialogSave(){
        return driver.findElementByName("Save");
    }

    public WebElement dialogDontSave(){
        return driver.findElementByName("Don't Save");
    }

    public WebElement dialogCancel(){
        return driver.findElementByName("Cancel");
    }
}
