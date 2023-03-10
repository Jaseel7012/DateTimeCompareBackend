package productcom.example.productdemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import productcom.example.productdemo.DTO.ProductRepository;
import productcom.example.productdemo.Entity.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
public class ProductController {

    @Autowired
   private ProductRepository productRepository;
    @GetMapping("/viewall")
    public List<Product> getProduct(Product product){

        return (List<Product> ) productRepository.findAll();






    }
    @PostMapping("/add")
    public HashMap<String,String> addProduct(@RequestBody Product product) throws ParseException {
        HashMap<String,String> hm=new HashMap<>();
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       Date date_manufacture=sdf.parse(product.getManufactureDate());
       Date currentDate=new Date();
       LocalDateTime localDateTime=LocalDateTime.ofInstant(currentDate.toInstant(), ZoneId.systemDefault());
       Date today_date=Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(today_date+" "+date_manufacture);
        if(date_manufacture.compareTo(today_date)<=0){
            productRepository.save(product);
            hm.put("status","product aded");
            return hm;
        }else {
             hm.put("status","invalid manufacture date");
             return hm;
        }

    }
}
