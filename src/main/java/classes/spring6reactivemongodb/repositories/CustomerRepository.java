package classes.spring6reactivemongodb.repositories;

import classes.spring6reactivemongodb.domain.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
}
