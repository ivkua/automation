package ua.kiev.prog.automation.framework;

import ua.kiev.prog.automation.framework.product.app.ProgKievUa;

public class App
{
    static private boolean _standalone;

    static public boolean inStandalone() {
        return _standalone;
    }

    static public void main(String[] args) {
            if (args.length > 0 && args[0].equals("standalone")) {
                _standalone = true;
            }

            System.setProperty("webdriver.chrome.driver", "/home/iree/ChromeDriver/chromedriver");

            ProgKievUa product = new ProgKievUa();
            product.forum().setURL("https://prog.kiev.ua/forum");
            product.runTests();

    }
}
