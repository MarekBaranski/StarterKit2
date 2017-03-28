package pl.spring.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

@Controller
@ResponseBody
public class BookRestController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/allBooks", method = RequestMethod.GET)
    public List<BookTo> findAllBooks() {
                   return bookService.findAllBooks();
    }

    @RequestMapping(value = "/author/{author}", method = RequestMethod.GET)
    public List<BookTo> findBooksByAuthor(@PathVariable String author) {
                   return bookService.findBooksByAuthor(author);
    }

    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
    public List<BookTo> findBooksByTitle(@PathVariable String title) {
                   return bookService.findBooksByTitle(title);
    }

    @RequestMapping(value = "/title/{title}/author/{author}", method = RequestMethod.GET)
    public List<BookTo> findBooksByTitleByAuthor(@PathVariable String title, @PathVariable String author) {
                   return bookService.findBooksByTitleAndAuthor(author,title);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public BookTo findBooksByID(@PathVariable Long id) {
                   return bookService.findBooksById(id);
    }
	
	
	
}
