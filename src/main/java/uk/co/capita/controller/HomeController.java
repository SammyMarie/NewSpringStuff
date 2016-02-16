package uk.co.capita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.co.capita.service.MarcRead;

/**
 * Created by smlif on 31/01/2016.
 */
@Controller
public class HomeController {

    private final MarcRead marcRead;

    @Autowired
    public HomeController(MarcRead marcRead){
        this.marcRead = marcRead;
    }

    @RequestMapping(value = "/")
    public String indexPage(){
        return "index";
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String searchPage(){
        return "searchBooks";
    }

    @RequestMapping(value = "/booksDisplay")
    public ModelAndView displayPage(ModelAndView model, @RequestParam("author") String author){

        model.addObject("books", marcRead.xmlReader(author));
        model.setViewName("booksDisplay");
        return  model;
    }
}
