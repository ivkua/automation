package ua.kiev.prog.automation.framework.product.app.progkievua.forum.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.base.ForumPageObject;

import java.util.List;

public class HelpPage extends ForumPageObject {
    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator() {
        return By.xpath("//div[@id='helpmain']");
    }

    public String getHelpInfo() {
        List<WebElement> helpInfo = driver().findElements(By.xpath("//div[@id='helpmain']/p"));
        StringBuilder stringBuilder = new StringBuilder();
        for (WebElement element : helpInfo) {
            stringBuilder.append(element.getText()).append("\n");
        }
        return stringBuilder.toString();
    }
}
