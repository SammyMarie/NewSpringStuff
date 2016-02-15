package uk.co.capita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uk.co.capita.service.MarcRead;

/**
 * Created by smlif on 31/01/2016.
 */
@Controller
public class HomeController {

    @Autowired
    private MarcRead marcRead;

    @RequestMapping(value = "/")
    public String indexPage(){
        return "index";
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String searchPage(){
        return "searchBooks";
    }

    @RequestMapping(value = "/booksDisplay")
    public String displayPage(Model model, @RequestParam("author") String author){

        model.addAttribute("books", marcRead.xmlReader(author));
        return "booksDisplay";
    }
}
