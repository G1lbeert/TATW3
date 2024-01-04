import org.junit.jupiter.api.Test;

public class BrowseProjectTests {

    BrowseProjectPage browseProjectPage = new BrowseProjectPage();


    @Test
    void canBrowseProjects() throws InterruptedException {
        browseProjectPage.browseIssue();
        browseProjectPage.closeBrowser();
    }

}
