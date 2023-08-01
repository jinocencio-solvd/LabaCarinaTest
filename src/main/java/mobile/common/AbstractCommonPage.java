package mobile.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractCommonPage extends AbstractPage implements IMobileUtils {

    protected final String UNSUPPORTED_IOS_OPERATION = "Page operation not supported on ios";
    protected final int MAX_SWIPES = 8;

    public AbstractCommonPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        throw new UnsupportedOperationException("Method .isOpened() not supported for this page");
    }

}
