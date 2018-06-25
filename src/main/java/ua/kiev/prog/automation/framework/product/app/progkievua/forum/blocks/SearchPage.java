package ua.kiev.prog.automation.framework.product.app.progkievua.forum.blocks;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.widget.Button;
import ua.kiev.prog.automation.framework.core.product.component.object.widget.TextBox;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.base.ForumPageObject;

public class SearchPage extends ForumPageObject {
    private Button searchButton = new Button(driver(), By.xpath("//input[@name='submit']"));
    private TextBox inputText = new TextBox(driver(), By.xpath("//input[@name='search']"));

    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator() {
        return By.xpath("//fieldset[@id='advanced_search']");
    }

    public void setSearch(String value) {
        inputText.setValue(value);
        searchButton.push();
    }
}
