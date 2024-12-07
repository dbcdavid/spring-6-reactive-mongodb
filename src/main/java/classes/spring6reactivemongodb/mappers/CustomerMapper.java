package classes.spring6reactivemongodb.mappers;

import classes.spring6reactivemongodb.domain.Customer;
import classes.spring6reactivemongodb.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDTOToCustomer(CustomerDTO customerDTO);

    CustomerDTO customerToCustomerDTO(Customer customer);
}
