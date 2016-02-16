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
        assertThat(marcRead.xmlReader("Banks").size()).isBetween(10, 18);
        assertThat(marcRead.xmlReader("Iain M. Banks").get(0).getAuthorName()).isEqualTo("Banks, Iain.");
    }

    @Test
    public void checkDisplayHasBookList(){
        assertThat(controller.displayPage(model, "Iain")).isNotNull();
        assertThat(model.getViewName()).isEqualTo("booksDisplay");
    }
}
