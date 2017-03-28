package pl.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.spring.demo.constants.ModelConstants;
import pl.spring.demo.constants.ViewNames;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

/**
 * Book controller
 * 
 * @author mmotowid
 *
 */
@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping
	public String list(Model model) {
		model.addAttribute(ModelConstants.BOOK_LIST, bookService.findAllBooks());
		return ViewNames.BOOKS;
	}

	/**
	 * Method collects info about all books
	 */
	@RequestMapping("/all")
	public ModelAndView allBooks() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject(ModelConstants.BOOK_LIST, bookService.findAllBooks());
		modelAndView.setViewName(ViewNames.BOOKS);
		return modelAndView;
	}

	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String infoBook(@RequestParam("id") long Id, Model model) {
		model.addAttribute(ModelConstants.BOOK, bookService.findBooksById(Id));
		return ViewNames.BOOK;
	}

	@RequestMapping(value = "/deleteBook")
	public String deleteBook(long id, Model model) {
		BookTo book = bookService.findBooksById(id);
		bookService.deleteBook(id);
		model.addAttribute(ModelConstants.BOOK, book);
		return ViewNames.DELETE;
	}

	@RequestMapping(value = "/search")
	public String searchBook(Model model) {
		return ViewNames.SEARCH;
	}

	@RequestMapping(value = "/search/result")
	public String findBook(Model model, @RequestParam("title") String title, @RequestParam("author") String author) {
		List<BookTo> findBooksByTitleAndAuthor = bookService.findBooksByTitleAndAuthor(author, title);
		if (!findBooksByTitleAndAuthor.isEmpty()) {
			model.addAttribute(ModelConstants.BOOK_LIST, findBooksByTitleAndAuthor);

			return ViewNames.BOOKS;
		}

		return ViewNames.NOTFIND;
	}

	/**
	 * Binder initialization
	 */
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("id", "title", "authors", "status");
	}

}
