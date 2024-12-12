package classes.spring6reactivemongodb.repositories;

import classes.spring6reactivemongodb.domain.Beer;
import classes.spring6reactivemongodb.domain.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

    Flux<Customer> findByCustomerName(String customerName);

    Mono<Customer> findFirstByCustomerName(String customerName);
}
