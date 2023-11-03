package uz.brogrammers.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.brogrammers.bookstore.entity.Author;
import uz.brogrammers.bookstore.entity.Book;
import uz.brogrammers.bookstore.repository.AuthorRepository;
import uz.brogrammers.bookstore.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    public Iterable<Author> getAll() {
        return authorRepository.findAll();
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    public void deleteById(Long id) {
        authorRepository.findById(id).ifPresent(author -> {
            List<Book> books = bookRepository.findByAuthors(author);
            books.stream()
                    .forEach(book -> {
                        book.getAuthors().remove(author);
                        bookRepository.save(book);
                    });
        });

        authorRepository.deleteById(id);
    }

}
