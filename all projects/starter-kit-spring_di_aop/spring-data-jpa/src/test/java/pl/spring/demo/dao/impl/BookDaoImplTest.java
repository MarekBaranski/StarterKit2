package pl.spring.demo.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.to.BookTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class BookDaoImplTest {

	@Autowired
	private BookDao bookDao;

	@Test
	public void shouldSaveBookWithNextId() {
		// given
		BookTo book = new BookTo(null, "title", "author");
		long sizeList = bookDao.findAll().size();
		// when
		bookDao.save(book);
		// then
		long newSize = bookDao.findAll().size();
		assertEquals(sizeList + 1, newSize);
		assertTrue(bookDao.findAll().contains(book));
	}

	@Test
	public void shouldTestIfMethodSaveAddNewBook() {
		// given
		BookTo book = new BookTo(null, "title", "author");
		// when
		bookDao.save(book);
		// then
		long newId = book.getId();

		assertEquals(7L, newId);

	}

}
