package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.checkerframework.checker.units.qual.A;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

public class DeleteBoardTests extends AppManager {
    @BeforeMethod(alwaysRun = true)
    public void loginCreateBoard() {
        User user = User.builder()
                .email("fortestqaproject@gmail.com")
                .password("Qapassword123!@#")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        Board board = Board.builder().boardTitle("12345").build();
        new BoardsPage(getDriver()).createNewBoard(board);

    }
    @Test
    public void deleteBoardPositiveTest(){
        new MyBoardPage(getDriver())
                .validateBoardName("12345", 5);
        new MyBoardPage(getDriver()).deleteBoard();
    }
}
