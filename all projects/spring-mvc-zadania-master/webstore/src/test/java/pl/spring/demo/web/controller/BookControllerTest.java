package pl.spring.demo.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pl.spring.demo.constants.ModelConstants;
import pl.spring.demo.constants.ViewNames;
import pl.spring.demo.controller.BookController;
import pl.spring.demo.enumerations.BookStatus;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

	@Mock
	private BookService bookService;

	@InjectMocks
	private BookController bookController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		Mockito.reset(bookService);

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		mockMvc = MockMvcBuilders.standaloneSetup(bookController).setViewResolvers(viewResolver).build();

	}

	@Test
	public void testShowAllBooksPage() throws Exception {
		// given
		BookTo testBook = new BookTo(1L, "Test title", "Test Author", BookStatus.FREE);
		Mockito.when(bookService.findAllBooks()).thenReturn(Arrays.asList(testBook));

		// attribute
		ResultActions resultActions = mockMvc.perform(get("/books/all"));
		// then
		resultActions.andExpect(view().name(ViewNames.BOOKS));
		//andExpect(model().attribute(ModelConstants.BOOK, testBook)) dodać 
	}

	@Test
	public void testShowInfoOfOneBook() throws Exception {
		// given
		BookTo testBook = new BookTo(1L, "Test title", "Test Author", BookStatus.FREE);
		Mockito.when(bookService.findBooksById(1L)).thenReturn(testBook);

		// attribute
		ResultActions resultActions = mockMvc.perform(get("/books/book?id=1"));
		// then
		resultActions.andExpect(view().name(ViewNames.BOOK))
				.andExpect(model().attribute(ModelConstants.BOOK, testBook));
	}

	@Test
	public void testDeleteOneBook() throws Exception {
		// given
		BookTo testBook = new BookTo(1L, "Test title", "Test Author", BookStatus.FREE);
		Mockito.when(bookService.findBooksById(1L)).thenReturn(testBook);

		// attribute
		ResultActions resultActions = mockMvc.perform(get("/books/deleteBook").param("id", "1")); // zmiana
		// then
		Mockito.verify(bookService).deleteBook(1L);
		resultActions.andExpect(view().name(ViewNames.DELETE))
				.andExpect(model().attribute(ModelConstants.BOOK, testBook));
	}

	@Test
	public void testShowSearchPageOfBook() throws Exception {
		// given

		// attribute
		ResultActions resultActions = mockMvc.perform(get("/books/search"));
		// then
		resultActions.andExpect(view().name(ViewNames.SEARCH));
	}

	@Test
	public void testShowPageWithFindBook() throws Exception {
		// given
		BookTo testBook = new BookTo(1L, "Test title", "Test Author", BookStatus.FREE);
		Mockito.when(bookService.findBooksByTitleAndAuthor("Test Author","Test title"))// autor/title
				.thenReturn(Arrays.asList(testBook));

		// attribute
		ResultActions resultActions = mockMvc.perform(
				get("/books/search/result").param("title", testBook.getTitle()).param("author", testBook.getAuthors()));
		// then
		resultActions.andExpect(view().name(ViewNames.BOOKS))
				.andExpect(model().attribute(ModelConstants.BOOK_LIST, Arrays.asList(testBook)));
	}

}
