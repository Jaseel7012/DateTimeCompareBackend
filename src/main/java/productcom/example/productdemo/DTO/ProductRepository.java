package productcom.example.productdemo.DTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import productcom.example.productdemo.Entity.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {

}
