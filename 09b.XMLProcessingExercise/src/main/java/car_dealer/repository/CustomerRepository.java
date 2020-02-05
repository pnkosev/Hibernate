package car_dealer.repository;

import car_dealer.domain.dto.exportDTO.CustomerPurchaseDTO;
import car_dealer.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select c from Customer as c " +
            "order by c.birthDate, c.isYoungDriver")
    List<Customer> findAllOrderedByBirthDateAscAndYoungDriver();

    @Query(value = "select new car_dealer.domain.dto.exportDTO.CustomerPurchaseDTO( " +
            "c.name, c.purchases.size, sum(pa.price)) " +
            "from Customer as c " +
            "join c.purchases as p " +
            "join p.car as ca " +
            "join ca.parts as pa " +
            "where c.purchases.size > 0 " +
            "group by c.id " +
            "order by sum(pa.price) desc, c.purchases.size desc")
    List<CustomerPurchaseDTO> findAllCustomersWithAtLeastOnePurchase();
}
