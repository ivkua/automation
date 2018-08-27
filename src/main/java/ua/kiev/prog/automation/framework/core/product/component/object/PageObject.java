package ua.kiev.prog.automation.framework.core.product.component.object;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.kiev.prog.automation.framework.core.product.Component;

abstract public class PageObject<T extends PageObject>{
    private Component _component;

    protected PageObject () {
        Class<? extends Component> componentClass = this.componentClass();
        if (componentClass == null)
            throw new RuntimeException("Method componentClass returns null. Class: " + this.getClass().getName());
        
        this._component = Component.getSingleton(componentClass);
        
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        this.waitReadyLocator();
    }

    protected Component component() {
        return this._component;
    }

    abstract protected Class<? extends Component> componentClass();

    abstract protected By readyLocator ();

    private void waitReadyLocator ()
    {
        try {
            RemoteWebDriver driver  = this.component().session().driver(); 
            By readyLocator         = this.readyLocator();                  
            WebDriverWait wait      = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(readyLocator));
        } catch (Exception e) {}
    }

    final public boolean success (){
        boolean result;
        try {
            result = this.component().session().driver().findElement(this.readyLocator()).isDisplayed();
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public RemoteWebDriver driver ()
    {
        return this.component().session().driver();
    }
}
