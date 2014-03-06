package notes.htmlunit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;

import notes.testcategories.DeployTest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@Category(DeployTest.class)
public class HTMLUnitTest {

    @Test
    public void test() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        final WebClient webClient = new WebClient();
        final HtmlPage page = webClient.getPage("http://localhost:8080/rest-service/");
        assertEquals("Slim Framework for PHP 5", page.getTitleText());

        final String pageAsXml = page.asXml();
        assertTrue(pageAsXml.contains("<header>"));

        final String pageAsText = page.asText();
        assertTrue(pageAsText.contains("Congratulations! Your Slim application is running. If this is your first time using Slim"));

        webClient.closeAllWindows();
    }

}
