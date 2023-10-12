import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class testBookService {
    @Test
    void testFindById() {
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.findById("1")).thenReturn(new Book("1"));
        BookService bookService = new BookService(bookRepository);
        assertEquals("1", bookService.findBookById("1").getId());
    }
    @Test
    void testFindAll() {
        BookRepository bookRepository = mock(BookRepository.class);
        InMemoryBookRepository inMemoryBookRepository = new InMemoryBookRepository();
        when(bookRepository.findAll()).thenReturn(inMemoryBookRepository.findAll());
        BookService bookService = new BookService(bookRepository);
        assertEquals(inMemoryBookRepository.findAll(), bookService.findAllBooks());
    }
}
