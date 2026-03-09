package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.File;

public class AtlassianProfilePage extends BasePage {
    public AtlassianProfilePage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements
                (new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//div[@data-test-selector='profile-hover-info']")
    WebElement btnProfilePhoto;

    @FindBy(xpath = "//button[@data-testid='change-avatar']")
    WebElement btnChangeAvatar;

    @FindBy(xpath = "//input[@data-testid='image-navigator-input-file']")
    WebElement inputUploadPhoto;
    @FindBy(xpath = "//button[@class='css-u9eekp']")
    WebElement btnUploadPhoto;
    @FindBy(xpath = "//div[@class='_kqsw1n9t _1pbyxejw _u7cooahv _1e021epz _1iafidpf _il0widpf']")
    WebElement popUpMessage;
    @FindBy(xpath = "//h2[@class='_1mouidpf _1dyz4jg8 _1p1dglyw _11c8140y _syaz15cr']")
    WebElement popUpWrongFormatFile;


    public void changeMyProfilePhoto(String photoPath){
        Actions actions = new Actions(driver);
        //actions.scrollToElement(btnProfilePhoto).pause(2000).click().perform();
        // 1. Убеждаемся, что доскроллили и элемент кликабелен
        actions.moveToElement(btnProfilePhoto).click().perform();

        // 2. Добавляем явную проверку на наличие iframe (если он есть)
        // driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[your-selector]")));

        clickWait(btnChangeAvatar,10);
        File photo = new File(photoPath);
        inputUploadPhoto.sendKeys(photo.getAbsolutePath());
        clickWait(btnUploadPhoto,10);

        // Если переключались во фрейм, возвращаемся назад:
        // driver.switchTo().defaultContent();
    }
    public boolean validateMassage(String text){
        return validateTextInElementWait(popUpMessage,text,10);
    }
    public boolean validateWrongFormatFileMassage(String text){
        return validateTextInElementWait(popUpWrongFormatFile,text,10);
    }




}
