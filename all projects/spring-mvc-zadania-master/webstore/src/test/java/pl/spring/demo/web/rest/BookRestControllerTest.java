package pl.spring.demo.web.rest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pl.spring.demo.enumerations.BookStatus;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class BookRestControllerTest {

	@Autowired
	private BookService bookService;
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		Mockito.reset(bookService);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testShouldGetBooks() throws Exception {

		// given:
		final BookTo bookTo1 = new BookTo(1L, "title", "Author1", BookStatus.FREE);

		// register response for bookService.findAllBooks() mock
		Mockito.when(bookService.findAllBooks()).thenReturn(Arrays.asList(bookTo1));
		// when
		ResultActions response = this.mockMvc.perform(get("/allBooks").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content("1"));

		response.andExpect(status().isOk())//
				.andExpect(jsonPath("[0].id").value(bookTo1.getId().intValue()))
				.andExpect(jsonPath("[0].title").value(bookTo1.getTitle()))
				.andExpect(jsonPath("[0].authors").value(bookTo1.getAuthors()));
	}
	
	@Test
	public void testShouldGetBookByAuthor() throws Exception {

		// given:
		final BookTo bookTo1 = new BookTo(1L, "title", "Author1", BookStatus.FREE);

		
		Mockito.when(bookService.findBooksByAuthor(bookTo1.getAuthors())).thenReturn(Arrays.asList(bookTo1));
		// when
		ResultActions response = this.mockMvc.perform(get("/author/Author1").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content("1"));

		response.andExpect(status().isOk())//
				.andExpect(jsonPath("[0].id").value(bookTo1.getId().intValue()))
				.andExpect(jsonPath("[0].title").value(bookTo1.getTitle()))
				.andExpect(jsonPath("[0].authors").value(bookTo1.getAuthors()));
	}
	
	@Test
	public void testShouldGetBookByTitle() throws Exception {

		// given:
		final BookTo bookTo1 = new BookTo(1L, "title", "Author1", BookStatus.FREE);

		
		Mockito.when(bookService.findBooksByAuthor(bookTo1.getTitle())).thenReturn(Arrays.asList(bookTo1));
		// when
		ResultActions response = this.mockMvc.perform(get("/author/title").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content("1"));

		response.andExpect(status().isOk())//
				.andExpect(jsonPath("[0].id").value(bookTo1.getId().intValue()))
				.andExpect(jsonPath("[0].title").value(bookTo1.getTitle()))
				.andExpect(jsonPath("[0].authors").value(bookTo1.getAuthors()));
	}
	
	@Test
	public void testShouldGetBookByTitleAndAuthor() throws Exception {

		// given:
		final BookTo bookTo1 = new BookTo(1L, "title", "Author1", BookStatus.FREE);

		
		Mockito.when(bookService.findBooksByTitleAndAuthor(bookTo1.getAuthors(),bookTo1.getTitle())).thenReturn(Arrays.asList(bookTo1));
		// when
		ResultActions response = this.mockMvc.perform(get("/title/title/author/Author1").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content("1"));

		response.andExpect(status().isOk())//
				.andExpect(jsonPath("[0].id").value(bookTo1.getId().intValue()))
				.andExpect(jsonPath("[0].title").value(bookTo1.getTitle()))
				.andExpect(jsonPath("[0].authors").value(bookTo1.getAuthors()));
	}
	
	@Test
	public void testShouldGetBookById() throws Exception {

		// given:
		final BookTo bookTo1 = new BookTo(1L, "title", "Author1", BookStatus.FREE);

		
		Mockito.when(bookService.findBooksById(bookTo1.getId())).thenReturn(bookTo1);
		// when
		ResultActions response = this.mockMvc.perform(get("/id/1").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content("1"));

		response.andExpect(status().isOk())//
				.andExpect(jsonPath("$.id").value(bookTo1.getId().intValue()))
				.andExpect(jsonPath("$.title").value(bookTo1.getTitle()))
				.andExpect(jsonPath("$.authors").value(bookTo1.getAuthors()));
	}
	
}
