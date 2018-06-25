package ua.kiev.prog.automation.framework;

import ua.kiev.prog.automation.framework.product.app.ProgKievUa;

public class App
{
    static public void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "/home/iree/ChromeDriver/chromedriver");

        ProgKievUa product = new ProgKievUa();
        product.forum().setURL("https://prog.kiev.ua/forum");
        product.runTests();

    }
}
