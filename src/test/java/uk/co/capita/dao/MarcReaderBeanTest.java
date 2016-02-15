package uk.co.capita.dao;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by smlif on 09/02/2016.
 */
public class MarcReaderBeanTest {

    private MarcReaderBean marcReaderBean;
    private String author;

    @Before
    public void setUp(){
        marcReaderBean = new MarcReaderBean();
        author = "Iain";
    }

    @Test
    public void checkXmlReader(){

        assertThat(marcReaderBean.xmlReader(author)).isNotEmpty();
        assertThat(marcReaderBean.xmlReader(author).size()).isBetween(10, 18);
    }
}
