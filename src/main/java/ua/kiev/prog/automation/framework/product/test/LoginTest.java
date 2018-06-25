package ua.kiev.prog.automation.framework.product.test;

import ua.kiev.prog.automation.framework.core.Test;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.LoginPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.MainPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.MainPageLoggedIn;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.UsersPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.blocks.*;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.dz.BoardPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.dz.TopicPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.widgets.UserWidget;

import java.util.List;

/**
 * ////////////////////////////////////////////////////////// *
 * Automation Framework                                       *
 * Automation Course for https://prog.kiev.ua/                *
 * ---------------------------------------------------------- *
 * Created by Yurii Voronenko                                 *
 * Email: yurii.voronenko@gmail.com                           *
 * ////////////////////////////////////////////////////////// *
 */
public class LoginTest extends Test
{

    @Override
    public String name()
    {
        return "Login to forum test";
    }

    @Override
    public void beforeTest()
    {
        // Вывод в консоль
        System.out.println("TEST: " + this.name() + " | PHASE: BEFORE RUN");
    }

    @Override
    public void test()
    {
        // Вывод в консоль
        System.out.println("TEST: " + this.name() + " | PHASE: TEST");

        // Получаем главную страницу
        MainPage mainPage   = Component.getSingleton(Forum.class).mainPage();
        // Переходим на страницу логина
        LoginPage loginPage = mainPage.getLoginPage();
        // Заходим на форум
        MainPageLoggedIn dashboard = loginPage.login("ivkua", "270494ii");
        // Подтверждаем что вход осуществлен
        this.assertSuccess(dashboard, "Login");
        // Выводим в консоль имя пользователя на форуме
        System.out.println("Name: " + dashboard.getUsername());

        // TODO домашнее задание
        BoardPage board = dashboard.getBoardPage("QA Automation");
        TopicPage topic = board.getTopicPage("QA Automation Tetris 14 02 2018");
        /*List<String> authors = topic.getAuthors();
        for (String author : authors) {
            System.out.println("Author: " + author);
        } */
        topic.topLinks().getSource();
        /*HelpPage helpPage = topic.topLinks().getHelp();
        System.out.println(helpPage.getHelpInfo());
        SearchPage searchPage = topic.topLinks().getSearch();
        searchPage.setSearch("QA");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
        topic.topLinks().getProfile(); */

        UsersPage usersPage = topic.topLinks().getUsers();
        String lookForUser = "Al3xander";
        UserWidget user = usersPage.findUser(lookForUser);
        System.out.println("User: " + lookForUser);
        System.out.println("Date of registration: " + user.getRegistrationDay());

        /*MassagePage massagePage = topic.topLinks().getMassage();
        System.out.println(massagePage.getMassages());
        topic.topLinks().getLogout();*/

        // Ждём 10 сек, с перехватом исключения на прерывание выполнения потока и игнорируем его
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) { /* Игнорируем */ }

    }

    @Override
    public void afterTest()
    {
        // Вывод в консоль
        System.out.println("TEST: " + this.name() + " | PHASE: AFTER RUN");
    }
}
