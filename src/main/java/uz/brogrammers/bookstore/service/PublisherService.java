package uz.brogrammers.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.brogrammers.bookstore.entity.Publisher;
import uz.brogrammers.bookstore.repository.PublisherRepository;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public Iterable<Publisher> getAll() {
        return publisherRepository.findAll();
    }

}
