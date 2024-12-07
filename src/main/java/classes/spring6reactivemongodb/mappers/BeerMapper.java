package classes.spring6reactivemongodb.mappers;

import classes.spring6reactivemongodb.domain.Beer;
import classes.spring6reactivemongodb.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer beerDTOToBeer(BeerDTO beerDTO);

    BeerDTO beerToBeerDTO(Beer beer);
}
