package uz.brogrammers.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.brogrammers.bookstore.entity.Publisher;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
