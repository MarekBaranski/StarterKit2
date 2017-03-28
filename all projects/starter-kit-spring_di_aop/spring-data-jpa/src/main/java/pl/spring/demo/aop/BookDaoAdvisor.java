package pl.spring.demo.aop;

import org.springframework.aop.MethodBeforeAdvice;
import pl.spring.demo.annotation.NullableId;
import pl.spring.demo.common.Sequence;
import pl.spring.demo.dao.BookDao;
import pl.spring.demo.exception.BookNotNullIdException;
import pl.spring.demo.to.BookTo;
import pl.spring.demo.to.IdAware;

import java.lang.reflect.Method;

public class BookDaoAdvisor implements MethodBeforeAdvice {

	private Sequence sequence;

	@Override
	public void before(Method method, Object[] objects, Object o) throws Throwable {

		if (hasAnnotation(method, o, NullableId.class)) {
			checkNotNullId(objects[0]);

			if (objects[0] instanceof IdAware) {
				setBookID((BookTo) objects[0], (BookDao) o);
			}
		}
	}

	private void checkNotNullId(Object o) {
		if (o instanceof IdAware && ((IdAware) o).getId() != null) {
			throw new BookNotNullIdException();
		}
	}

	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}

	private void setBookID(BookTo bookTo, BookDao bookDao) {
		if (bookTo.getId() == null) {
			long a = sequence.nextValue(bookDao.findAll());
			bookTo.setId(a);
		}
	}

	private boolean hasAnnotation(Method method, Object o, Class annotationClazz) throws NoSuchMethodException {
		boolean hasAnnotation = method.getAnnotation(annotationClazz) != null;

		if (!hasAnnotation && o != null) {
			hasAnnotation = o.getClass().getMethod(method.getName(), method.getParameterTypes())
					.getAnnotation(annotationClazz) != null;
		}
		return hasAnnotation;
	}
}
