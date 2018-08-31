package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.base.ForumPageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.dz.BoardPage;

public class MainPageLoggedIn  extends ForumPageObject
{
    @Override
    protected Class<? extends Component> componentClass()
    {
        return Forum.class;
    }

    @Override
    protected By readyLocator()
    {
        return By.xpath("//div[@id='boardindex_table']");
    }

    private By _usernameText = By.xpath("//div[@class='user_block']//a[contains(@href,'?action=profile')]/span");

    final public String getUsername ()
    {
        return this.component().session().driver().findElement(_usernameText).getText();
    }

    final public BoardPage getBoardPage (String boardName)
    {
        By boardLink = By.xpath("//table[@class='table_list']//a[@class='subject' and contains(text(), '"+boardName+"')]");
        WebElement board = this.driver().findElement(boardLink);
        board.click();

        return new BoardPage();
    }
}
