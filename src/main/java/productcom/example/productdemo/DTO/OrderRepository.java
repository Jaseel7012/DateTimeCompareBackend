package productcom.example.productdemo.DTO;

import org.springframework.data.repository.CrudRepository;
import productcom.example.productdemo.Entity.Order;

public interface OrderRepository extends CrudRepository<Order,Integer> {
}
