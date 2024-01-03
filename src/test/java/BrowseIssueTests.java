import org.junit.jupiter.api.Test;

public class BrowseIssueTests {

    BrowseIssuePage browseIssuePage = new BrowseIssuePage();

    @Test
    void canBrowseIssues() throws InterruptedException {
        browseIssuePage.browseIssue();
        browseIssuePage.closeBrowser();
    }

}
