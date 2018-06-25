package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.base.ForumPageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.widgets.UserWidget;

import java.util.ArrayList;
import java.util.List;

public class UsersPage extends ForumPageObject {
    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator() {
        return By.xpath("//div[@id='content_section']");
    }

    public UserWidget findUser(String userName) {
        //colect record
        List<WebElement> list = this.driver().findElements(By.xpath("//div[@id='mlist']/table//tbody/tr"));
        List<UserWidget> userList = new ArrayList<>();
        for (int i = 1; i <= list.size(); i++) {
            userList.add(new UserWidget(this.driver(), By.xpath("//div[@id='mlist']/table//tbody/tr["+i+"]")));
        }
        //find user name
        UserWidget resultUser = null;

        for (UserWidget user : userList) {
            if (userName.equals(user.getUserName())) {
                resultUser = user;
                break;
            }
        }
        // recursion if not found
        if (resultUser == null) {
            WebElement nextPage = this.driver().findElement(By.xpath("(//div[contains(@class, 'pagelinks')]//strong/following-sibling::a)[1]"));
            nextPage.click();
            return this.findUser(userName);
        }
        return resultUser;
    }


}
