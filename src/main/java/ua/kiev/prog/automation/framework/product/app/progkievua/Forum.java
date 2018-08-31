package ua.kiev.prog.automation.framework.product.app.progkievua;

import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.PageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.MainPage;

import java.util.Map;

public class Forum extends Component
{
    @Override
    protected String name()
    {
        return "Forum"; 
    }

    final public MainPage mainPage()
    {
        return new MainPage();
    }
}
