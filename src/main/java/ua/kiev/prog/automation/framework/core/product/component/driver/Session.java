package ua.kiev.prog.automation.framework.core.product.component.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import ua.kiev.prog.automation.framework.App;

import java.net.MalformedURLException;
import java.net.URL;

public class Session {
    private RemoteWebDriver _driver;

    public Session (){}

    final public RemoteWebDriver driver ()
    {
        if (this._driver == null) {
            if (App.inStandalone()) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName("chrome");
                try {
                    this._driver = new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"), cap);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            } else {
                this._driver = new ChromeDriver();
            }

        }
        return this._driver;
    }

    final public void close ()
    {
        if (this._driver != null) {
            this._driver.quit();
        }
        this._driver = null;
    }
}
