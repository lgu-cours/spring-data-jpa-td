package td9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookApplication {

	public static void main(String[] args) {
		System.out.println("TD9");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("td9/applicationContext.xml"); 

		Logger logger = (Logger) ac.getBean("logger");
		BookManager mgr = (BookManager) ac.getBean("bookManager");
		
		Book book = new Book();
		book.setId(10);
		book.setTitle("Germinal");
		//book.setAuthor("Zola");
		book.setPrice(12.45);
		book.setQuantity(5); // quantity = 5
		book.setAuthorId(1);
		book.setPublisherId(1);
		book.setIsbn("2253002860");
		
		// BookManager mgr
		mgr.save(book); // Save in database
		System.out.println("Book saved : " + book);
		
		mgr.addInStock(10, 2); // Stock : 5 + 2 
		Book book2 = mgr.load(10); // lecture en base
		// 
		System.out.println("Book loaded : " + book2); // quantity = 7
	}
	
}
