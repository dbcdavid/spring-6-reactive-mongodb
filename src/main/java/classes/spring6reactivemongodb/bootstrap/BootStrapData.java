package classes.spring6reactivemongodb.bootstrap;

import classes.spring6reactivemongodb.domain.Beer;
import classes.spring6reactivemongodb.domain.Customer;
import classes.spring6reactivemongodb.repositories.BeerRepository;
import classes.spring6reactivemongodb.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class BootStrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        beerRepository.deleteAll()
                        .doOnSuccess(foo -> {
                            loadBeerData();
                        }).subscribe();

        customerRepository.deleteAll()
                .doOnSuccess(foo -> {
                    loadCustomerData();
                }).subscribe();
    }

    private void loadBeerData(){
        beerRepository.count().subscribe(count -> {
            if (count == 0) {
                Beer beer1 = Beer.builder()
                        .beerName("Galaxy Cat")
                        .beerStyle("PALE ALE")
                        .upc("12356")
                        .price(new BigDecimal("12.99"))
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .quantityOnHand(122)
                        .build();

                Beer beer2 = Beer.builder()
                        .beerName("Crank")
                        .beerStyle("PALE ALE")
                        .upc("12356222")
                        .price(new BigDecimal("11.99"))
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .quantityOnHand(392)
                        .build();

                Beer beer3 = Beer.builder()
                        .beerName("Sunshine City")
                        .beerStyle("IPA")
                        .upc("12356")
                        .price(new BigDecimal("13.99"))
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .quantityOnHand(144)
                        .build();

                beerRepository.save(beer1).subscribe();
                beerRepository.save(beer2).subscribe();
                beerRepository.save(beer3).subscribe();
            }
        });
    }

    private void loadCustomerData() {
        customerRepository.count().subscribe(count -> {
            if (count == 0) {
                Customer customer1 = Customer.builder()
                        .customerName("John")
                        .lastModifiedDate(LocalDateTime.now())
                        .createdDate(LocalDateTime.now())
                        .build();

                Customer customer2 = Customer.builder()
                        .customerName("Daenerys")
                        .lastModifiedDate(LocalDateTime.now())
                        .createdDate(LocalDateTime.now())
                        .build();

                Customer customer3 = Customer.builder()
                        .customerName("Tyrion")
                        .lastModifiedDate(LocalDateTime.now())
                        .createdDate(LocalDateTime.now())
                        .build();

                customerRepository.save(customer1).subscribe();
                customerRepository.save(customer2).subscribe();
                customerRepository.save(customer3).subscribe();
            }
        });
    }
}
