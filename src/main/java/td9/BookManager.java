package td9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookManager {
	private Logger logger;
	private BookDAO dao;

	@Autowired
	public BookManager(Logger logger, BookDAO dao) {
		this.logger = logger;
		this.dao = dao;
	}

	public boolean addInStock(int bookId, int number) {
		logger.log("add in stock");
		Book book = dao.findOne(bookId);
		if (book != null) {
			book.setQuantity(book.getQuantity() + number);
			dao.save(book);
			return true;
		} else {
			return false;
		}
	}

	public Book load(int bookId) {
		return dao.findOne(bookId);
	}

	public void save(Book book) {
		dao.save(book);
	}

}
