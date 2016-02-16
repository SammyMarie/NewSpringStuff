package uk.co.capita.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import uk.co.capita.dao.MarcReaderBean;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by smlif on 09/02/2016.
 */
public class HomeControllerTest {

    private HomeController controller;
    private ModelAndView model;
    private MarcReaderBean marcRead;

    @Before
    public void setUp(){
        marcRead = new MarcReaderBean();
        controller = new HomeController(marcRead);
        model = new ModelAndView();
    }

    @Test
    public void checkConstructorIsNotEmpty(){
        String authorName = "Banks";
        String authorNameTwo = "Iain M. Banks";
        assertThat(marcRead.xmlReader(authorName).size()).isBetween(10, 18);
        assertThat(marcRead.xmlReader(authorNameTwo).get(0).getAuthorName()).isEqualTo("Banks, Iain.");
    }

    @Test
    public void checkDisplayHasBookList(){
        String authorName = "Iain";
        assertThat(controller.displayPage(model, authorName)).isNotNull();
        assertThat(model.getViewName()).isEqualTo("booksDisplay");
    }

    @Test
    public void checkIndexViewName(){
        controller.indexPage(model);
        assertThat(model.getViewName()).isEqualTo("index");
    }

    @Test
    public void checkSearchViewName(){
        controller.searchPage(model);
        assertThat(model.getViewName()).isEqualTo("searchBooks");
    }
}
